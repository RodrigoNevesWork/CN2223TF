import CNcontract.ImageBlock;
import io.grpc.stub.StreamObserver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ClientStreamObserver_ImageBlock implements StreamObserver<ImageBlock> {
    private List<byte[]> imageBlocks; // List to store the received image blocks

    @Override
    public void onNext(ImageBlock imageBlock) {
        // Handle the received image block
        byte[] imageData = imageBlock.getData().toByteArray();
        imageBlocks.add(imageData); // Store the image block in the list
    }

    @Override
    public void onError(Throwable throwable) {
        // Handle any errors
        System.err.println("Error: " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        // Handle the completion of the RPC call
        System.out.println("Image reception completed.");

        // Save the received image blocks as a complete image
        saveCompleteImage();
    }

    private void saveCompleteImage() {
        // Combine the received image blocks into a single byte array
        int totalSize = imageBlocks.stream().mapToInt(block -> block.length).sum();
        byte[] completeImageData = new byte[totalSize];
        int currentIndex = 0;
        for (byte[] block : imageBlocks) {
            System.arraycopy(block, 0, completeImageData, currentIndex, block.length);
            currentIndex += block.length;
        }

        // Save the complete image as a file
        try (FileOutputStream outputStream = new FileOutputStream("static_image.jpg")) {
            outputStream.write(completeImageData);
            System.out.println("Saved complete image.");
        } catch (IOException e) {
            System.err.println("Error saving complete image: " + e.getMessage());
        }
    }
}