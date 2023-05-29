import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.vision.v1.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.type.LatLng;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class LandmarksApp {

    private static AtomicBoolean messageReceived = new AtomicBoolean(false);
    final static int ZOOM = 15; // Streets
    final static String SIZE = "600x300";
    private static final String api_key = "AIzaSyAwcJduofj_45TFdSbyS4bLicv2DZmR_TA";
    private static final String projectID = "cn2223-t3-g05";
    private static final String subscriptionId = "tfPubSubTopic-sub";


    public static void main(String[] args) throws Exception {

        // Define the Pub/Sub subscription details

        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectID, subscriptionId);

        // Create the Pub/Sub subscriber
        Subscriber subscriber = Subscriber.newBuilder(subscriptionName, (MessageReceiver) (message, consumer) -> {
            // Process the message

            JsonObject jsonObject = new Gson().fromJson(message.getData().toStringUtf8(), JsonObject.class);

            // Extract attributes from the JSON object
            String bucketName = jsonObject.get("bucketName").getAsString();
            String blobName = jsonObject.get("blobName").getAsString();
            String blobGsPath = "gs://"+bucketName+"/" + blobName;
            try {
                detectLandmarksGcs(blobGsPath, api_key);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Set the flag to indicate a message is received
            messageReceived.set(true);

            // Acknowledge the message
            consumer.ack();
        }).build();

        // Start the subscriber
        subscriber.startAsync().awaitRunning();

        // Wait until a message is received
        while (true) {
            if (messageReceived.get()) {
                // Reset the flag for the next message
                messageReceived.set(false);
            }
            Thread.sleep(1000);
        }
    }



    // Detects landmarks in the specified remote image on Google Cloud Storage.
    public static void detectLandmarksGcs(String blobGsPath, String apiKey) throws IOException {
        System.out.println("Detecting landmarks for: " + blobGsPath);
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(blobGsPath).build();
        Image img = Image.newBuilder().setSource(imgSource).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.LANDMARK_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return;
                }

                System.out.println("Landmarks list size: " + res.getLandmarkAnnotationsList().size());
                // For full list of available annotations, see http://g.co/cloud/vision/docs
                boolean first = true; // Only get map for first annotation
                for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
                    LocationInfo info = annotation.getLocationsList().listIterator().next();
                    System.out.format("Landmark: %s(%f)%n %s%n",
                            annotation.getDescription(),
                            annotation.getScore(),
                            info.getLatLng());
                    if (first) {
                        getStaticMapSaveImage(info.getLatLng(), apiKey);
                        first = false;
                    }
                }
            }
        }
    }

    private static void getStaticMapSaveImage(LatLng latLng, String apiKey) {
        String mapUrl = "https://maps.googleapis.com/maps/api/staticmap?"
                + "center=" + latLng.getLatitude() + "," + latLng.getLongitude()
                + "&zoom=" + ZOOM
                + "&size=" + SIZE
                + "&key=" + apiKey;
        System.out.println(mapUrl);
        try {
            URL url = new URL(mapUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = conn.getInputStream();
            BufferedInputStream bufIn = new BufferedInputStream(in);
            FileOutputStream out = new FileOutputStream("static_map_"+ UUID.randomUUID() +".png");
            byte[] buffer = new byte[8*1024];
            int bytesRead;
            while ((bytesRead = bufIn.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            bufIn.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
