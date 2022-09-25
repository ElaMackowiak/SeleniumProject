package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    private static String url = "http://automationpractice.com/index.php";
    public static WebDriverWait wait;

    @BeforeAll
    static void setUpDriver() {
        System.out.println("Jestem w setUpDriver");
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Jestem w tearDown");
        driver.quit();
        System.out.println("Przeglądarka zamknięta poprawnie");
    }
}
