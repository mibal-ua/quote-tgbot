package ua.mibal.bot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RestController
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @RequestMapping(method = {GET, POST})
    public void receiveMessage(@RequestBody Object message) {
        log.info("Received message: {}", message);
    }
}
