package geovani.training.traininggs.service;

import geovani.training.traininggs.dto.NotificationDto;
import geovani.training.traininggs.entity.Notification;
import geovani.training.traininggs.entity.Status;
import geovani.training.traininggs.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

}
