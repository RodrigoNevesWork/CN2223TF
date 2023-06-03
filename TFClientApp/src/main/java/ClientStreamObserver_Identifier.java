import CNcontract.Identifier;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ClientStreamObserver_Identifier implements StreamObserver<Identifier> {
    @Override
    public void onNext(Identifier identifier) {
        // Handle the received identifier
        System.out.println("Received identifier: " + identifier);
    }

    @Override
    public void onError(Throwable throwable) {
        // Handle any errors
        System.err.println(((StatusRuntimeException) throwable).getStatus().getDescription());
    }

    @Override
    public void onCompleted() {
        // Handle the completion of the RPC call
        System.out.println("Image submission completed.");
    }
}
