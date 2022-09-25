package Tests;

import Base.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutomationpracticeTest extends BaseTest {

    @Test
    public void fillForm() {
        System.out.println("Wykonuję test");

        String expectedMessage = "Your message has been successfully sent to our team.";

        HomePage homePage = new HomePage(driver);
        homePage.clickOnContactUsLink();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.selectOptionFromSubjectHeading();
        contactUsPage.sendEmail("adres@email.com");
        contactUsPage.sendOrderReference("1234");
        contactUsPage.sendFile();
        contactUsPage.sendMessage("blablabla");
        contactUsPage.clickSendButton();

        String actualMessage = contactUsPage.getConfirmationMessage();

        assertThat(expectedMessage, equalTo(actualMessage));

    }
}
