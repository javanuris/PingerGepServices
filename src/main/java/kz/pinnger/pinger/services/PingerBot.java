package kz.pinnger.pinger.services;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
@ConfigurationProperties(prefix = "telegram")
public class PingerBot extends TelegramLongPollingBot {
    private String token;
    private String chetId;
    private String pingerName;

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message);
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
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return pingerName;
    }

    public String getBotToken() {
        return token;
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

    public String getPingerName() {
        return pingerName;
    }

    public void setPingerName(String pingerName) {
        this.pingerName = pingerName;
    }
}

