package ua.mibal.bot.service.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.Photo;

import java.util.Map;

import static ua.mibal.bot.model.Method.SEND_ANIMATION;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class PhotoSender {
    private final TelegramMethodPerformer performer;

    public void send(Photo photo) {
        log.info("Sending photo: {}", photo);

        performer.perform(SEND_ANIMATION, Map.of(
                "chat_id", photo.chatId(),
                "animation", photo.url()
        ));
    }
}
