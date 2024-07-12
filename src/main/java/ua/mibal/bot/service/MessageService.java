package ua.mibal.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mibal.bot.model.Message;
import ua.mibal.bot.model.UpdateDto;
import ua.mibal.bot.service.component.MessageBuilder;
import ua.mibal.bot.service.component.MessageSender;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageSender sender;
    private final MessageBuilder builder;

    public void processUpdate(UpdateDto updateDto) {
        if ("/start".equals(updateDto.message().text())) {
            Message message = builder.buildHelloMessageFor(updateDto.message());
            sender.send(message);
        }
        // TODO
    }
}
