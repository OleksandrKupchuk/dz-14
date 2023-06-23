package pages;

import base.BaseTest;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolQaMainPage {
    private WebDriver driver;
    private String card = "//*[@class='card-body']//h5[contains(text(),'%s')]";

    public ToolQaMainPage() {
        this.driver = BaseTest.getWebDriver();
    }

    public ToolQaMainPage open(){
        driver.get(Config.getProperty(Config.TOOL_QA_URL));
        return this;
    }

    public ToolQaMainPage clickOnCard(String nameCard){
        driver.findElement(By.xpath(String.format(card, nameCard))).click();
        return this;
    }
}