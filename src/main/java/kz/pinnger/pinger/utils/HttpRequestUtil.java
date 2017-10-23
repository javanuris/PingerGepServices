package kz.pinnger.pinger.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestUtil {
   static Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);


    public static int httpGetRequest(String address) {
        int responseCode = 0;
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent",  "Mozilla/5.0");
            responseCode = connection.getResponseCode();

        } catch (IOException e) {
            log.error("Http request to server, wrong" , e);
            e.printStackTrace();
        }
        return responseCode;
    }

}
