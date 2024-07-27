package ua.mibal.bot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mibal.bot.domain.Subscriber;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    boolean existsByChatId(Integer id);
}
