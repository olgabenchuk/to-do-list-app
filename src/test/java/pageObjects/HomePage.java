package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Add a new one")
    private WebElement addNewTask;

    @FindBy(css = "button[aria-label*='Edit']")
    private List<WebElement> editTaskButtons;

    @FindBy(css = "button[aria-label*='Remove']")
    private List<WebElement> deleteTaskButtons;

    @FindBy(xpath = "//ul[@aria-labelledby='tasks-preview-future']//input")
    private WebElement completeATaskButton;

    @FindBy(xpath = "//span[contains(text(), 'moloknl')]/..")
    private WebElement completeTaskButton;

    @FindBy(xpath = "//h1[@id=\"tasks-preview-completed\"]/button")
    private WebElement tasksPreviewCompletedButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickLink() {
        addNewTask.click();
    }

    public void clickEditTaskButton(String title) {
        for (int buttonIndex = 0; buttonIndex < editTaskButtons.size(); buttonIndex++) {
            if (editTaskButtons.get(buttonIndex).getAttribute("aria-label").contains(title)) {
                editTaskButtons.get(buttonIndex).click();
            }
        }
    }

    public WebElement clickDeleteTaskButton(String title) {
        for (int buttonIndex = 0; buttonIndex < deleteTaskButtons.size(); buttonIndex++) {
            if (deleteTaskButtons.get(buttonIndex).getAttribute("aria-label").contains(title)) {
                deleteTaskButtons.get(buttonIndex).click();
                return deleteTaskButtons.get(buttonIndex);
            }
        }

        return null;
    }

    public WebElement  clickCompleteButton() {
        completeTaskButton.click();
        return tasksPreviewCompletedButton;
    }

}
