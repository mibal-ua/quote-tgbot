package ua.mibal.bot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.mibal.bot.config.props.BotProps;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@EnableScheduling
@EnableConfigurationProperties({
        BotProps.class,
        BotProps.GifProps.class
})
@Configuration
public class RootConfig {
}
