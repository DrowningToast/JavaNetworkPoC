package Network.HTTP.Base;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import JSON.JSON;

public abstract class HttpController {
    protected String httpUrl;

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

        String bodyAsString = JSON.parseHashMaptoString(body);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
        outputStreamWriter.write(bodyAsString);
        outputStreamWriter.close();

        // response
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        HttpResponse response = new HttpResponse(inputStreamReader);
        return response;
    }
}
