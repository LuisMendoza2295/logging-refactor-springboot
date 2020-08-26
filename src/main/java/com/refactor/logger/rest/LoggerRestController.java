package com.refactor.logger.rest;

import com.refactor.logger.api.LoggerManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class LoggerRestController {

    private final LoggerManager loggerManager;

    public LoggerRestController(LoggerManager loggerManager) {
        this.loggerManager = loggerManager;
    }

    @GetMapping
    public void log() {
        this.loggerManager.log("test");
    }
}
