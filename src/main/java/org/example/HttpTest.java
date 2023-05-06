package org.example;

import Network.HTTP.HttpClient;

import java.util.Scanner;

public class HttpTest {
    public static void main(String[] args) {

        HttpClient client = new HttpClient();
        System.out.println(client);
        System.out.println(client.getPing());
        System.out.println(client.getHelloWorld().getBufferedResponse());

        // Wait for request to be finished
        for (int i = 0; i < 10000; i ++) {
            double k = ((double) i /  432);
            System.out.print(k);
        }

        System.out.println(client.getBufferedResponse().getRawBody());

    }
}
