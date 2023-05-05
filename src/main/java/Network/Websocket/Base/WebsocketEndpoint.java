package Network.Websocket.Base;


import javax.websocket.*;
import java.awt.*;
import java.util.HashMap;

@ClientEndpoint
public abstract class WebsocketEndpoint {

    protected HashMap<String, WebsocketResponseHandler> responseHandlers = new HashMap();
    protected WebSocketContainer container;
    protected Session session;

    public WebsocketEndpoint() {
        this.container = Container
    }

    public void addHandler(String handler, WebsocketResponseHandler eventHandler) {
        responseHandlers.put(handler, eventHandler);
    }

    @OnOpen
    public void onOpen() {
        System.out.println("Websocket service is connected");
    }

    @OnMessage
    public abstract void onMessage(String raw) throws Exception;

    @OnClose
    public void onClose() {
        System.out.println("Disconnected");
    }
}
