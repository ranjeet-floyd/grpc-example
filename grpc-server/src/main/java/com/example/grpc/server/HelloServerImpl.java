package com.example.grpc.server;


import com.example.grpc.model.HelloRequest;
import com.example.grpc.model.HelloResponse;
import com.example.grpc.model.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServerImpl extends HelloServiceGrpc.HelloServiceImplBase {
  @Override
  public void hello(
      HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

    String greeting = new StringBuilder()
        .append("Hello, ")
        .append(request.getFirstName())
        .append(" ")
        .append(request.getLastName())
        .toString();

    HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
