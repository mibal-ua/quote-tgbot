package ua.mibal.bot.service.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.mibal.bot.config.props.BotProps;
import ua.mibal.bot.model.Method;

import java.util.Map;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.POST;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Component
public class TelegramMethodPerformer {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String urlFormat;

    public TelegramMethodPerformer(BotProps props) {
        this.urlFormat = "https://api.telegram.org/bot" + props.token() + "/%s";
    }

    public void perform(Method method, Map<String, Object> params) {
        method.validateParams(params);
        String url = format(urlFormat, method.getMethodName());
        restTemplate.execute(url, POST, null, null, params);
    }
}
