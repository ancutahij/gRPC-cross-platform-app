package res.protocol;

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
    value = "by gRPC proto compiler (version 1.17.1)",
    comments = "Source: reservationProtocol.proto")
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "res.protocol.ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = res.protocol.ReservationProtocol.ReservationRequest.class,
      responseType = res.protocol.ReservationProtocol.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse> getLoginMethod;
    if ((getLoginMethod = ReservationServiceGrpc.getLoginMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getLoginMethod = ReservationServiceGrpc.getLoginMethod) == null) {
          ReservationServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "res.protocol.ReservationService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getGetJourneysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getJourneys",
      requestType = res.protocol.ReservationProtocol.ReservationRequest.class,
      responseType = res.protocol.ReservationProtocol.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getGetJourneysMethod() {
    io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse> getGetJourneysMethod;
    if ((getGetJourneysMethod = ReservationServiceGrpc.getGetJourneysMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetJourneysMethod = ReservationServiceGrpc.getGetJourneysMethod) == null) {
          ReservationServiceGrpc.getGetJourneysMethod = getGetJourneysMethod = 
              io.grpc.MethodDescriptor.<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "res.protocol.ReservationService", "getJourneys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("getJourneys"))
                  .build();
          }
        }
     }
     return getGetJourneysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getGetFilteredJourneysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFilteredJourneys",
      requestType = res.protocol.ReservationProtocol.ReservationRequest.class,
      responseType = res.protocol.ReservationProtocol.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getGetFilteredJourneysMethod() {
    io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse> getGetFilteredJourneysMethod;
    if ((getGetFilteredJourneysMethod = ReservationServiceGrpc.getGetFilteredJourneysMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetFilteredJourneysMethod = ReservationServiceGrpc.getGetFilteredJourneysMethod) == null) {
          ReservationServiceGrpc.getGetFilteredJourneysMethod = getGetFilteredJourneysMethod = 
              io.grpc.MethodDescriptor.<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "res.protocol.ReservationService", "getFilteredJourneys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("getFilteredJourneys"))
                  .build();
          }
        }
     }
     return getGetFilteredJourneysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getSaveReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveReservation",
      requestType = res.protocol.ReservationProtocol.ReservationRequest.class,
      responseType = res.protocol.ReservationProtocol.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getSaveReservationMethod() {
    io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse> getSaveReservationMethod;
    if ((getSaveReservationMethod = ReservationServiceGrpc.getSaveReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getSaveReservationMethod = ReservationServiceGrpc.getSaveReservationMethod) == null) {
          ReservationServiceGrpc.getSaveReservationMethod = getSaveReservationMethod = 
              io.grpc.MethodDescriptor.<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "res.protocol.ReservationService", "saveReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("saveReservation"))
                  .build();
          }
        }
     }
     return getSaveReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = res.protocol.ReservationProtocol.ReservationRequest.class,
      responseType = res.protocol.ReservationProtocol.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.ReservationResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse> getLogoutMethod;
    if ((getLogoutMethod = ReservationServiceGrpc.getLogoutMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getLogoutMethod = ReservationServiceGrpc.getLogoutMethod) == null) {
          ReservationServiceGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "res.protocol.ReservationService", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.Notification> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = res.protocol.ReservationProtocol.ReservationRequest.class,
      responseType = res.protocol.ReservationProtocol.Notification.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest,
      res.protocol.ReservationProtocol.Notification> getSubscribeMethod() {
    io.grpc.MethodDescriptor<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.Notification> getSubscribeMethod;
    if ((getSubscribeMethod = ReservationServiceGrpc.getSubscribeMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getSubscribeMethod = ReservationServiceGrpc.getSubscribeMethod) == null) {
          ReservationServiceGrpc.getSubscribeMethod = getSubscribeMethod = 
              io.grpc.MethodDescriptor.<res.protocol.ReservationProtocol.ReservationRequest, res.protocol.ReservationProtocol.Notification>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "res.protocol.ReservationService", "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  res.protocol.ReservationProtocol.Notification.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("subscribe"))
                  .build();
          }
        }
     }
     return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void getJourneys(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetJourneysMethod(), responseObserver);
    }

    /**
     */
    public void getFilteredJourneys(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFilteredJourneysMethod(), responseObserver);
    }

    /**
     */
    public void saveReservation(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveReservationMethod(), responseObserver);
    }

    /**
     */
    public void logout(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     */
    public void subscribe(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.Notification> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                res.protocol.ReservationProtocol.ReservationRequest,
                res.protocol.ReservationProtocol.ReservationResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getGetJourneysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                res.protocol.ReservationProtocol.ReservationRequest,
                res.protocol.ReservationProtocol.ReservationResponse>(
                  this, METHODID_GET_JOURNEYS)))
          .addMethod(
            getGetFilteredJourneysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                res.protocol.ReservationProtocol.ReservationRequest,
                res.protocol.ReservationProtocol.ReservationResponse>(
                  this, METHODID_GET_FILTERED_JOURNEYS)))
          .addMethod(
            getSaveReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                res.protocol.ReservationProtocol.ReservationRequest,
                res.protocol.ReservationProtocol.ReservationResponse>(
                  this, METHODID_SAVE_RESERVATION)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                res.protocol.ReservationProtocol.ReservationRequest,
                res.protocol.ReservationProtocol.ReservationResponse>(
                  this, METHODID_LOGOUT)))
          .addMethod(
            getSubscribeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                res.protocol.ReservationProtocol.ReservationRequest,
                res.protocol.ReservationProtocol.Notification>(
                  this, METHODID_SUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getJourneys(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetJourneysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFilteredJourneys(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFilteredJourneysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveReservation(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribe(res.protocol.ReservationProtocol.ReservationRequest request,
        io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.Notification> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public res.protocol.ReservationProtocol.ReservationResponse login(res.protocol.ReservationProtocol.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public res.protocol.ReservationProtocol.ReservationResponse getJourneys(res.protocol.ReservationProtocol.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetJourneysMethod(), getCallOptions(), request);
    }

    /**
     */
    public res.protocol.ReservationProtocol.ReservationResponse getFilteredJourneys(res.protocol.ReservationProtocol.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFilteredJourneysMethod(), getCallOptions(), request);
    }

    /**
     */
    public res.protocol.ReservationProtocol.ReservationResponse saveReservation(res.protocol.ReservationProtocol.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public res.protocol.ReservationProtocol.ReservationResponse logout(res.protocol.ReservationProtocol.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<res.protocol.ReservationProtocol.Notification> subscribe(
        res.protocol.ReservationProtocol.ReservationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<res.protocol.ReservationProtocol.ReservationResponse> login(
        res.protocol.ReservationProtocol.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<res.protocol.ReservationProtocol.ReservationResponse> getJourneys(
        res.protocol.ReservationProtocol.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetJourneysMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<res.protocol.ReservationProtocol.ReservationResponse> getFilteredJourneys(
        res.protocol.ReservationProtocol.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFilteredJourneysMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<res.protocol.ReservationProtocol.ReservationResponse> saveReservation(
        res.protocol.ReservationProtocol.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<res.protocol.ReservationProtocol.ReservationResponse> logout(
        res.protocol.ReservationProtocol.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_GET_JOURNEYS = 1;
  private static final int METHODID_GET_FILTERED_JOURNEYS = 2;
  private static final int METHODID_SAVE_RESERVATION = 3;
  private static final int METHODID_LOGOUT = 4;
  private static final int METHODID_SUBSCRIBE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((res.protocol.ReservationProtocol.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_JOURNEYS:
          serviceImpl.getJourneys((res.protocol.ReservationProtocol.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_FILTERED_JOURNEYS:
          serviceImpl.getFilteredJourneys((res.protocol.ReservationProtocol.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse>) responseObserver);
          break;
        case METHODID_SAVE_RESERVATION:
          serviceImpl.saveReservation((res.protocol.ReservationProtocol.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((res.protocol.ReservationProtocol.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.ReservationResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((res.protocol.ReservationProtocol.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<res.protocol.ReservationProtocol.Notification>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return res.protocol.ReservationProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getGetJourneysMethod())
              .addMethod(getGetFilteredJourneysMethod())
              .addMethod(getSaveReservationMethod())
              .addMethod(getLogoutMethod())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
