package kz.pinnger.pinger.tasks;
import kz.pinnger.pinger.utils.HttpRequestUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class GepAdminServiceTask {

    private String url;

    public GepAdminServiceTask() {
    }


    @Scheduled(fixedRate = 3000)
    private void test(){
        System.out.println(url);
    }
    @Scheduled(cron = "0 0 6 * * *")
    private void unprocessedStatuses() {
        String urlAddress = url+"/fileGenerationTelegram";
        int responseCode;
        responseCode = HttpRequestUtil.httpGetRequest(urlAddress);
        System.out.println("Sending 'GET' request to URL : " + urlAddress);
        System.out.println("Response Code : " + responseCode);
    }

    @Scheduled(cron = "0 15 15 * * MON-FRI")
    private void checkFileGeneration() {
        String urlAddress = url+"/fileGenerationTelegram";
        int responseCode;
        responseCode = HttpRequestUtil.httpGetRequest(urlAddress);
        System.out.println("Sending 'GET' request to URL : " + urlAddress);
        System.out.println("Response Code : " + responseCode);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
