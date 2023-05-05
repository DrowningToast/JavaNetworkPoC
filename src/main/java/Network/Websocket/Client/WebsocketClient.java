package Network.Websocket.Client;

import Network.Websocket.Base.WebsocketEndpoint;
import Network.Websocket.Base.WebsocketResponse;
import Network.Websocket.Base.WebsocketResponseHandler;

import javax.websocket.OnOpen;

public class WebsocketClient extends WebsocketEndpoint {
    @Override
    @OnOpen
    public void onMessage(String raw) throws Exception {
        System.out.println(raw);

        // get response
        WebsocketResponse response = new WebsocketResponse(raw);
        if (response.isError()) {
            System.out.println(response.getMessage().getError().getErrorID());
            throw new Exception("Error response");
        }

        // get handler
        WebsocketResponseHandler handler = responseHandlers.get(response.getHandler());
        System.out.println(response.getMessage().getHandler());

        if (handler == null) {
            System.out.println("Can't find event handler");
        } else {
            System.out.println("Found event handler");
        }
    }
}
