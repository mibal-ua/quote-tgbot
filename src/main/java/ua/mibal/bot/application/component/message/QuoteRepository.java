package ua.mibal.bot.application.component.message;

import ua.mibal.bot.model.Quote;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface QuoteRepository {

    List<Quote> findAll();
}
