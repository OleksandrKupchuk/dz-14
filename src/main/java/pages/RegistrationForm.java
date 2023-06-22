package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationForm<T> {
    private WebDriver driver;
    private T page;
    public RegistrationForm(WebDriver driver, T page) {
        this.driver = driver;
        this.page = page;
    }

    private By firstName = By.xpath("//input[@id='firstName']");
    private By lastName = By.xpath("//input[@id='lastName']");
    private By email = By.xpath("//input[@id='userEmail']");
    private By age = By.xpath("//input[@id='age']");
    private By salary = By.xpath("//input[@id='salary']");
    private By department = By.xpath("//input[@id='department']");
    private By submitButton = By.id("submit");

    public RegistrationForm<T> setFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public RegistrationForm<T> setLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public RegistrationForm<T> setEmail(String email){
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    public RegistrationForm<T> setAge(int age){
        driver.findElement(this.age).sendKeys(Integer.toString(age));
        return this;
    }

    public RegistrationForm<T> setSalary(int salary){
        driver.findElement(this.salary).sendKeys(Integer.toString(salary));
        return this;
    }

    public RegistrationForm<T> setDepartment(String department){
        driver.findElement(this.department).sendKeys(department);
        return this;
    }

    public T clickSubmitButton(){
        driver.findElement(submitButton).click();
        return (T) page;
    }

    public RegistrationForm<T> editFirstName(String firstName){
        driver.findElement(this.firstName).clear();
        setFirstName(firstName);
        return this;
    }

    public RegistrationForm<T> editLastName(String lastName){
        driver.findElement(this.lastName).clear();
        setLastName(lastName);
        return this;
    }

    public RegistrationForm<T> editEmail(String email){
        driver.findElement(this.email).clear();
        setEmail(email);
        return this;
    }

    public RegistrationForm<T> editAge(int age){
        driver.findElement(this.age).clear();
        setAge(age);
        return this;
    }

    public RegistrationForm<T> editSalary(int salary){
        driver.findElement(this.salary).clear();
        setSalary(salary);
        return this;
    }

    public RegistrationForm<T> editDepartment(String department){
        driver.findElement(this.department).clear();
        setDepartment(department);
        return this;
    }
}