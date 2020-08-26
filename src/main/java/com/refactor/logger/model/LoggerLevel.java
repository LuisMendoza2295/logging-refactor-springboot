package com.refactor.logger.model;

import java.util.logging.Level;

public enum LoggerLevel {

    MESSAGE(Level.INFO), WARNING(Level.WARNING), ERROR(Level.SEVERE);

    private final Level level;

    LoggerLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    /**
     *
     * @param message to be logged
     * @return a representation of {@code LoggingLevel} with the logging time
     */
    // Check if this method is needed (Level fields are already self-explanatory) in case of Console or File logging
    // In case of database, check if is more suitable place this method in the DatabaseLogger infrastructure class
    public String parseMessage(String message) {
        return this.name()
                + ": " + message;
    }
}
