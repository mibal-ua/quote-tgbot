package ua.mibal.bot.model;

import java.util.Date;
import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record MessageDto(
        Integer message_id,
        UserDto from,
        ChatDto chat,
        Date date,
        String text,
        List<EntityDto> entities
) {
}
