package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private WebDriver driver;

    @FindBy(linkText = "New Task")
    private WebElement addNewTaskLink;

    @FindBy(linkText = "Settings")
    private WebElement settingsLink;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickNewTaskLink() {

        addNewTaskLink.click();
    }
    public void clickSettingLink() {
        settingsLink.click();
    }
}
