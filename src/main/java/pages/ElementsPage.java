package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage {
    private WebDriver driver;
    public ElementsPage() {
        this.driver = BaseTest.getWebDriver();
    }

    private String elementInList = "//*[contains(@class, 'text') and text() = '%s']";

    public ElementsPage clickElementInList(String nameElement){
        driver.findElement(By.xpath(String.format(elementInList, nameElement))).click();
        return this;
    }
}