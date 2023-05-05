package Network.HTTP.Base;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public abstract class HttpController {
    protected String httpUrl;

    public static HashMap<String, Object> parseJSONtoHashMap(String string) {
        Gson gson = new Gson();
        Type type = new HashMap<String, Object>().getClass();

        HashMap<String, Object> hashMap = gson.fromJson(string, type);
        return hashMap;
    }

    public static String parseHashMaptoString(HashMap hashMap) {
        Gson gson = new Gson();
        return gson.toJson(hashMap);
    }

    protected HttpResponse httpGET(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        HttpResponse httpResponse = new HttpResponse(inputStreamReader);

        return httpResponse;
    }

    protected HttpResponse httpPOST(URL url, HashMap body) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String bodyAsString = parseHashMaptoString(body);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
        outputStreamWriter.write(bodyAsString);
        outputStreamWriter.close();

        // response
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        HttpResponse response = new HttpResponse(inputStreamReader);
        return response;
    }
}
