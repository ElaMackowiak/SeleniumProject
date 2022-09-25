package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;

public class BaseTest {

  /*  protected WebDriver driver;*/
   /* private String url = "http://automationpractice.com/index.php";*/

    @BeforeClass
    void setUpDriver() {
        System.out.println("Jestem setUpDriver");
       /* ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
        driver.get(url);*/
    }

    @AfterTest
    void tearDown() {
        System.out.println("Jestem w tearDown");
       /* driver.quit();*/
    }
}
