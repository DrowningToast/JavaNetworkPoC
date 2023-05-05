package Network.HTTP;

import Network.HTTP.Base.HttpController;
import Network.HTTP.Base.HttpResponse;

import java.io.IOException;
import java.net.URL;

public class HttpClient extends HttpController {

    private final String httpURLPath = "https://tnjylm3on5.execute-api.ap-southeast-1.amazonaws.com";

    public HttpClient() {
        System.out.println(this.httpURLPath);
        super.httpUrl = this.httpURLPath;
    }

    public HttpResponse getPing() {
        try {
            HttpResponse response = super.httpGET(new URL(httpURLPath + "/ping"));
            System.out.println(response.getBody());
            return response;
        } catch (IOException e) {
            System.out.println("FUCK");
            e.printStackTrace();
        }
        System.out.println("FUCKO FF");
        return null;
    }

    public HttpResponse getVerbose() {
        try {
            HttpResponse response = super.httpGET(new URL(httpURLPath + "/verbose"));
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
