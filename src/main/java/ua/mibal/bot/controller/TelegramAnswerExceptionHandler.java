package ua.mibal.bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.mibal.bot.application.component.TelegramMethodPerformer;
import ua.mibal.bot.application.exception.TelegramAnswerException;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@ControllerAdvice
public class TelegramAnswerExceptionHandler {
    private final TelegramMethodPerformer telegramMethodPerformer;

    @ExceptionHandler(TelegramAnswerException.class)
    public void handleException(TelegramAnswerException e) {
        telegramMethodPerformer.perform(e.getMethod(), e.getParams());
    }
}
