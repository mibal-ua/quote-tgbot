package ua.mibal.bot.application.exception;

import lombok.Getter;
import ua.mibal.bot.model.Method;

import java.util.Map;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public class TelegramAnswerException extends RuntimeException {
    @Getter
    private final Method method = Method.SEND_MESSAGE;
    private final Integer chatId;

    public TelegramAnswerException(Integer chatId, String message) {
        super(message);
        this.chatId = chatId;
    }

    public Map<String, Object> getParams() {
        return Map.of(
                "chat_id", chatId,
                "text", getMessage()
        );
    }
}
