import base.BaseTest;
import data.NameCards;
import data.NameElements;
import org.testng.annotations.Test;
import pages.*;
import user.User;

public class WebTablesTests extends BaseTest {
    @Test
    public void testAddUserToTableAndCheckHis() {
        User user = new User("Max", "Olistor", "test@gmail.com",27, 35000, "Sale");

        new ToolQaMainPage()
                .open()
                .clickOnCard(NameCards.ELEMENTS);

        new ElementsPage()
                .clickElementInList(NameElements.WEB_TABLES);

        new WebTablesPage()
                .clickOnAddButton()
                .registrationForm
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setAge(user.getAge())
                    .setEmail(user.getEmail())
                    .setSalary(user.getSalary())
                    .setDepartment(user.getDepartment())
                    .clickSubmitButton()
                .assertUserIsExistInTable(user);
    }

    @Test
    public void testEditUserDataInTable() {
        User user = new User("Max", "Olistor", "test@gmail.com",27, 35000, "Sale");
        User userEdit = new User("Ben", "Semuel", "testEdit@gmail.com",21, 41000, "IT");

        new ToolQaMainPage()
                .open()
                .clickOnCard(NameCards.ELEMENTS);

        new ElementsPage()
                .clickElementInList(NameElements.WEB_TABLES);

        new WebTablesPage()
                .clickOnAddButton()
                .registrationForm
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setAge(user.getAge())
                    .setEmail(user.getEmail())
                    .setSalary(user.getSalary())
                    .setDepartment(user.getDepartment())
                    .clickSubmitButton()
                .clickOnEditButton(user)
                .registrationForm
                    .editFirstName(userEdit.getFirstName())
                    .editLastName(userEdit.getLastName())
                    .editAge(userEdit.getAge())
                    .editEmail(userEdit.getEmail())
                    .editSalary(userEdit.getSalary())
                    .editDepartment(userEdit.getDepartment())
                    .clickSubmitButton()
                .assertUserIsExistInTable(userEdit);
    }
}