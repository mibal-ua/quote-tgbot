package ua.mibal.bot.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record UserDto(
        Integer id,
        Boolean is_bot,
        String first_name,
        String last_name,
        String username,
        String language_code
) {
}
