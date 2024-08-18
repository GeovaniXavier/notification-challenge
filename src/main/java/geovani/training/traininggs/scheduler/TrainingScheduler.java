package geovani.training.traininggs.scheduler;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class TrainingScheduler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TrainingScheduler.class);

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void scheduleTask() {
        var dateTime = LocalDateTime.now();
        logger.info("Scheduled task executed at {}", dateTime);
    }
}
