package com.javastudio.tutorial.rpc;

import com.javastudio.tutorial.rpc.server.HelloRequest;
import com.javastudio.tutorial.rpc.server.HelloResponse;
import com.javastudio.tutorial.rpc.server.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Application {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}
