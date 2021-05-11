package com.spring.workshop.test.driver;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {SpringComponentsScanner.class})
public class SpringConfiguration {

}
