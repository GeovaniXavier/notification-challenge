package geovani.training.traininggs.repository;

import geovani.training.traininggs.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
