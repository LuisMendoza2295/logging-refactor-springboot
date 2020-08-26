package com.refactor.logger.infrastructure;

import com.refactor.logger.api.Loggable;
import com.refactor.logger.model.LoggerLevel;
import com.refactor.logger.util.LoggerUtil;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
public class ConsoleLogger implements Loggable {

    private static final Logger LOGGER = Logger.getLogger(ConsoleLogger.class.getName());

    /**
     *
     * @param message to be logged
     * @param loggerLevel indicates the message logging level
     * @return the logged message
     */
    @Override
    public String log(String message, LoggerLevel loggerLevel) {
        // Supposed to be only one handler at a time
        LoggerUtil.removeHandlers(LOGGER);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(handler);

        LOGGER.log(loggerLevel.getLevel(), message);

        return message;
    }
}
