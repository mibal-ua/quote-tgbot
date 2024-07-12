package ua.mibal.bot.service.component;

import org.springframework.stereotype.Component;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.MessageDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Component
public class MessageBuilder {

    public Message buildHelloMessageFor(MessageDto messageDto) {
        return new Message(
                messageDto.chat().id(),
                "Hello, " + messageDto.from().first_name() + "!\n" +
                "I'm a bot and I'm here to encourage you.\n" +
                "Every day I will send you a new quote to make you feel better.\n" +
                "Let's start our journey together!"
        );
    }

    public Message buildQuoteFor(ChatDto chat) {
        return new Message(
                chat.id(),
                "Quote of the day:\n" +
                "The only way to do great work is to love what you do.\n" +
                "Steve Jobs"
        );
    }
}
