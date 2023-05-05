package Network.Websocket.Base;

public interface WebsocketResponseHandler {
    public <T> void onTrigger(T content);
}
