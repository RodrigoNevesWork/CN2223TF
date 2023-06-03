import CNcontract.*;
import CNcontract.Void;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import observers.ServerStreamObserver_ImageBlock;

import java.util.Scanner;
import java.util.UUID;


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
        return new ServerStreamObserver_ImageBlock(responseObserver);
        //serverStreamObserver_imageBlock.onCompleted();

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
}
