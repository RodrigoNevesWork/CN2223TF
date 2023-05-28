import CNcontract.CNcontractGrpc;
import CNcontract.Identifier;
import CNcontract.Void;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class ClientApp {
    private static String functionUrl = "https://europe-west1-cn2223-t3-g05.cloudfunctions.net/TFFunctionListVMs";
    //WHEN CREATING INSTANCE GROUP, USE NAME 'instance-group-tf-server'
    private static ManagedChannel channel;
    private static CNcontractGrpc.CNcontractStub noBlockStub;
    private static CNcontractGrpc.CNcontractBlockingStub blockStub;
    public static void main(String[] args) {

        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        // Create an instance of HttpRequest with the desired request parameters
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(functionUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("Request payload"))
                .build();
        List<String> stringList = new ArrayList<>();
        try {
            // Send the request and retrieve the response
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            // Process the response
            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();
            System.out.println("Response Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
            // Parse the response body as a JSON array of strings
            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i = 0; i < jsonArray.length(); i++) {
                String str = jsonArray.getString(i);
                stringList.add(str);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stringList.get(0));
        ClientStreamObserver_Identifier clientStreamObserver_identifier = new ClientStreamObserver_Identifier();
        channel = ManagedChannelBuilder.forAddress(stringList.get(0), 8000)
                .usePlaintext()
                .build();
       // noBlockStub = CNcontractGrpc.newStub(channel);
        blockStub = CNcontractGrpc.newBlockingStub(channel);
        Identifier identifier = blockStub.isAlive(Void.newBuilder().build());
        System.out.println(identifier.getIdentifier());
        //noBlockStub.isAlive(Void.newBuilder().build(),clientStreamObserver_identifier);

    }

}
