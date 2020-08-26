package com.refactor.logger.infrastructure;

import com.refactor.logger.api.Loggable;
import com.refactor.logger.model.LoggerLevel;
import com.refactor.logger.util.FileUtil;
import com.refactor.logger.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
public class FileLogger implements Loggable {

    private static final Logger LOGGER = Logger.getLogger(FileLogger.class.getName());
    private final Path destinationPath;

    public FileLogger(@Value(value = "${logger.file.path}") String pathString) {
        this.destinationPath = Paths.get(pathString);
    }

    @Override
    public String log(String message, LoggerLevel loggerLevel) {
        if (!FileUtil.createPathIfNotExists(destinationPath)) {
            System.out.println("Log file does not exists or could not be created");
        }

        // Supposed to be only one handler at a time
        LoggerUtil.removeHandlers(LOGGER);

        try {
            FileHandler handler = new FileHandler(destinationPath.toAbsolutePath().toString(), true);
            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);

            LOGGER.log(loggerLevel.getLevel(), message);

            handler.close();
        } catch (IOException e) {
            System.out.println("Could not log into file (missed file maybe?)");
        }

        return message;
    }
}
