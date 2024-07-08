package br.com.rayan.magalu_ms.service;

import br.com.rayan.magalu_ms.dto.ScheduleNotificationDTO;
import br.com.rayan.magalu_ms.entities.Notification;
import br.com.rayan.magalu_ms.entities.Status;
import br.com.rayan.magalu_ms.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@AllArgsConstructor
@Service
public class NotificationService {

     private final NotificationRepository notificationRepository;

     public void scheduleNotification(ScheduleNotificationDTO dto) {
          notificationRepository.save(dto.toNotification());
     }

     public Optional<Notification> findById(Long notificationId) {
          return notificationRepository.findById(notificationId);
     }

     public void cancelNotification(Long notificationId) {
          var notificationFromDb = findById(notificationId);
          if (notificationFromDb.isPresent()) {
               notificationFromDb.get().setStatus(Status.Values.CANCELED.toStatus());
               notificationRepository.save(notificationFromDb.get());
          }
     }

     public void checkAndSend(LocalDateTime dateTime) {
          var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
               Status.Values.PENDING.toStatus(),
               Status.Values.ERROR.toStatus()
          ), dateTime);

          notifications.forEach(sendNotification());
     }

     private Consumer<Notification> sendNotification() {
          return notification -> {
               // TODO - SEND NOTIFICATION
               notification.setStatus(Status.Values.SUCCESS.toStatus());
               notificationRepository.save(notification);
          };
     }
}
