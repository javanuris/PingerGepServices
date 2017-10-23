package kz.pinnger.pinger.services;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class PingerBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message!=null && message.hasText()){
            if(message.getText().equals("/help")){
                keyBoard(message);
            }else{
                sendMsg(message, " Я не знаю что ответить на это");
            }
        }
    }

    private void keyBoard(Message message){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<List<InlineKeyboardButton>>();
        List<InlineKeyboardButton> rowInline = new ArrayList<InlineKeyboardButton>();
        rowInline.add(new InlineKeyboardButton().setText("Update Massage").setCallbackData("update msg test"));
        rowsInline.add(rowInline);
        markup.setKeyboard(rowsInline);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setReplyMarkup(markup);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.enableMarkdown(true);
        sendMessage.setText("something");
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    private void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    public String getBotUsername() {
        return "gep_notifier_bot";
    }

    public String getBotToken() {
        return "421903934:AAFC_F-6g8BFe5oEZqs7aGNctDUCcltXCBA";
    }

}

