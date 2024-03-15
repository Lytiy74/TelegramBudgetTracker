package com.example.budgettrackertelegrambot.TelegramBot.Commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class BalanceCommand implements Command {
    @Override
    public SendMessage apply(Update update) {
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(String.format(Consts.BALANCE_MESSAGE.getText(),500));
        //todo

        addKeyboard(sendMessage);

        return sendMessage;
    }
    private void addKeyboard(SendMessage sendMessage){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        InlineKeyboardButton expenseButton = new InlineKeyboardButton();
        expenseButton.setText("📉 add an expense");
        expenseButton.setCallbackData("SET_EXPENSE");
        keyboardButtonsRow1.add(expenseButton);
        InlineKeyboardButton incomeButton = new InlineKeyboardButton();
        incomeButton.setText("📈 add income");
        incomeButton.setCallbackData("SET_INCOME");
        keyboardButtonsRow1.add(incomeButton);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }
}
