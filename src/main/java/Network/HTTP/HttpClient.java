package Network.HTTP;

import Network.HTTP.Base.HttpRequestEventHandler;
import Network.HTTP.Base.HttpThreadManager;
import Network.HTTP.Base.HttpResponse;

import java.net.URL;

public class HttpClient extends HttpThreadManager {

    public HttpClient() {
        super("http://localhost:5000");
    }

    /**
     * เป็น attribute ที่เอาไว้กับ response ที่อยากจะเก็บเฉยๆ
     */
    private HttpResponse bufferedResponse;

    /**
     * อย่า getBufferedResponse หลังจากทำ Request ทันทีเพราะว่า Request อาจจะยังไม่เสร็จเนื่องจากรันอยู่อีก Thread
     *
     * @return
     */
    public HttpResponse getBufferedResponse() {
        return bufferedResponse;
    }

    /**
     * CUSTOM REQUEST METHODS:
     * <p>
     * เขียนโดยการเรียกใช้ method makeRequest() แล้วใส่เงื่อนไขและ Event ต่างๆ ลงไปดังตัวอย่าง
     * นอกจากนี้ยังมี method httpGET กับ httpPOST ของ parent class ที่สามารถเรียกใช้ได้
     * <p>
     * การหลีกเลี่ยงการใช้งาน htppGET กับ httpPOST เองโดยตรงไม่ผ่าน makeRequest จะป้องกันการ block main thread
     */

    public HttpClient getHelloWorld() {
        makeRequest(new HttpRequestEventHandler() {
            @Override
            public HttpResponse executeRequest(URL url) throws Exception {
                HttpResponse response = httpGET(new URL(url + "/"));
                return response;
            }

            @Override
            public void onSuccess(HttpResponse response) {
                bufferedResponse = response;
            }

            @Override
            public void onFail(Exception e) {

            }
        });
        return this;
    }

    public HttpClient getPing() {

        makeRequest(new HttpRequestEventHandler() {
            @Override
            public HttpResponse executeRequest(URL url) throws Exception {
                HttpResponse response = httpGET(new URL(url + "/ping"));
                return response;
            }

            @Override
            public void onSuccess(HttpResponse response) {
                bufferedResponse = response;
            }

            @Override
            public void onFail(Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        });

        return this;
    }

    /**
     * YOUR ROUTES HERE
     */
}
