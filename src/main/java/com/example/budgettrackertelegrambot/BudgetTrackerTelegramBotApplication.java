package com.example.budgettrackertelegrambot;

import com.example.budgettrackertelegrambot.TelegramBot.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class BudgetTrackerTelegramBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        ConfigurableApplicationContext context = SpringApplication.run(BudgetTrackerTelegramBotApplication.class);
        TelegramBot telegramBot = context.getBean(TelegramBot.class);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
