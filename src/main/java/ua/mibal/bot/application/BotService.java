package ua.mibal.bot.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.application.component.message.MessageNotifier;
import ua.mibal.bot.model.ChatDto;
import ua.mibal.bot.model.UpdateDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class BotService {
    private static final List<Integer> RECEIVING_THEMES_MODE_ENABLED = new ArrayList<>();
    
    private final MessageNotifier messageNotifier;
    private final QuoteService quoteService;

    public void processUpdate(UpdateDto update) {
        String input = update.message().text();
        if ("/start".equals(input)) {
            messageNotifier.notifyHelloFor(update);
        } else if ("/subscribe".equals(input)) {
            if (userIsSubscribed(update)) {
                messageNotifier.notifyAlreadySubscribedFor(update);
            } else {
                enableReceivingThemesModeFor(update.message().chat());
                messageNotifier.notifyAddThemeModeEnabledFor(update);   
            }
        } else if (enabledReceivingThemesModeFor(update.message().chat())) {
            quoteService.addThemes(update.message().chat(), input);
            quoteService.addSubscriber(update.message().chat());
            disableReceivingThemesModeFor(update.message().chat());
            messageNotifier.notifySubscribedFor(update);
        } else if ("/my_settings".equals(input)) {
            messageNotifier.notifyMySettingsFor(update);
        } else if ("/unsubscribe".equals(input)) {
            quoteService.removeSubscriber(update.message().chat());
            messageNotifier.notifyUnsubscribedFor(update);
        } else if ("/control".equals(input)) {
            messageNotifier.notifyControlFor(update);
        } else {
            messageNotifier.notifyUnknownCommandFor(update);
        }
    }

    private boolean userIsSubscribed(UpdateDto update) {
        return quoteService.subscriberExistsFor(update.message().chat());
    }

    private boolean enabledReceivingThemesModeFor(ChatDto chat) {
        return RECEIVING_THEMES_MODE_ENABLED.contains(chat.id());
    }

    private void enableReceivingThemesModeFor(ChatDto chat) {
        RECEIVING_THEMES_MODE_ENABLED.add(chat.id());
    }

    private void disableReceivingThemesModeFor(ChatDto chat) {
        RECEIVING_THEMES_MODE_ENABLED.remove(chat.id());
    }
}
