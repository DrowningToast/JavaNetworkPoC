package org.example;


import Network.Websocket.Base.BaseClient;


import java.net.URI;
import java.util.Scanner;

public class WebsocketTest {
    public static void main(String[] args) throws Exception {

        // open websocket
        final BaseClient clientEndPoint = new BaseClient(
                new URI("ws://localhost:6000"));
// add listener
        clientEndPoint.addMessageHandler(new BaseClient.MessageHandler() {
            public void handleMessage(String message) {
                System.out.println(message);
            }
        });
// send message to websocket
        clientEndPoint.sendMessage("Message sent from client!");

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}
