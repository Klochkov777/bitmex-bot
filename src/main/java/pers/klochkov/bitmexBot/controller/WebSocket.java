package pers.klochkov.bitmexBot.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpointConfig;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebSocket extends Endpoint {
    private String url;
    private Session session;
    StringBuffer output;

    public WebSocket(String url, StringBuffer stringBuffer) {
        super();
        this.url = url;
        this.output = stringBuffer;
    }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig){
        this.session = session;
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                output.setLength(0);
                output.append(message);
            }
        });
    }

    public void connect() throws URISyntaxException, DeploymentException, IOException {
        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
        ClientEndpointConfig config = ClientEndpointConfig.Builder.create()
                .configurator(new ClientEndpointConfig.Configurator())
                .build();
        webSocketContainer.connectToServer(this, config, new URI(url));
    }

    public void sendMessage(String message) {
        session.getAsyncRemote().sendText(message);
    }
}
