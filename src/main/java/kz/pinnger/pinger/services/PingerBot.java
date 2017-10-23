package kz.pinnger.pinger.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
@ConfigurationProperties
public class PingerBot extends TelegramLongPollingBot {
    Logger log = LoggerFactory.getLogger(PingerBot.class);

    private String token;
    private String chetId;
    private String botName;

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        log.info(message.toString());

        sendMsg(message , "Text" + message.getText() + "/" + message.getChatId());
        if(message!=null && message.hasText()){
            if(message.getText().equals("/help")){
                sendMsg(message, " Я  знаю что ответить на это");
            }else{
                sendMsg(message, " Я не знаю что ответить на это");
            }
        }
    }


    private void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error in sending massage to client " , e);
        }

    }

    public String getBotUsername() {
        return "pinger_bot";
    }

    public String getBotToken() {
        return "421903934:AAFC_F-6g8BFe5oEZqs7aGNctDUCcltXCBA";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getChetId() {
        return chetId;
    }

    public void setChetId(String chetId) {
        this.chetId = chetId;
    }

    public String getBotName() {
        return botName;
    }
    public void setBotName(String botName) {
        this.botName = botName;
    }
}

