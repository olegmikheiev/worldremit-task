package com.worldremit.testtask.utils;

import com.worldremit.testtask.config.Config;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Slf4j
public class WebDriverUtils {
    public static void navigateTo(String url) {
        final String fullUrl = Config.getBaseUrl() + url;
        log.info("Navigating to '{}'", fullUrl);
        getCurrentDriver().get(fullUrl);
    }

    public static WebElementFacade scrollIntoView(WebElementFacade element) {
        getJSX().executeScript("arguments[0].scrollIntoView(arguments[1])", element, true);
        return element;
    }

    public static WebElementFacade click(WebElementFacade element) {
        scrollIntoView(element).click();
        return element;
    }

    private static WebDriver getCurrentDriver() {
        return Serenity.getWebdriverManager().getCurrentDriver();
    }

    private static JavascriptExecutor getJSX() {
        return (JavascriptExecutor) getCurrentDriver();
    }

    private WebDriverUtils() {
        // You do not need to instantiate this class
    }
}
