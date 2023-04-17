package fr.ensim.interop.introrest.service;

import fr.ensim.interop.introrest.model.telegram.ApiResponseTelegram;
import fr.ensim.interop.introrest.model.telegram.ApiResponseUpdateTelegram;
import fr.ensim.interop.introrest.model.telegram.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramService {
    private final RestTemplate restTemplate;
    @Value("${telegram.api.url}")
    private String telegramApiUrl;

    public ApiResponseTelegram sendMessage(String chatId, String text){
        log.info("send message : {} to chatId: {}", text, chatId);;
        return restTemplate.getForObject(telegramApiUrl + "sendMessage?chat_id={chat_id}&text={text}",
                ApiResponseTelegram.class,
                chatId,
                text
        );
    }

    public ApiResponseTelegram replyMessage(String chatId, String text, Integer messageId){
        Integer reply_to_message_id = messageId;
        log.info("send message : {} to chatId: {}", text, chatId);;
        return restTemplate.getForObject(telegramApiUrl + "sendMessage?chat_id={chat_id}&text={text}&reply_to_message_id={reply_to_message_id}",
                ApiResponseTelegram.class,
                chatId,
                text,
                reply_to_message_id
        );
    }

    public ApiResponseUpdateTelegram getUpdates(Integer offset){
        return restTemplate.getForObject(telegramApiUrl + "getUpdates?offset={offset}",
                ApiResponseUpdateTelegram.class, offset);
    }


}
