package ua.mibal.bot.application.component.photo;

import ua.mibal.bot.model.Gif;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface GifRepository {

    List<Gif> findAllByTheme(String theme);
}
