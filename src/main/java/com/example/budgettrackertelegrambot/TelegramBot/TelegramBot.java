package com.example.budgettrackertelegrambot.TelegramBot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component

public class TelegramBot extends TelegramLongPollingBot {
    private final CommandsHandler commandsHandler;
    private final BotConfig botConfig;
    @Autowired
    public TelegramBot(CommandsHandler commandsHandler, BotConfig botConfig){
        this.commandsHandler = commandsHandler;;
        this.botConfig = botConfig;

    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            if (update.getMessage().getText().startsWith("/")) {
                sendMessage(commandsHandler.handleCommand(update));

            }
            commandsHandler.handleCommand(update);
        } else if (update.hasCallbackQuery()){
            sendMessage(commandsHandler.handleCallback(update));
        }
    }
    private void sendMessage(SendMessage sendMessage){
        try {
            execute(sendMessage);
        }catch (TelegramApiException e){

        }
    }


}

