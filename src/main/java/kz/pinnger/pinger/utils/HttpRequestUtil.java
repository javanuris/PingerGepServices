package kz.pinnger.pinger.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestUtil {
    public static int httpGetRequest(String address) {
        int responseCode = 0;
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent",  "Mozilla/5.0");
            responseCode = connection.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseCode;
    }

}
