package io.dimb000Github.Tests.homePageTests;

import io.dimb000Github.common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Header;
import pageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.NewTaskPage;
import static org.testng.Assert.*;

public class HomePageTest extends TestBase {

    @Test
    public void editATask() {
        navigateToTheNewTaskPage();

        String title = "House cleaning";

        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.enterTitle(title);
        newTaskPage.saveTask();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://dimb000.github.io/"));

        assertEquals(driver.getCurrentUrl(), "https://dimb000.github.io/");
        assertTrue(driver.getPageSource().contains(title));

        HomePage homePage = new HomePage(driver);
        homePage.clickEditTaskButton(title);
        newTaskPage.enterTitle("Learn German");
        newTaskPage.saveTask();
        wait.until(ExpectedConditions.urlToBe("https://dimb000.github.io/"));

        assertEquals(driver.getCurrentUrl(), "https://dimb000.github.io/");
        assertTrue(driver.getPageSource().contains("Learn German"));
    }

    @Test
    public void deleteATask() {
        navigateToTheNewTaskPage();

        String title = "Study Selenium Webdriver course";

        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.enterTitle(title);
        newTaskPage.saveTask();

        HomePage homePage = new HomePage(driver);
        WebElement deleteButton = homePage.clickDeleteTaskButton(title);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.stalenessOf(deleteButton));

        assertFalse(driver.getPageSource().contains(title));
    }
    @Test
    public void makeATaskComplete() {
        navigateToTheNewTaskPage();

        String title = "moloknl";

        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.enterTitle(title);
        newTaskPage.saveTask();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://dimb000.github.io/"));

        assertTrue(driver.getPageSource().contains("Upcoming"));

        HomePage homePage = new HomePage(driver);
        WebElement tasksPreviewCompletedButton = homePage.clickCompleteButton();

        wait.until(ExpectedConditions.visibilityOf(tasksPreviewCompletedButton));

        assertTrue(driver.getPageSource().contains("Completed"));

    }

}





