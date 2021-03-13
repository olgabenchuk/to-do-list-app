package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTaskPage  {
    private WebDriver driver;

    @FindBy(linkText = "Back to the tasks")
    private WebElement backLink;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(xpath = "//button[text() = \"Add date/time\"]")
    private WebElement addDateButton;

    @FindBy(xpath = "//input[@value=\"low\"]/..")
    private WebElement lowPriority;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(xpath = "//button[text() = \"Save\"]" )
    private WebElement saveButton;

    @FindBy(xpath = "//button[text() = \"Cancel\"]" )
    private WebElement cancelButton;

    @FindBy(xpath = "//button[text()=\"Add date/time\"]")
    private WebElement clickCalendarButton;

    @FindBy(xpath = "//button[@class=\"sc-gipzik ldmchX\"]")
    private WebElement currentDateButton;

    @FindBy(xpath = "//span[text()=\"Time\"]/following-sibling::input")
    private WebElement timeInput;

    @FindBy(xpath = "//div[@class=\"sc-bYSBpT gzmogp\"]/button[text()=\"Save\"]")
    private WebElement saveCalendarButton;

    public NewTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterTitle(String title) {
        this.title.clear();
        this.title.sendKeys(title);
    }

    public void selectLowPriority() {
        lowPriority.click();
    }

    public void enterDescription(String description) {
        this.description.clear();
        this.description.sendKeys(description);
    }

    public void selectDate() {
        this.clickCalendarButton.click();
        this.currentDateButton.click();
        this.saveCalendarButton.click();
    }

    public void saveTask() {
        this.saveButton.click();
    }

    public void cancelAddingNewTask() {
        this.cancelButton.click();
    }
}
