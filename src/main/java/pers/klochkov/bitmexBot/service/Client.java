package pers.klochkov.bitmexBot.service;

import pers.klochkov.bitmexBot.constants.URL.URL;
import pers.klochkov.bitmexBot.constants.URL.UrlBuilder;
import pers.klochkov.bitmexBot.constants.URL.ResourceUrl;
import pers.klochkov.bitmexBot.constants.URL.UtilUrl;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;


public class Client {

    private boolean isTestnet;
    private String apiKey;
    private String apiSecret;
    private final HttpClient client;

    public Client(String apiKey, String apiSecret, HttpClient client) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> sendOrder(Order order) {
        URL url = new UrlBuilder()
                .protocol(UtilUrl.PROTOCOL)
                .net(getNet())
                .baseUrl(UtilUrl.BASE_URL)
                .apiPath(UtilUrl.API_PATH)
                .recoursePath(ResourceUrl.ORDER)
                .build();

    }










        private String getNet() {
            return isTestnet ? UtilUrl.TESTNET : UtilUrl.REALNET;
        }
}
