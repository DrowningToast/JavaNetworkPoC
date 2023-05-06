package Network.HTTP.Base;

import java.net.URL;

public class HttpThreadManager extends HttpController {

    public HttpThreadManager() {
    }

    private String httpURLPath = "http://localhost:5000";

    public HttpThreadManager(String URLPath) {
        this.httpURLPath = URLPath;
        super.httpUrl = this.httpURLPath;
    }

    public void makeRequest(HttpRequestEventHandler args) {
        try {
            // Create new thread to run the request
            Thread thread = new Thread(new HttpRequest(args, new URL(httpURLPath)));
            // Start new thread
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

}
