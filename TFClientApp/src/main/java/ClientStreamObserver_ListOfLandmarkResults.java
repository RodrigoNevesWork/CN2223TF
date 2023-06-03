import CNcontract.LandMarkResult;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import CNcontract.ListOfLandMarkResult;

public class ClientStreamObserver_ListOfLandmarkResults implements StreamObserver<ListOfLandMarkResult> {

    @Override
    public void onNext(ListOfLandMarkResult result) {
        // Handle the received list of landmark results
        // ...
        for (int i = 0; i < result.getLandMarkResultCount(); i++) {
            LandMarkResult landmark = result.getLandMarkResult(i);
            System.out.println("Landmark Name: " + landmark.getLandmarkName());
            System.out.println("Certainty: " + landmark.getCertainty());
            System.out.println("Localization: " + landmark.getLocalization());
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
        System.out.println("List of landmark results received.");
    }
}
