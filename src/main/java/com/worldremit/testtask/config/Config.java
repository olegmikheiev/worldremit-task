package com.worldremit.testtask.config;

import java.time.Duration;

public class Config {
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(10);

    public static String getBaseUrl() {
        // TODO: Read from properties file
        return "https://www.worldremit.com/en";
    }
}
