package br.com.rayan.magalu_ms.dto;

import br.com.rayan.magalu_ms.entities.Channel;
import br.com.rayan.magalu_ms.entities.Notification;
import br.com.rayan.magalu_ms.entities.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(LocalDateTime dateTime, String destination, String message, Channel.Values channel) {

 public Notification toNotification() {
  return new Notification(null, dateTime, destination, message, channel.toChannel(), Status.Values.PENDING.toStatus());
 }
}
