import CNcontract.*;
import CNcontract.Void;
import com.google.protobuf.ByteString;
import io.grpc.LoadBalancerRegistry;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.PickFirstLoadBalancerProvider;
import io.grpc.stub.StreamObserver;
import observers.ServerStreamObserver_ImageBlock;
import utils.*;

import java.util.*;


public class TFServer extends CNcontractGrpc.CNcontractImplBase{

    private static int srvPort = 8000;
    private FireStoreUtils fireStoreUtils;

    public static void main(String[] args) {
        try {
            // Initialize FireStoreUtils
            FireStoreUtils fireStoreUtils = new FireStoreUtils("requests_information");
            LoadBalancerRegistry.getDefaultRegistry().register(new PickFirstLoadBalancerProvider());
            // Create and start the gRPC server
            io.grpc.Server svc = ServerBuilder.forPort(srvPort).addService(new TFServer(fireStoreUtils)).build();
            svc.start();
            System.out.println("Server started, listening on " + srvPort);
            svc.awaitTermination();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private TFServer(FireStoreUtils fireStoreUtils) {
        this.fireStoreUtils = fireStoreUtils;
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
        return new ServerStreamObserver_ImageBlock(responseObserver);
        //serverStreamObserver_imageBlock.onCompleted();

    }


    @Override
    public void getListOfLandMarks(Identifier request, StreamObserver<ListOfLandMarkResult> responseObserver) {
        // Implement the logic for getListOfLandMarks method
        // ...
        try {
            FireStoreDocument doc =fireStoreUtils.useGetDoc( request.getIdentifier());
            // Create a ListOfLandMarkResult builder
            ListOfLandMarkResult.Builder resultListBuilder = ListOfLandMarkResult.newBuilder();

            // Iterate over the list of AnaliseResult objects
            for (AnaliseResult result : doc.getAr()) {
                // Create a LandMarkResult builder
                LandMarkResult.Builder resultBuilder = LandMarkResult.newBuilder();

                // Set the properties of the LandMarkResult builder
                resultBuilder.setLandmarkName(result.getDescription());
                resultBuilder.setCertainty(result.getCertainty());

                // Create a Localization builder
                Localization.Builder localizationBuilder = Localization.newBuilder();

                // Set the properties of the Localization builder (assuming you have latitude and longitude properties in Coordinates)
                localizationBuilder.setLatitude(result.getCoordinates().getLatitude());
                localizationBuilder.setLongitude(result.getCoordinates().getLongitude());

                // Set the Localization in the LandMarkResult builder
                resultBuilder.setLocalization(localizationBuilder.build());

                // Add the LandMarkResult to the ListOfLandMarkResult builder
                resultListBuilder.addLandMarkResult(resultBuilder.build());
            }

            // Build the final ListOfLandMarkResult
            ListOfLandMarkResult resultList = resultListBuilder.build();

            // Send the response to the client
            responseObserver.onNext(resultList);
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException statusException = new StatusRuntimeException(Status.INTERNAL.withDescription(Objects.equals(e.getMessage(), "This Document does not exists") ? "LandmarksApp hasnt processed this request yet or the Identifier is incorrect" :e.getMessage()));
            responseObserver.onError(statusException);
        }
    }

    @Override
    public void getMapOfIdentifier(Identifier request, StreamObserver<ImageBlock> responseObserver) {
        // Implement the logic for getMapOfIdentifier method
        // ...
        try {
            FireStoreDocument doc =fireStoreUtils.useGetDoc( request.getIdentifier());
            byte[] byteArray = GoogleCloudStorageUtils.downloadFromBucket("static_maps_storage",doc.getBlobName());
            int blockSize = 1024;
            int offset = 0;

            while (offset < byteArray.length) {
                int remainingBytes = byteArray.length - offset;
                int blockSizeToRead = Math.min(blockSize, remainingBytes);

                // Create a byte array for the current block
                byte[] blockData = new byte[blockSizeToRead];
                System.arraycopy(byteArray, offset, blockData, 0, blockSizeToRead);

                // Create the ImageBlock message
                ImageBlock imageBlock = ImageBlock.newBuilder()
                        .setData(ByteString.copyFrom(blockData))
                        .build();

                // Send the ImageBlock to the response observer
                responseObserver.onNext(imageBlock);

                // Update the offset for the next block
                offset += blockSizeToRead;
            }

            // Complete the response observer
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException statusException = new StatusRuntimeException(Status.INTERNAL.withDescription(Objects.equals(e.getMessage(), "This Document does not exists") ? "LandmarksApp hasnt processed this request yet or the Identifier is incorrect" :e.getMessage()));
            responseObserver.onError(statusException);

        }
    }

    @Override
    public void getAboveCertainty(Certainty request, StreamObserver<ListOfPhotos> responseObserver) {
        // Implement the logic for getAboveCertainty method
        // ...
        try {
            List<AboveCertaintyResult> aboveCertaintyResultList = fireStoreUtils.useGetAboveCertaintyResult(request.getCertainty());
            List<Photos> photosList = new ArrayList<>();
            for (AboveCertaintyResult result : aboveCertaintyResultList) {
                Photos photo = Photos.newBuilder()
                        .setPhotoName(result.getBlobID())
                        .setLocationName(result.getLocalName())
                        .build();
                photosList.add(photo);
            }

            // Build the ListOfPhotos response object
            ListOfPhotos listOfPhotos = ListOfPhotos.newBuilder()
                    .addAllPhotos(photosList)
                    .build();

            // Send the response
            responseObserver.onNext(listOfPhotos);
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException statusException = new StatusRuntimeException(Status.INTERNAL.withDescription(Objects.equals(e.getMessage(), "This Document does not exists") ? "LandmarksApp hasnt processed this request yet or the Identifier is incorrect" :e.getMessage()));
            responseObserver.onError(statusException);
        }

    }
}
