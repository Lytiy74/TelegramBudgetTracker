package com.example.budgettrackertelegrambot.TelegramBot.Commands;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Consts {
    START_MESSAGE("📊 Welcome to Budget Tracker Bot! 📊\n\n" +
            "This bot helps you track your finances. You can monitor your expenses and income, and stay on top of your budget.\n\n" +
            "Get started by adding your transactions with simple commands!\n\n" +
            "📉 To add an expense, use /expense.\n" +
            "📈 To add income, use /income.\n" +
            "💰 To view your current balance, use /balance.\n\n" +
            "Let's start tracking your budget! 💳"),
    BALANCE_MESSAGE("💰 Your Current Balance 💰\n\n" +
            "Your current balance is: %s\n\n" +
            "Keep tracking your finances with Budget Tracker Bot! 💳"),
    UNKNOWN_COMMAND("Error, i dont know this command!");
    private final String text;
    Consts(String text){
        this.text = text;
    }
}
