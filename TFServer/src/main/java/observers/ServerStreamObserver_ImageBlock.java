package observers;

import CNcontract.Identifier;
import CNcontract.ImageBlock;
import io.grpc.stub.StreamObserver;
import utils.GoogleCloudStorageUtils;
import utils.PubSubUtils;

import java.io.IOException;
import java.util.UUID;

public class ServerStreamObserver_ImageBlock implements StreamObserver<ImageBlock> {
    private byte[] imageData = null;
    private final StreamObserver<Identifier> responseObserver;

    public ServerStreamObserver_ImageBlock(StreamObserver<Identifier> responseObserver) {
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(ImageBlock imageBlock) {
        byte[] blockData = imageBlock.getData().toByteArray();

        if (imageData == null) {
            imageData = blockData;
        } else {
            byte[] combinedData = new byte[imageData.length + blockData.length];
            System.arraycopy(imageData, 0, combinedData, 0, imageData.length);
            System.arraycopy(blockData, 0, combinedData, imageData.length, blockData.length);
            imageData = combinedData;
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error receiving image blocks: " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        // Process the complete image data

        // Save the image to the desired location or perform further processing

        // Generate an identifier for the image (e.g., using UUID)
        String identifier = generateIdentifier();
        String blobName = UUID.randomUUID().toString();
        GoogleCloudStorageUtils.uploadBlobToBucket("cn-bucket-europe",blobName, imageData);

        try {
            PubSubUtils.publishMessage(identifier,"cn-bucket-europe",blobName);
        } catch (IOException e) {
            onError(e);
        }

        // Create an Identifier message with the generated identifier
        Identifier identifierMessage = Identifier.newBuilder().setIdentifier(identifier).build();

        // Send the Identifier message back to the client
        responseObserver.onNext(identifierMessage);

        // Signal the completion of the RPC call
        responseObserver.onCompleted();
    }

    private String generateIdentifier() {
        // Generate and return an identifier for the image
        // (e.g., using UUID or any other suitable method)
        return UUID.randomUUID().toString();
    }
}
