package ua.mibal.bot.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ua.mibal.bot.model.Quote;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Configuration
public class QuotesConfig {
    private final ObjectMapper jsonMapper;

    @Bean
    List<Quote> quotes() {
        return getQuotesFromResources();
    }

    private Resource loadQuotesResource() {
        return new ClassPathResource("static/quotes.json");
    }

    private List<Quote> getQuotesFromResources() {
        try {
            String quotesJson = loadQuotesResource().getContentAsString(UTF_8);
            return jsonMapper.readValue(quotesJson, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
