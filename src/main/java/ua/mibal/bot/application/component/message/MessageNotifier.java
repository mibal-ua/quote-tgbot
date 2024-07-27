package ua.mibal.bot.application.component.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.application.exception.TelegramAnswerException;
import ua.mibal.bot.application.repository.SubscriberRepository;
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
    private final SubscriberRepository subscriberRepository;

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
                "Type /control to see all commands.\n" +
                "Let's start our journey together by typing /subscribe!"
        );
        sender.send(message);
    }

    public void notifyUnknownCommandFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "I can't understand your input.\n" +
                "You can start our journey by typing /subscribe."
        );
        sender.send(message);
    }

    public void notifySubscribedFor(UpdateDto update) {
        Integer chatId = update.message().chat().id();
        Subscriber subscriber = subscriberRepository.findOneByChatId(chatId)
                .orElseThrow(() -> new TelegramAnswerException(chatId, "An error occurred while subscribing :("));
        Message message = new Message(
                chatId,
                "You have successfully subscribed to the quotes and GIFs.\n" +
                "Your themes: " + String.join(", ", subscriber.getThemes()) + ".\n" + 
                "I will send you a new quote and GIF once per 3 days at 10:00 by Kyiv.\n" + 
                "I can't wait until our journey begins!\n" + 
                "PS: You can check your settings by typing /my_settings."
        );
        sender.send(message);
    }

    public void notifyAddThemeModeEnabledFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "You have enabled mode of adding themes. Please write (in EN) list of themes you like in one message.\n" +
                "Example: `Rammstein, Porsche, Java`."
        );
        sender.send(message);
    }

    public void notifyMySettingsFor(UpdateDto update) {
        Integer chatId = update.message().chat().id();
        Subscriber subscriber = subscriberRepository.findOneByChatId(chatId)
                .orElseThrow(() -> new TelegramAnswerException(chatId, "An error occurred while getting your settings :("));
        Message message = new Message(
                chatId,
                "Your themes: " + String.join(", ", subscriber.getThemes()) + ".\n" +
                "Schedule: once per 3 days at 10:00 by Ukraine/Kyiv.\n" +
                "God bless you!"
        );
        sender.send(message);
    }

    public void notifyUnsubscribedFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "You have successfully unsubscribed from the quotes and GIFs.\n" +
                "I will miss you, but you can always come back by typing /subscribe."
        );
        sender.send(message);
    }

    public void notifyAlreadySubscribedFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "You have already subscribed.\n" +
                "If you want to change your themes, type /unsubscribe and then /subscribe."
        );
        sender.send(message);
    }

    public void notifyControlFor(UpdateDto update) {
        Message message = new Message(
                update.message().chat().id(),
                "You can control me by sending these commands:\n" +
                "/subscribe - subscribe to the quotes and GIFs\n" +
                "/my_settings - get your settings\n" +
                "/unsubscribe - unsubscribe from the quotes and GIFs\n" +
                "/control - get the list of commands\n" +
                "I can't wait until our journey begins!"
        );
        sender.send(message);
    }
}
