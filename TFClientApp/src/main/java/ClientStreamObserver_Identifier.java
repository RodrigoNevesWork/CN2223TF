import CNcontract.Identifier;
import io.grpc.stub.StreamObserver;

public class ClientStreamObserver_Identifier implements StreamObserver<Identifier> {
    @Override
    public void onNext(Identifier identifier) {
        System.out.println(identifier.getIdentifier());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error: " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        System.out.println("Stream completed!");
    }
}
