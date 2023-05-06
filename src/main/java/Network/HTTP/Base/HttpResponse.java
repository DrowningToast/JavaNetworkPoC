package Network.HTTP.Base;

import JSON.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HttpResponse {
    private String value;

    public String getRawBody() {
        return value;
    }

    public HttpResponse(InputStreamReader inputStreamReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String inputLine;
        StringBuffer stringBuffer = new StringBuffer();

        while ((inputLine = bufferedReader.readLine()) != null) {
            stringBuffer.append(inputLine);
        }

        // close
        bufferedReader.close();
        inputStreamReader.close();

        String result = stringBuffer.toString();
        this.value = result;
    }

    public HashMap getMap() {
        HashMap hashMap = JSON.parseJSONtoHashMap(value);
        return hashMap;
    }
}
