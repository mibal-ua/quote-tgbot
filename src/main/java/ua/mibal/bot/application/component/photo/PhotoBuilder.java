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
public class PhotoBuilder {
    private final PhotoUrlProvider photoUrlProvider;

    public Photo buildQuotePhotoFor(Integer chatId) {
        return new Photo(
                chatId,
                photoUrlProvider.getUrl()
        );
    }
}
