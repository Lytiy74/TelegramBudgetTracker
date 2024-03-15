package com.example.budgettrackertelegrambot.TelegramBot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class CallbackHandler {
    public SendMessage recieveCallback(Update update){
        return new SendMessage();
    }
}
