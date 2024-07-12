package ua.mibal.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.mibal.bot.model.Quote;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Configuration
public class QuotesConfig {

    @Bean
    List<Quote> quotes() {
        // TODO
        return List.of();
    }
}
