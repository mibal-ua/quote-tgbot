package ua.mibal.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.UpdateDto;
import ua.mibal.bot.service.component.MessageBuilder;
import ua.mibal.bot.service.component.MessageSender;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class BotService {
    private final MessageBuilder builder;
    private final MessageSender sender;
    private final QuoteService quoteService;

    public void processUpdate(UpdateDto update) {
        if ("/start".equals(update.message().text())) {
            Message message = builder.buildHelloMessageFor(update.message());
            sender.send(message);
            quoteService.addRecipient(update.message().chat());
        } else {
            Message message = builder.buildMessageNotRecognizedAsCommandMessageFor(update.message());
            sender.send(message);    
        }
    }
}
