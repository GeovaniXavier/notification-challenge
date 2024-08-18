package geovani.training.traininggs.service;

import geovani.training.traininggs.dto.NotificationDto;
import geovani.training.traininggs.entity.Notification;
import geovani.training.traininggs.entity.Status;
import geovani.training.traininggs.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Optional<Notification> getNotification(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void createNotification(NotificationDto notificationDto) {
        notificationRepository.save(notificationDto.toEntity());
    }

    public void deleteNotification(Long notificationId) {
        var notification = getNotification(notificationId);
        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.FAILED.getStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSendNotification(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.getStatus(),
                Status.Values.ERROR.getStatus()
        ), dateTime);
        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            notification.setStatus(Status.Values.SUCESS.getStatus());
            notificationRepository.save(notification);
        };
    }
}
