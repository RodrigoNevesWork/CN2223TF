import CNcontract.CNcontractGrpc;
import CNcontract.Certainty;
import CNcontract.Identifier;
import CNcontract.ImageBlock;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.json.JSONArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientApp {
    private static final String functionUrl = "https://europe-west1-cn2223-t3-g05.cloudfunctions.net/TFFunctionListVMs";
    private static CNcontractGrpc.CNcontractStub noBlockStub;
    private static CNcontractGrpc.CNcontractBlockingStub blockStub;
    static Scanner scanner;

    public static void main(String[] args) {
        List<String> listOfIPs = getVMsIP();
        scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Pick an IP");
            System.out.println("2. Pick a random IP");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (0-2): ");
            int optionChoice = scanner.nextInt();

            switch (optionChoice) {
                case 0:
                    System.out.println("Exiting the program.");
                    exit = true;
                    break;
                case 1:
                    handleIPSelection(listOfIPs, scanner);
                    break;
                case 2:
                    handleRandomIPSelection(listOfIPs);
                    break;
                default:
                    System.out.println("Invalid option choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void handleIPSelection(List<String> listOfIPs, Scanner scanner) {
        boolean ipSelectionExit = false;
        while (!ipSelectionExit) {
            System.out.println("\nPlease choose one of the following IPs:");
            for (int i = 0; i < listOfIPs.size(); i++) {
                System.out.println((i + 1) + ". " + listOfIPs.get(i));
            }
            System.out.println("0. Go back to IP selection");
            System.out.print("Enter your choice (0-" + listOfIPs.size() + "): ");
            int ipChoice = scanner.nextInt();

            if (ipChoice == 0) {
                System.out.println("Going back to IP selection.");
                ipSelectionExit = true;
                continue;
            }

            // Validate the IP choice
            if (ipChoice < 1 || ipChoice > listOfIPs.size()) {
                System.out.println("Invalid IP choice. Please try again.");
                continue;
            }

            String selectedIP = listOfIPs.get(ipChoice - 1);
            System.out.println("You have chosen: " + selectedIP);
            handleConnection(selectedIP);
        }
    }

    private static void handleRandomIPSelection(List<String> listOfIPs) {
        if (listOfIPs.isEmpty()) {
            System.out.println("No IPs available to choose from. Please try again later.");
            return;
        }

        // Generate a random index
        int randomIndex = (int) (Math.random() * listOfIPs.size());
        String selectedIP = listOfIPs.get(randomIndex);
        System.out.println("Randomly selected IP: " + selectedIP);
        handleConnection(selectedIP);
    }

    private static void handleConnection(String selectedIP) {
        boolean connected = false;
        while (!connected) {
            try {
                // Attempt to establish the connection
                ManagedChannel channel = ManagedChannelBuilder.forAddress(selectedIP, 8000)
                        .usePlaintext()
                        .build();

                // Connection successful
                System.out.println("Connection established with " + selectedIP);
                connected = true;

                // Loop for additional options after successful connection
                noBlockStub = CNcontractGrpc.newStub(channel);
                boolean innerExit = false;
                while (!innerExit) {
                    System.out.println("\nPlease select an option:");
                    System.out.println("1. Upload Image for Analysis");
                    System.out.println("2. Get Analysis Information");
                    System.out.println("3. Get images above a certain certainty");
                    System.out.println("4. Go back to IP selection");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice (1-5): ");
                    int optionChoice = scanner.nextInt();

                    switch (optionChoice) {
                        case 1:
                            ClientStreamObserver_Identifier clientStreamObserver_identifier = new ClientStreamObserver_Identifier();
                            System.out.println("Upload Image for Analysis option selected.");
                            System.out.println("What is the path of the image to upload?");
                            String imagePath = scanner.next();
                            // Add your code for uploading an image for analysis here
                            submitImage(imagePath, clientStreamObserver_identifier);
                            break;
                        case 2:
                            System.out.println("Get Analysis Information option selected.");
                            System.out.println("What is the identifier of the request?");
                            String identifier = scanner.next();
                            analysisOfImage(noBlockStub, identifier);
                            // Add your code for getting analysis information here
                            break;
                        case 3:
                            System.out.println("Enter the certainty threshold:");
                            float threshold = scanner.nextFloat();
                            getImagesAboveCertainty(noBlockStub, threshold);
                            break;
                        case 4:
                            System.out.println("Going back to IP selection.");
                            innerExit = true;
                            break;
                        case 5:
                            System.out.println("Exiting the program.");
                            innerExit = true;
                            break;
                        default:
                            System.out.println("Invalid option choice. Please try again.");
                            break;
                    }
                    Thread.sleep(2000);
                }

                // Close the channel when done
                channel.shutdown();

            } catch (Exception e) {
                // Connection failed
                System.out.println("Failed to establish a connection with " + selectedIP);
                System.out.println("Please choose another IP.");

                // Go back to IP selection
                break;
            }
        }
    }
    private static void getImagesAboveCertainty(CNcontractGrpc.CNcontractStub noBlockStub, float threshold) {
        ClientStreamObserver_ListOfPhotos clientStreamObserver_listOfPhotos = new ClientStreamObserver_ListOfPhotos();
        noBlockStub.getAboveCertainty(Certainty.newBuilder().setCertainty(threshold).build(), clientStreamObserver_listOfPhotos);


    }

    private static void analysisOfImage(CNcontractGrpc.CNcontractStub noBlockStub,String id){
        ClientStreamObserver_ImageBlock clientStreamObserver_imageBlock = new ClientStreamObserver_ImageBlock(id);
        ClientStreamObserver_ListOfLandmarkResults clientStreamObserver_listOfLandmarkResults = new ClientStreamObserver_ListOfLandmarkResults(clientStreamObserver_imageBlock);
        Identifier identifier = Identifier.newBuilder().setIdentifier(id).build();
        noBlockStub.getListOfLandMarks(identifier,clientStreamObserver_listOfLandmarkResults);
        noBlockStub.getMapOfIdentifier(identifier,clientStreamObserver_imageBlock);
    }
    private static void submitImage(String imagePath, ClientStreamObserver_Identifier clientStreamObserver_identifier){
        StreamObserver<ImageBlock> imageStream = noBlockStub.submitImage(clientStreamObserver_identifier);
        // Read the image file and send it in blocks
        try (FileInputStream fileInputStream = new FileInputStream(imagePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                // Create an ImageBlock message with the current block of data
                ByteString data = ByteString.copyFrom(buffer, 0, bytesRead);
                ImageBlock imageBlock = ImageBlock.newBuilder().setData(data).build();

                // Send the image block to the server
                imageStream.onNext(imageBlock);
            }

            // Signal the completion of sending the image
            imageStream.onCompleted();

        } catch (IOException e) {
            // Handle any IO errors
            System.err.println("Error reading the image file: " + e.getMessage());
        }
    }

    private static List<String> getVMsIP(){
        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        // Create an instance of HttpRequest with the desired request parameters
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(ClientApp.functionUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("Request payload"))
                .build();
        List<String> stringList = new ArrayList<>();
        try {
            // Send the request and retrieve the response
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            // Process the response
            String responseBody = httpResponse.body();
            // Parse the response body as a JSON array of strings
            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i = 0; i < jsonArray.length(); i++) {
                String str = jsonArray.getString(i);
                stringList.add(str);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to obtain IPs for the VMs. Error: " + e.getMessage());
        }
        return stringList;
    }

}
