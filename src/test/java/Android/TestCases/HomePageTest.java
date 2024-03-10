package Android.TestCases;

import Android.PageObjects.HomePage;
import Android.PageObjects.LoginPage;
import AppiumConfigurations.AppiumDriverFactory;
import AppiumConfigurations.AppiumServer;
import AppiumConfigurations.DriverManager;
import Base.BasePage;
import Utils.Assertion;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BasePage {
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPage loginPage;

    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPage = new LoginPage(driver);
        homePage = loginPage.navigateToHomePage();
        logger.info("get driver executed");
    }

    @Test(description ="Verify all elements on Home Screen")
    public void verifyHomePageScreen() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePage.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertEquals("Home",homePage.getHomePageHeaderText(),"Actual and expected Text does not match :"+homePage.getHomePageHeaderText());
        Assertion.assertTrue("Enter Task text box is not displayed", homePage.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        Assertion.assertTrue("Add Task button is not displayed",homePage.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        Assertion.assertTrue("Go to Screen 1 is not displayed",homePage.isGoToScreenOneDisplayed(),"Go to Screen 1 is Displayed");
        Assertion.assertTrue("Go to Screen 2 is not displayed",homePage.isGoToScreenTwoDisplayed(),"Go to Screen 2 is Displayed");
        Assertion.assertTrue("Go to Screen 1 is not Enabled",homePage.isGoToScreenOneButtonEnabled(),"Go to Screen 1 is Enabled");
        Assertion.assertTrue("Go to Screen 2 is not Enabled",homePage.isGoToScreenTwoButtonEnabled(),"Go to Screen 2 is Enabled");
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify add Task functionality on HomePage")
    public void verifyAddTaskFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePage.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePage.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePage.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePage.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePage.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePage.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePage.getEnteredTaskName(), homePage.getTaskText(), "Task is added and successfully verified:"+homePage.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify added task on HomePage")
    public void verifyAddedTaskFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePage.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePage.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePage.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePage.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePage.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePage.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePage.getEnteredTaskName(), homePage.getTaskText(), "Task is added and successfully verified:"+homePage.getTaskText());
        Assertion.assertTrue("Task is not added and is not displayed",homePage.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePage.getEnteredTaskName(), homePage.getTaskText(), "Task is added and successfully verified:"+homePage.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify Done task functionality")
    public void verifyDoneTaskFunctionality() throws InterruptedException {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePage.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePage.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePage.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePage.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePage.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePage.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePage.getEnteredTaskName(), homePage.getTaskText(), "Task is added and successfully verified:"+homePage.getTaskText());
        Assertion.assertTrue("Done Button is not displayed",homePage.isDoneButtonDisplayed(),"Done Button is displayed");
        Assertion.assertTrue("Done Button is not Enabled",homePage.isDoneButtonEnabled(),"Done Button is Enabled");
        homePage.clickOnDoneButton();
        Assertion.assertTrue("Undo Button is not displayed",homePage.isUndoButtonVisible(),"Undo Button is Displayed");
        homePage.clickOnUndoButton();
        Assertion.assertEquals( homePage.getEnteredTaskName(), homePage.getTaskText(), "Task is added and successfully verified:"+homePage.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify delete task functionality")
    public void verifyDeleteTaskFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePage.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePage.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePage.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePage.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePage.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePage.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePage.getEnteredTaskName(), homePage.getTaskText(), "Task is added and successfully verified:"+homePage.getTaskText());
        Assertion.assertTrue("Delete Button is not displayed",homePage.isDoneButtonDisplayed(),"Delete Button is displayed");
        Assertion.assertTrue("Delete Button is not Enabled",homePage.isDoneButtonEnabled(),"Delete Button is Enabled");
        homePage.clickOnDeleteButton();
        Assertion.assertNotNullField("Task is not delete and is still displayed", homePage.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }
}

