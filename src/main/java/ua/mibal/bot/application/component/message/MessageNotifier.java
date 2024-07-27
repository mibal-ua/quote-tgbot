package ua.mibal.bot.application.component.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.domain.Subscriber;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.Quote;
import ua.mibal.bot.model.UpdateDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class MessageNotifier {
    private final RandomQuoteSelector randomQuoteSelector;
    private final MessageSender sender;

    public void notifyQuoteFor(Subscriber subscriber) {
        Quote quote = randomQuoteSelector.getQuote();
        Message message = new Message(
                subscriber.getChatId(),
                quote.text() + "\n" +
                "– " + quote.author()
        );
        sender.send(message);
    }

    public void notifyHelloFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "Hello, " + update.message().from().first_name() + "!\n" +
                "I'm a bot and I'm here to encourage you.\n" +
                "Once per 3 days at 10:00 by Kyiv I will send you a new quote to make you feel better.\n" +
                "Let's start our journey together by typing /subscribe!"
        );
        sender.send(message);
    }

    public void notifyUnknownCommandFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "Hello, " + update.message().from().first_name() + "!\n" +
                "I'm a bot and I'm here to encourage you.\n" +
                "You can start our journey by typing /subscribe."
        );
        sender.send(message);
    }

    public void notifySubscribedFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "You have successfully subscribed to the quotes!"
        );
        sender.send(message);
    }
}
