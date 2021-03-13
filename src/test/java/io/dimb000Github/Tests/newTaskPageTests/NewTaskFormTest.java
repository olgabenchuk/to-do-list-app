package io.dimb000Github.Tests.newTaskPageTests;

import io.dimb000Github.common.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.NewTaskPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NewTaskFormTest extends TestBase {

    @Test
    public void createANewTask(){
        navigateToTheNewTaskPage();

        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.enterTitle("House cleaning");
        newTaskPage.selectDate();
        newTaskPage.selectLowPriority();
        newTaskPage.enterDescription("Clean up the bathroom and kitchen");
        newTaskPage.saveTask();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://dimb000.github.io/"));

        assertTrue(driver.getPageSource().contains("House cleaning"));
    }

    @Test
    public void cancelAddingANewTask() {
        navigateToTheNewTaskPage();

        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.enterTitle("Olga Check");
        newTaskPage.enterDescription("German grammar(s.134-156)");
        newTaskPage.cancelAddingNewTask();

        assertFalse(driver.getPageSource().contains("Olga Check"));
    }
}

