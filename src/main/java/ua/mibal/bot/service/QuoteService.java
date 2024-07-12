package ua.mibal.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.Photo;
import ua.mibal.bot.service.component.MessageBuilder;
import ua.mibal.bot.service.component.MessageSender;
import ua.mibal.bot.service.component.PhotoBuilder;
import ua.mibal.bot.service.component.PhotoSender;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class QuoteService {
    private static final Set<ChatDto> CHATS = new HashSet<>();
    private final MessageBuilder messageBuilder;
    private final MessageSender messageSender;
    private final PhotoBuilder photoBuilder;
    private final PhotoSender photoSender;

    public void send() {
        for (ChatDto chat : CHATS) {
            Message message = messageBuilder.buildQuoteFor(chat);
            messageSender.send(message);
            Photo photo = photoBuilder.buildQuotePhotoFor(chat);
            photoSender.send(photo);
        }
    }

    public void addRecipient(ChatDto chat) {
        CHATS.add(chat);
    }
}
