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


public class LandmarksApp {

    final static int ZOOM = 15; // Streets
    final static String SIZE = "600x300";
    private static final String api_key = "AIzaSyAwcJduofj_45TFdSbyS4bLicv2DZmR_TA";
    private static final String projectID = "cn2223-t3-g05";
    private static final String subscriptionId = "tf-msg-topic-sub";


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
            String identifier = jsonObject.get("identifier").getAsString();
            System.out.println(bucketName+blobName+identifier);
            try {
                LandmarkDetector.detectLandmarksGcs(bucketName, blobName, "static_maps_storage", "requests_information", identifier);

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Acknowledge the message
            consumer.ack();
        }).build();

        // Start the subscriber
        subscriber.startAsync().awaitRunning();

        // Wait until a message is received
        while (true) {

            Thread.sleep(1000);
        }
    }
}




