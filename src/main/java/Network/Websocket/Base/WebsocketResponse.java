package Network.Websocket.Base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;

public class WebsocketResponse<T> {
    private String raw;
    private String status;
    private String handler;
    private HashMap hashMap;

    public WebsocketResponse(
            String raw) {
        Gson gson = new Gson();
        Type type = new HashMap<String, Object>().getClass();

        HashMap<String, String> hashMap = gson.fromJson(raw, type);
        this.hashMap = hashMap;

        this.handler = hashMap.get("handler");
        this.status = hashMap.get("status");
        this.raw = raw;
    }

    public WebsocketResponseMessage<T> getMessage() {
        ObjectMapper objectMapper = new ObjectMapper();
        WebsocketResponseMessage<T> message = objectMapper.convertValue(hashMap, WebsocketResponseMessage.class);

        return message;
    }

    public String getRaw() {
        return this.raw;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isError() {
        return this.status.equals("OK");
    }

    public WebsocketError getError() {
        WebsocketResponseMessage message = getMessage();
        return message.getError();
    }

    public String getHandler() {
        return this.handler;
    }

    public T getContent() {
        return getMessage().getContent();
    }
}
