package pers.klochkov.bitmexBot.controller;

import javax.websocket.DeploymentException;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws DeploymentException, URISyntaxException, IOException, InterruptedException {

        String url = "wss://ws.testnet.bitmex.com/realtime";
        StringBuffer output = new StringBuffer();
        WebSocket webSocket = new WebSocket(url, output);
        webSocket.connect();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    webSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }



                    System.out.println("closed");

            }
        });
        thread.start();
//15597823150
        webSocket.sendMessage("{\"op\": \"subscribe\", \"args\": [\"orderBookL2_25:XBTUSD\"]}");
//        webSocket.sendMessage("{\"op\": \"subscribe\", \"args\": [\"connected\"]}");

        while (true) {
            if (!webSocket.getSession().isOpen()) {
                return;
            }
            System.out.println(output);
        }




    }
}
