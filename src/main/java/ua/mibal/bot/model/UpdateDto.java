package ua.mibal.bot.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record UpdateDto(
        Integer update_id,
        MessageDto message
) {
}
