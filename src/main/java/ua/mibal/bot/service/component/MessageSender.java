package ua.mibal.bot.service.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.mibal.bot.model.Message;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class MessageSender {
    private final TelegramLongPollingBot bot;
 
    public void send(Message message) {
        log.info("Sending message: {}", message);

        SendMessage sm = SendMessage.builder()
                .chatId(message.chatId().toString())
                .text(message.text())
                .build();
        try {
            bot.execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        // TODO
    }
}
