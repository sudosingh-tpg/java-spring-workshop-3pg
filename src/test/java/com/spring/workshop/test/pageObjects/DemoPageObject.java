package com.spring.workshop.test.pageObjects;

import com.spring.workshop.test.driver.DriverService;
import com.spring.workshop.test.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoPageObject {

    WebDriver driver;
    WebDriverWait wait;

    public static final String TEXT_INPUT_FORM = "This is a test message";

    @FindBy(className = "at4win")
    private WebElement popup;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[@class='dropdown']/a[@class='dropdown-toggle']")
    private WebElement inputFormsDropdown;

    @FindBy(xpath = "//li[@class='dropdown open']/ul[@class='dropdown-menu']/li/a[text()='Simple Form Demo']")
    private WebElement simpleFormDemoOption;

    @FindBy(xpath = "//input[@id='user-message']")
    private WebElement inputField;

    @FindBy(xpath = "//button[text()='Show Message']")
    private WebElement showMessageButton;

    @FindBy(xpath = "//span[@id='display']")
    private WebElement displayedTextSingleInputField;

    private final By singleInputFormHeader = By.xpath("//div[text()='Single Input Field']");

    public DemoPageObject() {
        if (DriverService.WEB_DRIVER_INSTANCE == null) {
            DriverService.setup();
        }
        this.driver = DriverService.WEB_DRIVER_INSTANCE;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public DemoPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Open 'Input Forms' dropdown
     */
    public void openInputFormsDropdown() {
        wait.until(ExpectedConditions.visibilityOf(popup));
        driver.findElement(By.id("at-cv-lightbox-close")).click();
        inputFormsDropdown.click();
    }


    /**
     * Select the 'Simple Form Demo' form
     */
    public void selectSimpleFormDemo() {
        WaitHelper.INSTANCE.waitForPageLoaded();
        simpleFormDemoOption.click();
    }


    /**
     * Verify if Simple Form Demo page is displayed
     */
    public boolean isSimpleFormDemoDisplayed() {
        WaitHelper.INSTANCE.waitForPageLoaded();
        return driver.findElement(singleInputFormHeader).isDisplayed();
    }


    /**
     * Insert message in single input field
     */
    public void insertMessageInSingleInputField() {
        inputField.sendKeys(TEXT_INPUT_FORM);
    }


    /**
     * Click 'Show Message' button
     */
    public void clickShowMessageButton() {
        showMessageButton.click();
    }


    /**
     * Retrieve displayed text after clicking Show Message button
     */
    public boolean retrieveInsertedText() {
        String actualText = displayedTextSingleInputField.getText();
        return actualText.equals(TEXT_INPUT_FORM);
    }
}