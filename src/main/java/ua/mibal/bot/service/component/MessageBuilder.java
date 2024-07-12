package ua.mibal.bot.service.component;

import org.springframework.stereotype.Component;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.UserDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Component
public class MessageBuilder {

    public Message buildHelloMessageFor(UserDto user) {
        return new Message(
                "Hello, " + user.first_name() + "!\n" +
                "I'm a bot and I'm here to encourage you.\n" +
                "Every day I will send you a new quote to make you feel better.\n" +
                "Let's start our journey together!"
        );
    }
}
