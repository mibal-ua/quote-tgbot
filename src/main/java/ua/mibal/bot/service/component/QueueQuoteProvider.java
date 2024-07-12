package ua.mibal.bot.service.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.Quote;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class QueueQuoteProvider implements QuoteProvider {
    private final List<Quote> quotes;
    private int counter = 0;

    @Override
    public Quote getQuote() {
        return quotes.get(counter++ % quotes.size());
    }
}
