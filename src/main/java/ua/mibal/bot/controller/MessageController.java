package ua.mibal.bot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.bot.application.BotService;
import ua.mibal.bot.model.UpdateDto;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageController {
    private final BotService botService;

    @RequestMapping(method = {GET, POST})
    public void processUpdate(@RequestBody UpdateDto updateDto) {
        log.info("Received update: {}", updateDto);
        botService.processUpdate(updateDto);
    }
}
