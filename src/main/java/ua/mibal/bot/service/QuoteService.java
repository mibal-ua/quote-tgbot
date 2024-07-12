package ua.mibal.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.service.component.MessageBuilder;
import ua.mibal.bot.service.component.MessageSender;

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
    private final MessageBuilder builder;
    private final MessageSender sender;

    public void send() {
        for (ChatDto chat : CHATS) {
            Message message = builder.buildQuoteFor(chat);
            sender.send(message);
        }
    }

    public void addRecipient(ChatDto chat) {
        CHATS.add(chat);
    }
}
