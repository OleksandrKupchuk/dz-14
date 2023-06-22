package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(By element, int durationInSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds)).until(ExpectedConditions.presenceOfElementLocated(element));
    }
}