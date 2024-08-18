package geovani.training.traininggs.scheduler;

import geovani.training.traininggs.service.NotificationService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class TrainingScheduler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TrainingScheduler.class);

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTask() {
        var dateTime = LocalDateTime.now();
        logger.info("Scheduled task executed at {}", dateTime);
        notificationService.checkAndSendNotification(dateTime);
    }
}
