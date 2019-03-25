package httpclient;

import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.tinylog.Logger;

import java.io.IOException;



public class LinkStatus {
    private  HttpGet request;
    private HttpResponse response;

    /**
     * Get Status code of link
     * @param link
     * @return
     */
    public int makerequest(String link){
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            request  = new HttpGet(link);
            response = httpClient.execute(request);
        } catch (IOException e) {
            Logger.error("make request");
        }
        return response.getStatusLine().getStatusCode();
    }

}
