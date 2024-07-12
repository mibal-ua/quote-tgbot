package ua.mibal.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import ua.mibal.bot.service.QuoteService;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Configuration
public class ScheduledQuoteConfig {
    private final QuoteService service;

//    @Scheduled(cron = "0 0 9 * * *")
    @Scheduled(cron = "1 * * * * *")
    public void sendQuoteEveryDayAt9Am() {
        service.send();
    }
}
