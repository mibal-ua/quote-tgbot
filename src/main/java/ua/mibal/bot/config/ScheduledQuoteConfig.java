package ua.mibal.bot.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import ua.mibal.bot.application.QuoteService;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Configuration
public class ScheduledQuoteConfig {
    private static final Logger log = LoggerFactory.getLogger(ScheduledQuoteConfig.class);
    private final QuoteService service;

    @Scheduled(cron = "0 0 10 */3 * *", zone = "Europe/Kiev")
    public void sendQuoteEveryDayAt10AmByUkraine() {
        log.info("Sending quote");
        service.send();
    }
}
