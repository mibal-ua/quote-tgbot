package ua.mibal.bot.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record ChatDto(
        Integer id,
        String first_name,
        String last_name,
        String username,
        String type
) {
}
