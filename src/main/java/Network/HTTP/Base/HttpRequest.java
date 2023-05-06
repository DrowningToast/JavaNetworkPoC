package Network.HTTP.Base;

import java.net.URL;

public class HttpRequest implements Runnable {

    private final HttpRequestEventHandler eventHandler;
    private final URL url;

    public HttpRequest(HttpRequestEventHandler args, URL url) {
        this.eventHandler = args;
        this.url = url;
    }

    @Override
    public void run() {
        // Execute the function
        try {
            HttpResponse response = eventHandler.executeRequest(url);
            onSuccess(response);
            // Handle on request complete
        } catch (Exception e) {
            onFail(e);
        }

    }

    void onSuccess(HttpResponse httpResponse) {
        eventHandler.onSuccess(httpResponse);
    }

    void onFail(Exception e) {
        eventHandler.onFail(e);
    }
}
