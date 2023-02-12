package pers.klochkov.bitmexBot.constants.URL;

public class UrlBuilder {
    private URL url = new URL();

    public UrlBuilder protocol(String protocol) {
        url.setProtocol(protocol);
        return this;
    }


    public UrlBuilder baseUrl(String baseUrl) {
        url.setBaseUrl(baseUrl);
        return this;
    }

    public UrlBuilder apiPath(String apiPath) {
        url.setApiPath(apiPath);
        return this;
    }

    public UrlBuilder net(String net) {
        url.setNet(net);
        return this;
    }

    public UrlBuilder recoursePath(String resourcePath) {
        url.setResourcePath(resourcePath);
        return this;
    }

    public URL build() {
        return url;
    }
}
