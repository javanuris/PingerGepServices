package kz.pinnger.pinger;

import kz.pinnger.pinger.services.PingerBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class PingerApplication {

	public static void main(String[] args) {

		SpringApplication.run(PingerApplication.class, args);

		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new PingerBot());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
	}

