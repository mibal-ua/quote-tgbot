package ua.mibal.bot.application.component.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.domain.Subscriber;
import ua.mibal.bot.model.Photo;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class PhotoNotifier {
    private final RandomGifSelector randomGifSelector;
    private final PhotoSender photoSender;

    public void notifyQuotePhotoFor(Subscriber subscriber) {
        Photo photo = new Photo(
                subscriber.getChatId(),
                randomGifSelector.getGifUrlFor(subscriber)
        );
        photoSender.send(photo);
    }
}
