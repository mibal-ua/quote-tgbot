package ua.mibal.bot.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@ConfigurationProperties("bot")
public record BotProps(
        String token,
        String username
) {
    @ConfigurationProperties("bot.gif")
    public record GifProps(
            String apiKey
    ) {
    }
}
