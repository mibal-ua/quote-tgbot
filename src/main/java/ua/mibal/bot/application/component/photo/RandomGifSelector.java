package ua.mibal.bot.application.component.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.domain.Subscriber;
import ua.mibal.bot.model.Gif;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class RandomGifSelector {
    private static final String GET_GIF_BY_ID_API = "https://i.giphy.com/media/%s/giphy.gif";
    private final GifRepository gifRepository;

    public String getGifUrlFor(Subscriber subscriber) {
        List<String> themes = subscriber.getThemes();
        String randomTheme = getRandomOf(themes);

        List<Gif> gifs = gifRepository.findAllByTheme(randomTheme);
        Gif randomGif = getRandomOf(gifs);

        return getUrlOf(randomGif);
    }

    private String getUrlOf(Gif gif) {
        return GET_GIF_BY_ID_API.formatted(gif.id());
    }

    private <T> T getRandomOf(List<T> elements) {
        return elements.get(
                (int) (Math.random() * elements.size())
        );
    }
}
