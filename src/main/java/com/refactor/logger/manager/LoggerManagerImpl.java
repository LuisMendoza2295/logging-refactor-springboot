package com.refactor.logger.manager;

import com.refactor.logger.api.Loggable;
import com.refactor.logger.api.LoggerManager;
import com.refactor.logger.model.LoggerLevel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoggerManagerImpl implements LoggerManager {

    private final List<Loggable> availableLoggers;

    public LoggerManagerImpl(List<Loggable> availableLoggers) {
        this.availableLoggers = availableLoggers;
    }

    @Override
    public String log(String message) {
        return this.log(message, LoggerLevel.MESSAGE);
    }

    @Override
    public String log(String message, LoggerLevel loggerLevel) {
        if (this.availableLoggers.isEmpty()) throw new IllegalArgumentException("No loggers provided");
        if (StringUtils.isBlank(message)) throw new IllegalArgumentException("No message provided");
        if (loggerLevel == null) throw new IllegalArgumentException("No logger level provided");

        String parsedMessage = loggerLevel.parseMessage(message);

        this.availableLoggers
                .forEach(logger -> logger.log(message, loggerLevel));

        return parsedMessage;
    }
}
