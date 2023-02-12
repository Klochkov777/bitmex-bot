package pers.klochkov.bitmexBot.service.authenticator;

import pers.klochkov.bitmexBot.constants.TypeRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;


public class AppTestRequest {
    public static String pathConst = "https://testnet.bitmex.com";
    public static String path = "/api/v1/order";
//    String expires = Math.round(new Date().getTime() / 1000) + 60, // 1 min in the future
    public static String expires = String.valueOf(Instant.now().getEpochSecond() + 10000);
    public static String data = "{symbol:\"XBTUSD\",side:\"Buy\",ordType:\"Limit\",price:590,orderQty:1}";

    public static void main(String[] args) throws IOException, InterruptedException {
        String apiSecret = "H-3TPkjWFLG7nDzFDKR4W-aCe08M51iLMUKd787um6Av0RW9";
        Signature signature = new Signature();
        byte[] sig = signature.createSignature(apiSecret, TypeRequest.POST, path, expires, data);
        String signat = signature.signatureToHEXString(sig);

        String si = new Hmac().createHMAC256("H-3TPkjWFLG7nDzFDKR4W-aCe08M51iLMUKd787um6Av0RW9", TypeRequest.POST, path, expires, data);


        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .header("api-signature", signat)
                .header("api-expires", expires)
                .header("api-key", "H-0QqcPQ1gyiiRzNfcrTpK-D")
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept", "application/json")
                .uri(URI.create(pathConst + path))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}
