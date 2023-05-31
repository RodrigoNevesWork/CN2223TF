import com.google.cloud.vision.v1.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




public class LandmarkDetector {

    final static String APIKEY = "AIzaSyAwcJduofj_45TFdSbyS4bLicv2DZmR_TA";
    final static int ZOOM = 15; // Streets
    final static String SIZE = "600x300";
    // Considera-se que o nomes de imagens correspondem aos nomes de BLOB
    // existentes num bucket de nome BUCKET_NAME no Storage do Projeto


    // Detects landmarks in the specified remote image on Google Cloud Storage.
    public static void detectLandmarksGcs(String bucketTosearch,String blobName,String bucketToSave, String collectionName, String docName) throws IOException {

        String blobGsPath = "gs://"+bucketTosearch+"/" + blobName;

        System.out.println("Detecting landmarks for: " + blobGsPath);

        List<AnnotateImageRequest> requests = new ArrayList<>();

        ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(blobGsPath).build();
        Image img = Image.newBuilder().setSource(imgSource).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.LANDMARK_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            boolean first = true;
            String randomName = UUID.randomUUID().toString();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return;
                }

                System.out.println("Landmarks list size: " + res.getLandmarkAnnotationsList().size());

                List<AnaliseResult> analiseResults = new ArrayList<>();


                for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
                    LocationInfo info = annotation.getLocationsList().listIterator().next();

                    Coordinates coordinates = new Coordinates(info.getLatLng().getLatitude(),info.getLatLng().getLatitude() );

                    AnaliseResult analiseResult = new AnaliseResult(
                            annotation.getDescription(),
                            annotation.getScore(),
                            coordinates);

                    if(first){
                        getStaticMapSaveImage(bucketToSave,randomName,analiseResult.getCoordenates());
                        first = false;
                    }

                    analiseResults.add(analiseResult);

                    System.out.println(analiseResult);

                }

                FireStoreDocument fbd = new FireStoreDocument(analiseResults,randomName);

                FireStoreUtils.useInsert(
                        collectionName,
                        docName,
                        fbd
                        );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getStaticMapSaveImage(String bucketName, String blobID, Coordinates latLng) {
        String mapUrl = "https://maps.googleapis.com/maps/api/staticmap?"
                + "center=" + latLng.getLatitude() + "," + latLng.getLongitude()
                + "&zoom=" + ZOOM
                + "&size=" + SIZE
                + "&key=" + APIKEY;
        System.out.println(mapUrl);
        try {

            URL url = new URL(mapUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream in = conn.getInputStream();

            GoogleCloudStorageUtils gcs = new GoogleCloudStorageUtils();

            gcs.uploadBlobToBucket(bucketName,blobID,in.readAllBytes());

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}