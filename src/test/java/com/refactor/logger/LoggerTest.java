package com.refactor.logger;

import com.refactor.logger.api.LoggerManager;
import com.refactor.logger.infrastructure.ConsoleLogger;
import com.refactor.logger.manager.LoggerManagerImpl;
import com.refactor.logger.model.LoggerLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class LoggerTest {

    @Test
    public void noCustomLoggerLevel() {
        String message = "test-message!!";
        LoggerManager loggerManager = new LoggerManagerImpl(Collections.singletonList(new ConsoleLogger()));
        String log = loggerManager.log(message);
        Assertions.assertEquals(log, LoggerLevel.MESSAGE.parseMessage(message));
    }

    @Test
    public void withCustomLoggerLevel() {
        String message = "test-message!!";
        LoggerManager loggerManager = new LoggerManagerImpl(Collections.singletonList(new ConsoleLogger()));
        String log = loggerManager.log(message, LoggerLevel.ERROR);
        Assertions.assertEquals(log, LoggerLevel.ERROR.parseMessage(message));
    }

    @Test
    public void emptyMessage() {
        LoggerManager loggerManager = new LoggerManagerImpl(Collections.singletonList(new ConsoleLogger()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> loggerManager.log(""));
    }

    @Test
    public void noLoggersProvided() {
        String message = "test-message!!";
        LoggerManager loggerManager = new LoggerManagerImpl(new ArrayList<>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> loggerManager.log(message));
    }
}
