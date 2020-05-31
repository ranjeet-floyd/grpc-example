package com.example.grpc.client;
import com.example.grpc.model.HelloRequest;
import com.example.grpc.model.HelloResponse;
import com.example.grpc.model.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GrpcClient {
  public static void main(String[] args) throws InterruptedException {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    HelloServiceGrpc.HelloServiceBlockingStub stub
        = HelloServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
        .setFirstName("grpc-client")
        .setLastName("gRPC")
        .build());

    System.out.println(helloResponse);

    channel.shutdown();
  }
}
