package geovani.training.traininggs.service;

import geovani.training.traininggs.dto.NotificationDto;
import geovani.training.traininggs.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    public void createNotification(NotificationDto notificationDto) {
    notificationRepository.save(notificationDto.toEntity());
    }

}
