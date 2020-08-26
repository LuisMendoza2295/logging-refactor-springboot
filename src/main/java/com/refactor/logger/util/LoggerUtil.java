package com.refactor.logger.util;

import java.util.logging.Handler;
import java.util.logging.Logger;

public class LoggerUtil {

    private LoggerUtil() {
    }

    /**
     *
     * @param logger from which handlers will be removed
     */
    public static void removeHandlers(Logger logger) {
        logger.setUseParentHandlers(false);
        for(Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }
    }
}
