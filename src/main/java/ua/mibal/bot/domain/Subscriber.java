package ua.mibal.bot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static java.lang.String.join;
import static java.util.Arrays.stream;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Getter
@Setter
@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "chat_id", nullable = false, unique = true)
    private Integer chatId;

    @Column(name = "themes")
    private String themes;

    public List<String> getThemes() {
        return stream(themes.split(",")).toList();
    }

    public void setThemes(List<String> themes) {
        this.themes = join(",", themes);
    }
}
