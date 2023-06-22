package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ButtonsPage {
    private WebDriver driver;
    public ButtonsPage() {
        this.driver = BaseTest.getWebDriver();
    }

    private String button = "//*[contains(@class, 'btn btn-primary') and text() = '%s']";
    private By messageClickMe = By.id("dynamicClickMessage");

    public ButtonsPage clickOnButton(String nameButton){
        driver.findElement(By.xpath(String.format(button, nameButton))).click();
        return this;
    }

    public ButtonsPage assertMessageClickMe(String expectedMessage){
        String actualMessage = driver.findElement(messageClickMe).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        return this;
    }
}