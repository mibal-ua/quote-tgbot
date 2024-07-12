package ua.mibal.bot.service.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.mibal.bot.config.props.BotProps;
import ua.mibal.bot.model.Method;

import java.util.Map;

import static org.springframework.http.HttpMethod.POST;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@Component
public class TelegramMethodPerformer {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String urlBase;

    public TelegramMethodPerformer(BotProps props) {
        this.urlBase = "https://api.telegram.org/bot" + props.token() + "/";
    }

    public void perform(Method method, Map<String, Object> params) {
        log.info("Perform operation {}, params: {}", method, params);

        restTemplate.exchange(
                method.getUrlBy(urlBase),
                POST,
                null,
                Object.class,
                params
        );
    }
}
