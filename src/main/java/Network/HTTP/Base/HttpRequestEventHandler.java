package Network.HTTP.Base;

import java.net.URL;

public interface HttpRequestEventHandler {

     HttpResponse executeRequest(URL url) throws Exception;
     void onSuccess(HttpResponse response);
     void onFail(Exception e);

}
