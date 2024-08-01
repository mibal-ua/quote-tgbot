package ua.mibal.bot.application.component.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.Quote;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Component
public class JsonQuoteRepository implements QuoteRepository {
    private final ObjectMapper jsonMapper;

    public JsonQuoteRepository(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Quote> findAll() {
        try {
            String quotesJson = loadQuotesResource().getContentAsString(UTF_8);
            return jsonMapper.readValue(quotesJson, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Resource loadQuotesResource() {
        return new ClassPathResource("static/quotes.json");
    }
}
