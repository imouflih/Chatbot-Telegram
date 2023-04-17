package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.telegram.ApiResponseTelegram;
import fr.ensim.interop.introrest.service.TelegramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// The MessageRestController class is a REST Controller that handles message-related requests.
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageRestController {
    // The TelegramService object is used to send messages through the Telegram API.
    private final TelegramService telegramService;

    // This method handles POST requests to "/message" and sends a text message to a specified chat ID.
    @PostMapping
    public ResponseEntity<ApiResponseTelegram> sendMessage(
            @RequestParam(value = "chatId") String chatId,
            @RequestParam("texte") String text
    ) {
        // Send the text message using the TelegramService and get the ApiResponseTelegram object.
        ApiResponseTelegram response = telegramService.sendMessage(chatId, text);

        // Return the ApiResponseTelegram object as a JSON object.
        return ResponseEntity.ok().body(response);
    }
}
