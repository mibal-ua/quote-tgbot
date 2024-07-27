package ua.mibal.bot.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.application.component.message.MessageNotifier;
import ua.mibal.bot.application.component.photo.PhotoNotifier;
import ua.mibal.bot.application.exception.TelegramAnswerException;
import ua.mibal.bot.application.repository.SubscriberRepository;
import ua.mibal.bot.domain.Subscriber;
import ua.mibal.bot.model.ChatDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class QuoteService {
    private static final Map<Integer, List<String>> CHAT_USER_THEMES = new HashMap<>();
    private final SubscriberRepository subscriberRepository;
    private final MessageNotifier messageNotifier;
    private final PhotoNotifier photoNotifier;

    public void send() {
        for (Subscriber subscriber : subscriberRepository.findAll()) {
            messageNotifier.notifyQuoteFor(subscriber);
            photoNotifier.notifyQuotePhotoFor(subscriber);
        }
    }

    public void addSubscriber(ChatDto chat) {
        validateChatNotAddedYet(chat);

        Subscriber subscriber = new Subscriber();
        subscriber.setChatId(chat.id());
        subscriber.setUsername(chat.username());
        subscriber.setThemes(getThemesFor(chat.id()));
        subscriberRepository.save(subscriber);
    }

    public void addThemes(ChatDto chat, String themes) {
        CHAT_USER_THEMES.put(
                chat.id(),
                stream(themes.split(","))
                        .map(String::trim)
                        .peek(theme -> System.out.println("theme = " + theme))
                        .toList()
        );
    }

    public void removeSubscriber(ChatDto chat) {
        subscriberRepository.deleteOneByChatId(chat.id());
    }

    public boolean subscriberExistsFor(ChatDto chat) {
        return subscriberRepository.existsByChatId(chat.id());
    }

    private List<String> getThemesFor(Integer chatId) {
        List<String> themes = CHAT_USER_THEMES.get(chatId);
        if (themes == null) {
            throw new TelegramAnswerException(chatId, "You have to add at least one theme");
        }
        return themes;
    }


    private void validateChatNotAddedYet(ChatDto chat) {
        if (subscriberRepository.existsByChatId(chat.id())) {
            throw new TelegramAnswerException(chat.id(), "You already subscribed");
        }
    }
}
