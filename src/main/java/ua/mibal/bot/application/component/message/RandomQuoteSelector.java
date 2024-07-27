package ua.mibal.bot.application.component.message;

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
public class RandomQuoteSelector {
    private final QuoteRepository quoteRepository;

    public Quote getQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.get(
                (int) (Math.random() * quotes.size())
        );
    }
}
