package br.com.rayan.magalu_ms.repository;

import br.com.rayan.magalu_ms.entities.Channel;
import br.com.rayan.magalu_ms.entities.Notification;
import br.com.rayan.magalu_ms.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
     List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
