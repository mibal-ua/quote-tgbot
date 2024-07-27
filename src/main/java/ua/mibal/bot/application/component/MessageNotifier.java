package ua.mibal.bot.application.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Message;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class MessageNotifier {
    private final MessageBuilder messageBuilder;
    private final MessageSender messageSender;
    
    public void notifyQuoteFor(ChatDto chat) {
        Message message = messageBuilder.buildQuoteFor(chat);
        messageSender.send(message);
    }
}
