package ua.mibal.bot.application.component.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.mibal.bot.application.component.TelegramMethodPerformer;
import ua.mibal.bot.model.Message;

import java.util.Map;

import static ua.mibal.bot.model.Method.SEND_MESSAGE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class MessageSender {
    private final TelegramMethodPerformer performer;

    public void send(Message message) {
        log.info("Sending message: {}", message);

        performer.perform(SEND_MESSAGE, Map.of(
                "chat_id", message.chatId(),
                "text", message.text()
        ));
    }
}
