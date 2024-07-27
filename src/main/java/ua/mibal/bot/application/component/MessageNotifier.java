package ua.mibal.bot.application.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.UpdateDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class MessageNotifier {
    private final MessageBuilder builder;
    private final MessageSender sender;

    public void notifyQuoteFor(ChatDto chat) {
        Message message = builder.buildQuoteFor(chat);
        sender.send(message);
    }

    public void notifyHelloFor(UpdateDto update) {
        Message message = builder.buildHelloMessageFor(update.message());
        sender.send(message);
    }

    public void notifyUnknownCommandFor(UpdateDto update) {
        Message message = builder.buildMessageNotRecognizedAsCommandMessageFor(update.message());
        sender.send(message);
    }
}
