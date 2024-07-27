package ua.mibal.bot.application.component.photo;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.mibal.bot.config.props.BotProps.GifProps;
import ua.mibal.bot.model.Gif;
import ua.mibal.bot.model.GifsResponse;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Component
public class GiphyGifRepository implements GifRepository {
    private final String requestUrlApi;

    public GiphyGifRepository(GifProps props) {
        requestUrlApi = "https://api.giphy.com/v1/gifs/search?api_key=" + props.apiKey() + "&q={q}&limit=5";
    }

    @Override
    public List<Gif> findAllByTheme(String theme) {
        return new RestTemplate()
                .exchange(
                        requestUrlApi,
                        GET,
                        null,
                        GifsResponse.class,
                        theme
                )
                .getBody()
                .data();
    }
}
