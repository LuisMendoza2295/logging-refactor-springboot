package com.refactor.logger.api;

import com.refactor.logger.model.LoggerLevel;

public interface LoggerManager {

    /**
     *
     * @param message the message to be logged
     * @return the logged message
     */
    String log(String message);

    /**
     *
     * @param message the message to be logged
     * @param loggerLevel overrides default logging level for current logging
     * @return the logged message
     */
    String log(String message, LoggerLevel loggerLevel);
}
