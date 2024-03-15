package com.example.budgettrackertelegrambot.TelegramBot;

import com.example.budgettrackertelegrambot.TelegramBot.Commands.Command;
import com.example.budgettrackertelegrambot.TelegramBot.Commands.StartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.example.budgettrackertelegrambot.TelegramBot.Commands.Consts;

import java.util.Map;

@Component
public class CommandsHandler {
    private final Map<String , Command> commands;
    public CommandsHandler(@Autowired StartCommand startCommand) {
        this.commands = Map.of(
                "/start", startCommand
        );
    }
    public SendMessage handleCommand(Update update){
        var commandsHandler = commands.get(update.getMessage().getText());
        if (commandsHandler != null){
            return commandsHandler.apply(update);
        } else {
            return new SendMessage(String.valueOf(update.getMessage().getChatId()), Consts.UNKNOWN_COMMAND.getText());
        }
    }
}
