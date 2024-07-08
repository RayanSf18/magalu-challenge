package br.com.rayan.magalu_ms.repository;

import br.com.rayan.magalu_ms.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
