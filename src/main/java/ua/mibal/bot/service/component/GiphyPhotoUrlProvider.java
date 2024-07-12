package ua.mibal.bot.service.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.mibal.bot.config.props.BotProps.GifProps;
import ua.mibal.bot.model.GifDto;
import ua.mibal.bot.model.GifsResponse;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@Component
public class GiphyPhotoUrlProvider implements PhotoUrlProvider {
    private final String requestUrlApi;
    private final List<String> themes;

    public GiphyPhotoUrlProvider(GifProps props) {
        this.themes = props.themes();
        this.requestUrlApi = "https://api.giphy.com/v1/gifs/search?api_key=" + props.apiKey() + "&q={q}&limit=20";
    }

    @Override
    public String getUrl() {
        String theme = themes.get((int) (Math.random() * themes.size()));
        List<String> gifsByTheme = getGifsBy(theme);
        log.info("Gifs by theme {}: {}", theme, gifsByTheme);
        return gifsByTheme.get((int) (Math.random() * gifsByTheme.size()));
    }

    private List<String> getGifsBy(String theme) {
        return new RestTemplate()
                .exchange(
                        requestUrlApi,
                        GET,
                        null,
                        GifsResponse.class,
                        theme
                )
                .getBody()
                .data()
                .stream()
                .map(GifDto::url)
                .toList();
    }
}
