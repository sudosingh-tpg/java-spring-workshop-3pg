package com.spring.workshop.test.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static DriverFactory INSTANCE;

    /**
     * Create a new instance of this class if no instance was previously created
     *
     * @return - the instance of this class
     */
    public static DriverFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DriverFactory();
        }
        return INSTANCE;
    }


    /**
     * Method that sets up a driver based on an expected browser
     *
     * @param browser - expected browser
     */
    public static void createWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
            default:
                throw new IllegalArgumentException("No such browser defined: " + browser);
        }
    }


    /**
     * Retrieves the driver based on browser
     *
     * @param browser - expected browser
     * @return - the expected driver
     */
    private static WebDriver getDriver(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME:
                driver = getChromeDriver();
                break;
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("No such browser defined: " + browser);
        }
        return driver;
    }


    /**
     * Returns a driver based on the value of Environment.BROWSER
     *
     * @return - returns the actual driver instance
     */
    public WebDriver getDriver() {
        return getDriver(Environment.BROWSER);
    }


    /**
     * Retrieves a new Chrome driver with several preset options
     *
     * @return - a new instance of chromedriver
     */
    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }


    /**
     * Retrieves a new Firefox driver
     *
     * @return - a new instance of Firefox driver
     */
    private static WebDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }
}