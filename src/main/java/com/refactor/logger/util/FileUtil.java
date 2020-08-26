package com.refactor.logger.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    private FileUtil() {
    }

    /**
     *
     * @param destinationPath the absolute path to the file
     * @return {@code true} if path got created or already exists, otherwise {@code false}
     */
    public static boolean createPathIfNotExists(Path destinationPath) {
        if (destinationPath.toFile().exists()) return true;

        try {
            Files.createDirectories(destinationPath.getParent());
            Files.createFile(destinationPath);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
