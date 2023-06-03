import CNcontract.ListOfPhotos;
import CNcontract.Photos;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ClientStreamObserver_ListOfPhotos implements StreamObserver<ListOfPhotos> {
    @Override
    public void onNext(ListOfPhotos photos) {
        // Handle the received photos
        // ...
        for (Photos photo : photos.getPhotosList()) {
            System.out.println("Photo Name: " + photo.getPhotoName());
            System.out.println("Location Name: " + photo.getLocationName());
        }
    }

    @Override
    public void onError(Throwable throwable) {
        // Handle any errors
        System.err.println(((StatusRuntimeException) throwable).getStatus().getDescription());
    }

    @Override
    public void onCompleted() {
        // Handle the completion of the RPC call
        System.out.println("List of photos received.");
    }
}
