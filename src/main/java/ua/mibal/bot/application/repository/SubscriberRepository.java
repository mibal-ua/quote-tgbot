package ua.mibal.bot.application.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.mibal.bot.domain.Subscriber;

import java.util.Optional;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    boolean existsByChatId(Integer chatId);

    Optional<Subscriber> findOneByChatId(Integer chatId);

    @Transactional
    void deleteOneByChatId(Integer chatId);
}
