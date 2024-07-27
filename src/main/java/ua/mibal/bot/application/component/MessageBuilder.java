package ua.mibal.bot.application.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.MessageDto;
import ua.mibal.bot.model.Quote;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class MessageBuilder {
    private final QuoteProvider quoteProvider;

    public Message buildHelloMessageFor(MessageDto messageDto) {
        return new Message(
                messageDto.chat().id(),
                "Hello, " + messageDto.from().first_name() + "!\n" +
                "I'm a bot and I'm here to encourage you.\n" +
                "Every day at 10:00 by Kyiv I will send you a new quote to make you feel better.\n" +
                "Let's start our journey together!"
        );
    }

    public Message buildQuoteFor(ChatDto chat) {
        Quote quote = quoteProvider.getQuote();
        return new Message(
                chat.id(),
                quote.text() + "\n" +
                "Author: " + quote.author()
        );
    }

    public Message buildMessageNotRecognizedAsCommandMessageFor(MessageDto message) {
        return new Message(
                message.chat().id(),
                "Hello, " + message.from().first_name() + "!\n" +
                "I'm a bot and I'm here to encourage you.\n" +
                "You can start our journey by typing /start."
        );
    }
}
