package CNcontract;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: contract.proto")
public final class CNcontractGrpc {

  private CNcontractGrpc() {}

  public static final String SERVICE_NAME = "CNcontract.CNcontract";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CNcontract.Void,
      CNcontract.Identifier> getIsAliveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isAlive",
      requestType = CNcontract.Void.class,
      responseType = CNcontract.Identifier.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CNcontract.Void,
      CNcontract.Identifier> getIsAliveMethod() {
    io.grpc.MethodDescriptor<CNcontract.Void, CNcontract.Identifier> getIsAliveMethod;
    if ((getIsAliveMethod = CNcontractGrpc.getIsAliveMethod) == null) {
      synchronized (CNcontractGrpc.class) {
        if ((getIsAliveMethod = CNcontractGrpc.getIsAliveMethod) == null) {
          CNcontractGrpc.getIsAliveMethod = getIsAliveMethod =
              io.grpc.MethodDescriptor.<CNcontract.Void, CNcontract.Identifier>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "isAlive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.Identifier.getDefaultInstance()))
              .setSchemaDescriptor(new CNcontractMethodDescriptorSupplier("isAlive"))
              .build();
        }
      }
    }
    return getIsAliveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CNcontract.ImageBlock,
      CNcontract.Identifier> getSubmitImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "submitImage",
      requestType = CNcontract.ImageBlock.class,
      responseType = CNcontract.Identifier.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<CNcontract.ImageBlock,
      CNcontract.Identifier> getSubmitImageMethod() {
    io.grpc.MethodDescriptor<CNcontract.ImageBlock, CNcontract.Identifier> getSubmitImageMethod;
    if ((getSubmitImageMethod = CNcontractGrpc.getSubmitImageMethod) == null) {
      synchronized (CNcontractGrpc.class) {
        if ((getSubmitImageMethod = CNcontractGrpc.getSubmitImageMethod) == null) {
          CNcontractGrpc.getSubmitImageMethod = getSubmitImageMethod =
              io.grpc.MethodDescriptor.<CNcontract.ImageBlock, CNcontract.Identifier>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "submitImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.ImageBlock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.Identifier.getDefaultInstance()))
              .setSchemaDescriptor(new CNcontractMethodDescriptorSupplier("submitImage"))
              .build();
        }
      }
    }
    return getSubmitImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CNcontract.Identifier,
      CNcontract.ListOfLandMarkResult> getGetListOfLandMarksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListOfLandMarks",
      requestType = CNcontract.Identifier.class,
      responseType = CNcontract.ListOfLandMarkResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CNcontract.Identifier,
      CNcontract.ListOfLandMarkResult> getGetListOfLandMarksMethod() {
    io.grpc.MethodDescriptor<CNcontract.Identifier, CNcontract.ListOfLandMarkResult> getGetListOfLandMarksMethod;
    if ((getGetListOfLandMarksMethod = CNcontractGrpc.getGetListOfLandMarksMethod) == null) {
      synchronized (CNcontractGrpc.class) {
        if ((getGetListOfLandMarksMethod = CNcontractGrpc.getGetListOfLandMarksMethod) == null) {
          CNcontractGrpc.getGetListOfLandMarksMethod = getGetListOfLandMarksMethod =
              io.grpc.MethodDescriptor.<CNcontract.Identifier, CNcontract.ListOfLandMarkResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListOfLandMarks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.Identifier.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.ListOfLandMarkResult.getDefaultInstance()))
              .setSchemaDescriptor(new CNcontractMethodDescriptorSupplier("getListOfLandMarks"))
              .build();
        }
      }
    }
    return getGetListOfLandMarksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CNcontract.Identifier,
      CNcontract.ImageBlock> getGetMapOfIdentifierMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMapOfIdentifier",
      requestType = CNcontract.Identifier.class,
      responseType = CNcontract.ImageBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<CNcontract.Identifier,
      CNcontract.ImageBlock> getGetMapOfIdentifierMethod() {
    io.grpc.MethodDescriptor<CNcontract.Identifier, CNcontract.ImageBlock> getGetMapOfIdentifierMethod;
    if ((getGetMapOfIdentifierMethod = CNcontractGrpc.getGetMapOfIdentifierMethod) == null) {
      synchronized (CNcontractGrpc.class) {
        if ((getGetMapOfIdentifierMethod = CNcontractGrpc.getGetMapOfIdentifierMethod) == null) {
          CNcontractGrpc.getGetMapOfIdentifierMethod = getGetMapOfIdentifierMethod =
              io.grpc.MethodDescriptor.<CNcontract.Identifier, CNcontract.ImageBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMapOfIdentifier"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.Identifier.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.ImageBlock.getDefaultInstance()))
              .setSchemaDescriptor(new CNcontractMethodDescriptorSupplier("getMapOfIdentifier"))
              .build();
        }
      }
    }
    return getGetMapOfIdentifierMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CNcontract.Certainty,
      CNcontract.ListOfPhotos> getGetAboveCertaintyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAboveCertainty",
      requestType = CNcontract.Certainty.class,
      responseType = CNcontract.ListOfPhotos.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CNcontract.Certainty,
      CNcontract.ListOfPhotos> getGetAboveCertaintyMethod() {
    io.grpc.MethodDescriptor<CNcontract.Certainty, CNcontract.ListOfPhotos> getGetAboveCertaintyMethod;
    if ((getGetAboveCertaintyMethod = CNcontractGrpc.getGetAboveCertaintyMethod) == null) {
      synchronized (CNcontractGrpc.class) {
        if ((getGetAboveCertaintyMethod = CNcontractGrpc.getGetAboveCertaintyMethod) == null) {
          CNcontractGrpc.getGetAboveCertaintyMethod = getGetAboveCertaintyMethod =
              io.grpc.MethodDescriptor.<CNcontract.Certainty, CNcontract.ListOfPhotos>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAboveCertainty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.Certainty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CNcontract.ListOfPhotos.getDefaultInstance()))
              .setSchemaDescriptor(new CNcontractMethodDescriptorSupplier("getAboveCertainty"))
              .build();
        }
      }
    }
    return getGetAboveCertaintyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CNcontractStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CNcontractStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CNcontractStub>() {
        @java.lang.Override
        public CNcontractStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CNcontractStub(channel, callOptions);
        }
      };
    return CNcontractStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CNcontractBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CNcontractBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CNcontractBlockingStub>() {
        @java.lang.Override
        public CNcontractBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CNcontractBlockingStub(channel, callOptions);
        }
      };
    return CNcontractBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CNcontractFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CNcontractFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CNcontractFutureStub>() {
        @java.lang.Override
        public CNcontractFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CNcontractFutureStub(channel, callOptions);
        }
      };
    return CNcontractFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CNcontractImplBase implements io.grpc.BindableService {

    /**
     */
    public void isAlive(CNcontract.Void request,
        io.grpc.stub.StreamObserver<CNcontract.Identifier> responseObserver) {
      asyncUnimplementedUnaryCall(getIsAliveMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<CNcontract.ImageBlock> submitImage(
        io.grpc.stub.StreamObserver<CNcontract.Identifier> responseObserver) {
      return asyncUnimplementedStreamingCall(getSubmitImageMethod(), responseObserver);
    }

    /**
     */
    public void getListOfLandMarks(CNcontract.Identifier request,
        io.grpc.stub.StreamObserver<CNcontract.ListOfLandMarkResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListOfLandMarksMethod(), responseObserver);
    }

    /**
     */
    public void getMapOfIdentifier(CNcontract.Identifier request,
        io.grpc.stub.StreamObserver<CNcontract.ImageBlock> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMapOfIdentifierMethod(), responseObserver);
    }

    /**
     */
    public void getAboveCertainty(CNcontract.Certainty request,
        io.grpc.stub.StreamObserver<CNcontract.ListOfPhotos> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAboveCertaintyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIsAliveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CNcontract.Void,
                CNcontract.Identifier>(
                  this, METHODID_IS_ALIVE)))
          .addMethod(
            getSubmitImageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                CNcontract.ImageBlock,
                CNcontract.Identifier>(
                  this, METHODID_SUBMIT_IMAGE)))
          .addMethod(
            getGetListOfLandMarksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CNcontract.Identifier,
                CNcontract.ListOfLandMarkResult>(
                  this, METHODID_GET_LIST_OF_LAND_MARKS)))
          .addMethod(
            getGetMapOfIdentifierMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                CNcontract.Identifier,
                CNcontract.ImageBlock>(
                  this, METHODID_GET_MAP_OF_IDENTIFIER)))
          .addMethod(
            getGetAboveCertaintyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CNcontract.Certainty,
                CNcontract.ListOfPhotos>(
                  this, METHODID_GET_ABOVE_CERTAINTY)))
          .build();
    }
  }

  /**
   */
  public static final class CNcontractStub extends io.grpc.stub.AbstractAsyncStub<CNcontractStub> {
    private CNcontractStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CNcontractStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CNcontractStub(channel, callOptions);
    }

    /**
     */
    public void isAlive(CNcontract.Void request,
        io.grpc.stub.StreamObserver<CNcontract.Identifier> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsAliveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<CNcontract.ImageBlock> submitImage(
        io.grpc.stub.StreamObserver<CNcontract.Identifier> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSubmitImageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getListOfLandMarks(CNcontract.Identifier request,
        io.grpc.stub.StreamObserver<CNcontract.ListOfLandMarkResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListOfLandMarksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMapOfIdentifier(CNcontract.Identifier request,
        io.grpc.stub.StreamObserver<CNcontract.ImageBlock> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetMapOfIdentifierMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAboveCertainty(CNcontract.Certainty request,
        io.grpc.stub.StreamObserver<CNcontract.ListOfPhotos> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAboveCertaintyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CNcontractBlockingStub extends io.grpc.stub.AbstractBlockingStub<CNcontractBlockingStub> {
    private CNcontractBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CNcontractBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CNcontractBlockingStub(channel, callOptions);
    }

    /**
     */
    public CNcontract.Identifier isAlive(CNcontract.Void request) {
      return blockingUnaryCall(
          getChannel(), getIsAliveMethod(), getCallOptions(), request);
    }

    /**
     */
    public CNcontract.ListOfLandMarkResult getListOfLandMarks(CNcontract.Identifier request) {
      return blockingUnaryCall(
          getChannel(), getGetListOfLandMarksMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<CNcontract.ImageBlock> getMapOfIdentifier(
        CNcontract.Identifier request) {
      return blockingServerStreamingCall(
          getChannel(), getGetMapOfIdentifierMethod(), getCallOptions(), request);
    }

    /**
     */
    public CNcontract.ListOfPhotos getAboveCertainty(CNcontract.Certainty request) {
      return blockingUnaryCall(
          getChannel(), getGetAboveCertaintyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CNcontractFutureStub extends io.grpc.stub.AbstractFutureStub<CNcontractFutureStub> {
    private CNcontractFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CNcontractFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CNcontractFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CNcontract.Identifier> isAlive(
        CNcontract.Void request) {
      return futureUnaryCall(
          getChannel().newCall(getIsAliveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CNcontract.ListOfLandMarkResult> getListOfLandMarks(
        CNcontract.Identifier request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListOfLandMarksMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CNcontract.ListOfPhotos> getAboveCertainty(
        CNcontract.Certainty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAboveCertaintyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IS_ALIVE = 0;
  private static final int METHODID_GET_LIST_OF_LAND_MARKS = 1;
  private static final int METHODID_GET_MAP_OF_IDENTIFIER = 2;
  private static final int METHODID_GET_ABOVE_CERTAINTY = 3;
  private static final int METHODID_SUBMIT_IMAGE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CNcontractImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CNcontractImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_IS_ALIVE:
          serviceImpl.isAlive((CNcontract.Void) request,
              (io.grpc.stub.StreamObserver<CNcontract.Identifier>) responseObserver);
          break;
        case METHODID_GET_LIST_OF_LAND_MARKS:
          serviceImpl.getListOfLandMarks((CNcontract.Identifier) request,
              (io.grpc.stub.StreamObserver<CNcontract.ListOfLandMarkResult>) responseObserver);
          break;
        case METHODID_GET_MAP_OF_IDENTIFIER:
          serviceImpl.getMapOfIdentifier((CNcontract.Identifier) request,
              (io.grpc.stub.StreamObserver<CNcontract.ImageBlock>) responseObserver);
          break;
        case METHODID_GET_ABOVE_CERTAINTY:
          serviceImpl.getAboveCertainty((CNcontract.Certainty) request,
              (io.grpc.stub.StreamObserver<CNcontract.ListOfPhotos>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBMIT_IMAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.submitImage(
              (io.grpc.stub.StreamObserver<CNcontract.Identifier>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CNcontractBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CNcontractBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CNcontract.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CNcontract");
    }
  }

  private static final class CNcontractFileDescriptorSupplier
      extends CNcontractBaseDescriptorSupplier {
    CNcontractFileDescriptorSupplier() {}
  }

  private static final class CNcontractMethodDescriptorSupplier
      extends CNcontractBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CNcontractMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CNcontractGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CNcontractFileDescriptorSupplier())
              .addMethod(getIsAliveMethod())
              .addMethod(getSubmitImageMethod())
              .addMethod(getGetListOfLandMarksMethod())
              .addMethod(getGetMapOfIdentifierMethod())
              .addMethod(getGetAboveCertaintyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
