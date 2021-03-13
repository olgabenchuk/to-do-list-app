package io.dimb000Github.Tests.settingsPageTest;
import io.dimb000Github.common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.Header;
import pageObjects.SettingPage;
import static org.testng.Assert.*;

public class SettingsPageTest extends TestBase {
    @Test
    public void changeLanguage() {
        Header header = new Header(driver);
        header.clickSettingLink();

        SettingPage settingPage = new SettingPage(driver);

        settingPage.selectRussianLanguage();

        System.out.println(driver.getPageSource());

        assertTrue(driver.getPageSource().contains("Язык"));

    }
}
