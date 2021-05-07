package com.spring.workshop.test.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "com.spring.workshop.test",
        tags = "@Demo")
public class CucumberMainRunner {
}