package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class ContactUsPage extends BaseTest {

    @FindBy(id = "id_contact")
    private WebElement subjectHeading_select;

    @FindBy(id = "email")
    private WebElement emailAdress_input;

    @FindBy(xpath = "//input[@id='id_order']")
    private WebElement orderReference_input;

    @FindBy(css = "#fileUpload")
    private WebElement attachFile_input;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement message_textarea;

    @FindBy(css = "#submitMessage")
    private WebElement send_button;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement confirmationMessage;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectOptionFromSubjectHeading() {
        Select subjectDropdownList = new Select(subjectHeading_select);
        subjectDropdownList.selectByIndex(1);
        System.out.println("Opcja w dropdown liście zaznaczona");
    }

    public void sendEmail(String emailAdress) {
        emailAdress_input.clear();
        emailAdress_input.sendKeys(emailAdress);
        System.out.println("Email adres podany");
    }

    public void sendOrderReference(String orderReference) {
        orderReference_input.clear();
        orderReference_input.sendKeys(orderReference);
        System.out.println("Numer zamówienia wprowadzony");
    }

    public void sendFile() {
        attachFile_input.clear();
        File file = new File("src/main/resources/file.txt");
        attachFile_input.sendKeys(file.getAbsolutePath());
        System.out.println("Plik załączony");
    }

    public void sendMessage(String messageText) {
        message_textarea.clear();
        message_textarea.sendKeys(messageText);
        System.out.println("Wiadomość została wpisana");
    }

    public void clickSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(send_button));    // -> przed rozpoczęciem interakcji
        send_button.click();
        System.out.println("Formularz został wysłany");
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.textToBePresentInElement(confirmationMessage, "Your message has been successfully sent to our team."));
        String textmessage = confirmationMessage.getText();
        System.out.println("Confirmation message: " + textmessage);
        return textmessage;

    }
}
