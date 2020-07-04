package com.javastudio.tutorial.rpc;

import com.javastudio.tutorial.rpc.server.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new HelloServiceImpl()).build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
