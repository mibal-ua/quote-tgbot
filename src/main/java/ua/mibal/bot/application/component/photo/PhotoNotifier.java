package ua.mibal.bot.application.component.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.Photo;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class PhotoNotifier {
    private final PhotoBuilder photoBuilder;
    private final PhotoSender photoSender;

    public void notifyQuotePhotoFor(Integer chatId) {
        Photo photo = photoBuilder.buildQuotePhotoFor(chatId);
        photoSender.send(photo);
    }
}
