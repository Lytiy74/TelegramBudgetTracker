package com.example.budgettrackertelegrambot.TelegramBot;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum CallbackType {
    INCOME("/income"),
    EXPOSE("/expose"),
    BALANCE("/balance");
    private final String type;
    CallbackType(String type){
        this.type = type;
    }

}
