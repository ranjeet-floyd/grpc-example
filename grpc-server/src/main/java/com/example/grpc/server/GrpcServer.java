package com.example.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
public class GrpcServer {
  public static void main(String[] args)  throws IOException, InterruptedException  {
    Server server = ServerBuilder
        .forPort(8080)
        .addService(new HelloServerImpl()).build();

    server.start();
    server.awaitTermination();
  }
}
