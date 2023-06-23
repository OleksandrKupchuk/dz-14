import base.BaseTest;
import data.ButtonsText;
import data.NameCards;
import data.NameElements;
import org.testng.annotations.Test;
import pages.ButtonsPage;
import pages.ElementsPage;
import pages.ToolQaMainPage;

public class ElementsTests extends BaseTest {
    @Test
    public void testClickOnButtonClickMe() {
        new ToolQaMainPage()
                .open()
                .clickOnCard(NameCards.ELEMENTS);

        new ElementsPage()
                .clickElementInList(NameElements.BUTTONS);

        new ButtonsPage()
                .clickOnButton(ButtonsText.BUTTON_CLICK_ME)
                .assertMessageClickMe(ButtonsText.MESSAGE_CLICK);
    }
}