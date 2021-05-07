package com.spring.workshop.test.utils;

import com.spring.workshop.test.driver.DriverService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WaitHelper {

    INSTANCE;

    public final WebDriver webDriver = DriverService.WEB_DRIVER_INSTANCE;
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    /**
     * Waiting for page to load
     */
    public void waitForPageLoaded() {
        wait.until(wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}