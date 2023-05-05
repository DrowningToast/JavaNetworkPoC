package org.example;

import Network.Websocket.Base.WebsocketEndpoint;
import Network.Websocket.Client.WebsocketClient;

import java.util.Scanner;

public class WebsocketTest {
    public static void main(String[] args) {
        WebsocketEndpoint endpoint = new WebsocketClient();

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}
