package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {

    // "//a[@title='Contact Us']"

    /*
    1. Inicjalizacja web elementów.
    2. Konstruktor + Page Factory !!!!!!
    3. Operacje na web elementach.
     */

    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement contactUs_link;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnContactUsLink(){
        wait.until(ExpectedConditions.elementToBeClickable(contactUs_link));
        contactUs_link.click();
        System.out.println("Contact Us link has been clicked");
    }
}
