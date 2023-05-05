package Network.Websocket.Base;

public class WebsocketResponseMessage<T> {

    public WebsocketResponseMessage(String raw) {

    }

    private String status;
    private String handler;
    private T content;
    private WebsocketError error;

    public String getStatus() {
        return status;
    }

    public String getHandler() {
        return handler;
    }

    public T getContent() {
        return content;
    }

    public WebsocketError getError() {
        return error;
    }
}
