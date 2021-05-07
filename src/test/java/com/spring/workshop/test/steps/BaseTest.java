package com.spring.workshop.test.steps;

import com.spring.workshop.test.driver.DriverService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {

    @Before
    public void setup() {
        DriverService.setup();
    }


    @After
    public void tearDown() {
        DriverService.getINSTANCE().tearDown();
    }
}
