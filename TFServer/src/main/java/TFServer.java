import CNcontract.*;
import CNcontract.Void;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;


public class TFServer extends CNcontractGrpc.CNcontractImplBase{

    private static int srvPort = 8000;
    public static void main(String[] args) {
        try{
            io.grpc.Server svc= ServerBuilder.forPort(srvPort).addService(new TFServer()).build();
            svc.start();
            System.out.println("Server started, listening on " + srvPort);
            svc.awaitTermination();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    @Override
    public void isAlive(Void request, StreamObserver<Identifier> responseObserver) {
        System.out.println("isAlive called");

        Identifier reply = Identifier.newBuilder().setIdentifier("Server is Alive.").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }
    @Override
    public StreamObserver<ImageBlock> submitImage(StreamObserver<Identifier> responseObserver) {
       //
        return null;
    }
    @Override
    public void getListOfLandMarks(Identifier request, StreamObserver<ListOfLandMarkResult> responseObserver) {
        // Implement the logic for getListOfLandMarks method
        // ...
    }

    @Override
    public void getMapOfIdentifier(Identifier request, StreamObserver<ImageBlock> responseObserver) {
        // Implement the logic for getMapOfIdentifier method
        // ...
    }

    @Override
    public void getAboveCertainty(Certainty request, StreamObserver<ListOfPhotos> responseObserver) {
        // Implement the logic for getAboveCertainty method
        // ...
    }

    @Override
    public void publishMessageToTopic(PublishMessageRequest request, StreamObserver<google.protobuf.Empty> responseObserver) {
        // Extract the values from the request
        Identifier identifier = request.getIdentifier();
        String bucketName = request.getBucketName();
        String blobName = request.getBlobName();

        // Create a Pub/Sub message with the identifier, bucket name, and blob name
        String messagePayload = "Identifier: " + identifier.getIdentifier() +
                ", Bucket Name: " + bucketName +
                ", Blob Name: " + blobName;

        // Create a Pub/Sub ByteString to set and build the data
        ByteString data = ByteString.copyFromUtf8(messagePayload);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .setData(data)
                .build();

        // TODO Não sei como ir buscar isto
        String projectId = "sharefotos";
        String topicId = "tfPubSubTopic-sub";

        // Create a publisher with the topic name
        TopicName topicName = TopicName.of(projectId, topicId);
        Publisher publisher = null;

        try {
            publisher = Publisher.newBuilder(topicName).build();

            // Publish the message to the topic
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (publisher != null) {
                publisher.shutdown();
            }
        }

        // Send an empty response back to the client
        responseObserver.onNext(google.protobuf.Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
