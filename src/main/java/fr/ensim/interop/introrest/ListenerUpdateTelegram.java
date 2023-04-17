package fr.ensim.interop.introrest;

import fr.ensim.interop.introrest.controller.JokeController;
import fr.ensim.interop.introrest.controller.MovieController;
import fr.ensim.interop.introrest.controller.WeatherController;
import fr.ensim.interop.introrest.model.Movie.Movie;
import fr.ensim.interop.introrest.model.openWeather.OpenWeather;
import fr.ensim.interop.introrest.model.telegram.ApiResponseUpdateTelegram;
import fr.ensim.interop.introrest.model.telegram.Message;
import fr.ensim.interop.introrest.service.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListenerUpdateTelegram {
    private final WeatherController weatherController;
    private final JokeController jokeController;
    private final TelegramService telegramService;
    private final MovieController movieController;
    private Integer lastConsumedUpdateId = 0;

    @Scheduled(fixedRate = 2000)
    public void bot() {
        ApiResponseUpdateTelegram updates = telegramService.getUpdates(lastConsumedUpdateId);

        if (!updates.getResult().isEmpty()) {
            updates.getResult().forEach(update -> {
                Message message = update.getMessage();
                Long chatId = message.getChat().getId();
                String text = message.getText();
                String response = processCommand(text);

                telegramService.replyMessage(chatId.toString(), response, message.getMessageId());
            });

            int lastUpdateIndex = updates.getResult().size() - 1;
            lastConsumedUpdateId = updates.getResult().get(lastUpdateIndex).getUpdateId() + 1;
        }
    }

    private String processCommand(String text) {
        if (text.startsWith("Meteo ")) {
            return processWeatherCommand(text.substring(6));
        } else if (text.equals("Blague")) {
            return processJokeCommand();
        } else if (text.equals("Film")) {
            return processMovieCommand();
        } else {
            return "Commande inconnue : Essayez avec la commande Meteo <nom_de_la_ville> ou la commande Blague ou la commande Film\n";
        }
    }

    private String processWeatherCommand(String ville) {
        OpenWeather weather = weatherController.weather(ville, false).getBody();

        if (weather == null) {
            return "Cette ville n'existe pas\n";
        } else {
            return ville + " " + weather.toString();
        }
    }

    private String processJokeCommand() {
        return jokeController.joke().getBody().toString();
    }

    private String processMovieCommand() {
        return movieController.movie().getBody().toString();
    }
}
