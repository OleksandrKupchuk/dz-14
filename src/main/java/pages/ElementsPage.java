package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage {
    private WebDriver driver;
    private String elementInList = "//*[contains(@class, 'text') and text() = '%s']";

    public ElementsPage() {
        this.driver = BaseTest.getWebDriver();
    }

    public ElementsPage clickElementInList(String nameElement){
        driver.findElement(By.xpath(String.format(elementInList, nameElement))).click();
        return this;
    }
}