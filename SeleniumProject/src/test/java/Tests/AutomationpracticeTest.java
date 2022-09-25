package Tests;

import Base.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutomationpracticeTest extends BaseTest {
    public WebDriver driver;
    private String url = "http://automationpractice.com/index.php";

    @BeforeClass
    void setUpDriver() {
        System.out.println("Jestem w setUpDriver");
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
        driver.get(url);
    }

    @AfterTest
    void tearDown() {
        System.out.println("Jestem w tearDown");
        driver.quit();
        System.out.println("Przeglądarka zamknięta poprawnie");
    }

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
