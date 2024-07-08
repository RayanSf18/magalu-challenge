package br.com.rayan.magalu_ms.controller;

import br.com.rayan.magalu_ms.dto.ScheduleNotificationDTO;
import br.com.rayan.magalu_ms.entities.Notification;
import br.com.rayan.magalu_ms.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

     private final NotificationService notificationService;

     @PostMapping
     public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto) {
          notificationService.scheduleNotification(dto);
          return ResponseEntity.accepted().build();
     }

     @GetMapping(value = "/{notificationId}")
     public ResponseEntity<Notification> getNotification(@PathVariable(value = "notificationId") Long notificationId) {
          var notification = notificationService.findById(notificationId);
          if (notification.isEmpty()) {
               return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok().body(notification.get());
     }

     @DeleteMapping(value = "/{notificationId}")
     public ResponseEntity<Void> cancelNotification(@PathVariable(value = "notificationId") Long notificationId) {
          notificationService.cancelNotification(notificationId);
          return ResponseEntity.noContent().build();
     }
}
