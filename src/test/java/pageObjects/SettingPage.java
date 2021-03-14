package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class SettingPage {
    private WebDriver driver;

    public SettingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "language")
    private WebElement languageDropdownList;

    public void selectRussianLanguage() {
        Select languageList  = new Select(languageDropdownList);
        languageList.selectByVisibleText("Русский");
    }
}
