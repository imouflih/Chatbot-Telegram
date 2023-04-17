package fr.ensim.interop.introrest;

import fr.ensim.interop.introrest.service.TelegramService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupMessageSender {

    private final TelegramService telegramService;

    public StartupMessageSender(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Bean
    public CommandLineRunner sendStartupMessage() {
        return args -> {
            String chatId = "5802488861";
            String startupMessage = "Relancement du Bot";
            telegramService.sendMessage(chatId, startupMessage);
        };
    }
}
