package kz.pinnger.pinger.tasks;
import kz.pinnger.pinger.utils.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class GepAdminServiceTask {
    Logger log = LoggerFactory.getLogger(GepAdminServiceTask.class);

    private String url;

    public GepAdminServiceTask() {
    }

 //   @Scheduled(initialDelay = 30000, fixedRate = 2400000)
    private void unprocessedStatuses() {
        String urlAddress = url+"/statusZapros";
        log.info("statusZapros was send");
        int responseCode;
        responseCode = HttpRequestUtil.httpGetRequest(urlAddress);
        log.info("Sending 'GET' request to URL : " + urlAddress + " | "+"Response Code : " + responseCode );
    }

    @Scheduled(cron = "0 15 15 * * MON-FRI")
    private void checkFileGeneration() {
        String urlAddress = url+"/fileGenerationTelegram";
        log.info("fileGenerationTelegram was send");
        int responseCode;
        responseCode = HttpRequestUtil.httpGetRequest(urlAddress);
        log.info("Sending 'GET' request to URL : " + urlAddress + " | "+"Response Code : " + responseCode );

    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
