package com.refactor.logger.scheduled;

import com.refactor.logger.api.LoggerManager;
import com.refactor.logger.model.LoggerLevel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogCreator {

    private final LoggerManager loggerManager;

    public LogCreator(LoggerManager loggerManager) {
        this.loggerManager = loggerManager;
    }

    @Scheduled(fixedDelay = 5000)
    public void createLogs() {
        this.loggerManager.log("message-test!!", LoggerLevel.ERROR);
    }
}
