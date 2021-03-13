package io.dimb000Github.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.Header;

public class TestBase {
    public static WebDriver driver = null;

    @BeforeMethod
    public static void initialize() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//drivers//chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://dimb000.github.io");

    }

    @AfterMethod
    public void TeardownTest() {
        TestBase.driver.quit();
    }

    public static void navigateToTheNewTaskPage() {
        //the app is achievable only using https://dimb000.github.io/
        // that is why I have to click it first to reach a new task page
        Header header = new Header(driver);
        header.clickNewTaskLink();
    }
}
