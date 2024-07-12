package ua.mibal.bot.service.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.Photo;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Component
public class PhotoBuilder {
    private final PhotoUrlProvider photoUrlProvider;
    
    public Photo buildQuotePhotoFor(ChatDto chat) {
        return new Photo(
                chat.id(),
                photoUrlProvider.getUrl()
        );
    }
}
