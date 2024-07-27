package ua.mibal.bot.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.application.component.message.MessageNotifier;
import ua.mibal.bot.model.UpdateDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class BotService {
    private final MessageNotifier messageNotifier;
    private final QuoteService quoteService;

    public void processUpdate(UpdateDto update) {
        if ("/start".equals(update.message().text())) {
            messageNotifier.notifyHelloFor(update);
            quoteService.addSubscriber(update.message().chat());
        } else {
            messageNotifier.notifyUnknownCommandFor(update);
        }
    }
}
