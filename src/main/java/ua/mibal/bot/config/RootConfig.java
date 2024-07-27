package ua.mibal.bot.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.mibal.bot.application.QuoteService;
import ua.mibal.bot.config.props.BotProps;
import ua.mibal.bot.model.ChatDto;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@EnableScheduling
@EnableConfigurationProperties({
        BotProps.class,
        BotProps.GifProps.class
})
@Configuration
public class RootConfig {
    private static final Logger log = LoggerFactory.getLogger(RootConfig.class);
    private final QuoteService quoteService;

    @Bean
    CommandLineRunner setup() {
        return args -> List.of(
                        new ChatDto(623832541, "Anna", "Bybko", "Bybko_Anna", "private"),
                        new ChatDto(536140066, "Michael Fierce", "Balakhon", "mibal_ua", "private")
                )
                .stream()
                .peek(chat -> log.info("Added default chat {}", chat))
                .forEach(quoteService::addRecipient);
    }
}
