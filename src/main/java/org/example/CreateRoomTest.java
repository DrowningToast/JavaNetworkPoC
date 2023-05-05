package org.example;

import Network.HTTP.Base.HttpController;
import Network.HTTP.Base.HttpResponse;
import Network.HTTP.HttpClient;

import java.util.HashMap;
import java.util.Scanner;

public class CreateRoomTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HttpClient client = new HttpClient();
        System.out.println(client);
        System.out.println(client.getVerbose().getBody());

        sc.nextInt();
    }
}
