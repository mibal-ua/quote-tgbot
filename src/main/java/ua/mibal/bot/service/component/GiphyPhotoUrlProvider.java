package ua.mibal.bot.service.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.mibal.bot.config.props.BotProps.GifProps;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Component
public class GiphyPhotoUrlProvider implements PhotoUrlProvider {
    private final String requestUrlApi;
    private final List<String> themes;

    public GiphyPhotoUrlProvider(GifProps props) {
        this.themes = props.themes();
        this.requestUrlApi = "api.giphy.com/v1/gifs/search?api_key=" + props.apiKey() + "&q={q}&limit=20";
    }

    @Override
    public String getUrl() {
        String theme = themes.get((int) (Math.random() * themes.size()));
        List<String> gifsByTheme = getGifsBy(theme);
        return gifsByTheme.get((int) (Math.random() * gifsByTheme.size()));
    }

    private List<String> getGifsBy(String theme) {
        return new RestTemplate()
                .getForObject(requestUrlApi, List.class, "dc6zaTOxFJmzC", theme);
    }
}
