package ua.mibal.bot.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.application.component.message.MessageNotifier;
import ua.mibal.bot.application.component.photo.PhotoNotifier;
import ua.mibal.bot.model.ChatDto;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class QuoteService {
    // TODO move to repo
    private static final Set<ChatDto> CHATS = new HashSet<>();

    private final MessageNotifier messageNotifier;
    private final PhotoNotifier photoNotifier;

    public void send() {
        for (ChatDto chat : CHATS) {
            messageNotifier.notifyQuoteFor(chat);
            photoNotifier.notifyQuotePhotoFor(chat);
        }
    }

    public void addRecipient(ChatDto chat) {
        CHATS.add(chat);
    }
}
