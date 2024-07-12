package ua.mibal.bot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ua.mibal.bot.config.props.BotProps;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@EnableConfigurationProperties({
        BotProps.class
})
@Configuration
public class RootConfig {
}
