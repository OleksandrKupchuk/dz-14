package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import user.User;

import java.util.List;

public class WebTablesPage {
    private WebDriver driver;
    private RegistrationForm<WebTablesPage> registrationForm;
    private By addButton = By.id("addNewRecordButton");
    private By registeredUser = By.className("rt-tr-group");
    private By userData = By.className("//div[@class='rt-tr-group']//*[contains(@class, 'rt-td') and text() = 'Cierra']");
    private String editButton = "edit-record-%s";
    public RegistrationForm<WebTablesPage> getRegistrationForm(){ return registrationForm; }

    public WebTablesPage() {
        this.driver = BaseTest.getWebDriver();
        registrationForm = new RegistrationForm<>(driver, this);
    }

    public WebTablesPage clickOnAddButton(){
        driver.findElement(addButton).click();
        return this;
    }

    public WebTablesPage assertUserIsExistInTable(User user){
        boolean result = checkRegisteredUser(user);
        Assert.assertTrue(result);
        return this;
    }

    private boolean checkRegisteredUser(User user) {
        List<WebElement> users = driver.findElements(registeredUser);
        for (int i = 0; i < users.size(); i++) {
            if (isExistUser(users.get(i), user)) {
                return true;
            }
        }

        return false;
    }

    public WebTablesPage clickOnEditButton(User user) {
        List<WebElement> users = driver.findElements(registeredUser);
        for (int i = 0; i < users.size(); i++) {
            if (isExistUser(users.get(i), user)) {
                driver.findElement(By.id(String.format(editButton, i + 1))).click();
            }
        }

        return this;
    }

    private boolean isExistUser(WebElement element, User user) {
        List<WebElement> userData = element.findElements(this.userData);

        String firstName = userData.get(0).getText();
        if(firstName.isEmpty() || firstName.isBlank()){
            return false;
        }

        if (!firstName.equals(user.getFirstName())) {
            return false;
        }

        String lastName = userData.get(1).getText();
        if (!lastName.equals(user.getLastName())) {
            return false;
        }

        String age = userData.get(2).getText();
        if (!age.equals((Integer.toString(user.getAge())))) {
            return false;
        }

        String email = userData.get(3).getText();
        if (!email.equals(user.getEmail())) {
            return false;
        }

        String salary = userData.get(4).getText();
        if (!salary.equals(Integer.toString(user.getSalary()))) {
            return false;
        }

        String department = userData.get(5).getText();
        if (!department.equals(user.getDepartment())) {
            return false;
        }

        return true;
    }
}