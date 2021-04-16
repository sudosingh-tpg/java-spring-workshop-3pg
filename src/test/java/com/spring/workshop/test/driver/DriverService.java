package com.spring.workshop.test.driver;

import org.openqa.selenium.WebDriver;

public class DriverService {

    public static WebDriver WEB_DRIVER_INSTANCE;

    private static DriverService INSTANCE;


    /**
     * Create a new instance of this class if no instance was previously created
     *
     * @return - the instance of this class
     */
    public static DriverService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DriverService();
        }
        return INSTANCE;
    }


    /**
     * Setup method that creates the web driver according to browser type and assigns
     * this newly created instance to WEB_DRIVER_INSTANCE
     */
    public static void setup() {
        if (WEB_DRIVER_INSTANCE == null) {
            DriverFactory.createWebDriver(Environment.BROWSER);
            WEB_DRIVER_INSTANCE = DriverFactory.getINSTANCE().getDriver();
        }
    }


    /**
     * Performs the scenario tear down
     */
    public void tearDown() {
        if (WEB_DRIVER_INSTANCE != null) {
            WEB_DRIVER_INSTANCE.quit();
        }
    }
}