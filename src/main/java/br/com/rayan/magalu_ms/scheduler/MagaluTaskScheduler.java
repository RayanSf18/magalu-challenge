package br.com.rayan.magalu_ms.scheduler;

import br.com.rayan.magalu_ms.service.NotificationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Component
public class MagaluTaskScheduler {

     private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);
     private final NotificationService notificationService;

     @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
     public void checkTasks() {
          var dateTime = LocalDateTime.now();
          logger.info("Running at {}", dateTime);
          notificationService.checkAndSend(dateTime);
     }
}
