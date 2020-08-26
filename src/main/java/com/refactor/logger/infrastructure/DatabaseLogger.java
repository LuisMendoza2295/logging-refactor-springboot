package com.refactor.logger.infrastructure;

import com.refactor.logger.api.Loggable;
import com.refactor.logger.model.LoggerLevel;
import com.refactor.logger.persistence.entities.LoggerEntity;
import com.refactor.logger.persistence.jpa.LoggerRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class DatabaseLogger implements Loggable {

    private final LoggerRepositoryJpa loggerRepositoryJpa;

    public DatabaseLogger(LoggerRepositoryJpa loggerRepositoryJpa) {
        this.loggerRepositoryJpa = loggerRepositoryJpa;
    }

    @Override
    public String log(String message, LoggerLevel loggerLevel) {
        LoggerEntity loggerEntity = new LoggerEntity();
        loggerEntity.setMessage(message);
        loggerEntity.setLevel(loggerLevel.name());
        loggerEntity.setCreated(new Date());

        LoggerEntity savedLoggerEntity = this.loggerRepositoryJpa.save(loggerEntity);

        return savedLoggerEntity.getMessage();
    }
}
