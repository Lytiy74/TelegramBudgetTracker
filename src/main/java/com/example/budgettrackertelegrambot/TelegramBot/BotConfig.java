package com.example.budgettrackertelegrambot.TelegramBot;


import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@Data
@PropertySource("classpath:application.properties")
 class BotConfig {
    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String token;
}
