package com.refactor.logger.persistence.jpa;

import com.refactor.logger.persistence.entities.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepositoryJpa extends JpaRepository<LoggerEntity, Long> {
}
