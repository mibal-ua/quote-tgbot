package ua.mibal.bot.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.application.component.message.MessageNotifier;
import ua.mibal.bot.application.component.photo.PhotoNotifier;
import ua.mibal.bot.application.repository.SubscriberRepository;
import ua.mibal.bot.domain.Subscriber;
import ua.mibal.bot.model.ChatDto;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class QuoteService {
    private final SubscriberRepository subscriberRepository;
    private final MessageNotifier messageNotifier;
    private final PhotoNotifier photoNotifier;

    public void send() {
        for (Subscriber subscriber : subscriberRepository.findAll()) {
            messageNotifier.notifyQuoteFor(subscriber.getChatId());
            photoNotifier.notifyQuotePhotoFor(subscriber.getChatId());
        }
    }

    public void addSubscriber(ChatDto chat) {
        Subscriber subscriber = new Subscriber();
        subscriber.setChatId(chat.id());
        subscriber.setUsername(chat.username());
        subscriberRepository.save(subscriber);
    }
}
