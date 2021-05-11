package com.spring.workshop.test.steps;

import com.spring.workshop.test.driver.DriverService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.spring.workshop.test.pageObjects.DemoPageObject;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoSteps {

    public static final WebDriver webDriver = DriverService.WEB_DRIVER_INSTANCE;

    //private final DemoPageObject demoPageObject = new DemoPageObject(webDriver);

    @Autowired DemoPageObject demoPageObject;

    @Given("I navigate to Selenium Easy web page")
    public void openWebPage() {
        webDriver.get("https://www.seleniumeasy.com/test/");
    }

    @When("I open the 'Input Forms' dropdown")
    public void openInputFormsDropdown() {
        demoPageObject.openInputFormsDropdown();
    }

    @When("I select a Simple Form Demo")
    public void selectSimpleFormDemo() {
        demoPageObject.selectSimpleFormDemo();
    }

    @Then("the simple form is displayed")
    public void verifySimpleFormDemoDisplayed() {
        Assert.assertTrue("Simple Demo form is not displayed", demoPageObject.isSimpleFormDemoDisplayed());
    }

    @When("I input a text in the Simple Input Field")
    public void inputTextInSimpleInputField() {
        demoPageObject.insertMessageInSingleInputField();
    }

    @When("I click 'Show Message' button")
    public void clickShowMessage() {
        demoPageObject.clickShowMessageButton();
    }

    @Then("my text is displayed")
    public void verifyInsertedTextIsDisplayed() {
        Assert.assertTrue("The displayed text doesn't match your initial text", demoPageObject.retrieveInsertedText());
    }
}