package IOS.TestCasesIos;

import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import IOS.PageObjects.HomePageIos;
import IOS.PageObjects.LoginPageIos;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomPageTestIos extends BasePage {
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPageIos loginPageIos;

    HomePageIos homePageIos;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPageIos = new LoginPageIos(driver);
        homePageIos = loginPageIos.navigateToHomePageIos();
        logger.info("get driver executed");
    }

    @Test(description ="Verify all elements on Home Screen")
    public void verifyHomePageScreen() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePageIos.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertEquals("Home",homePageIos.getHomePageHeaderText(),"Actual and expected Text does not match :"+homePageIos.getHomePageHeaderText());
        Assertion.assertTrue("Enter Task text box is not displayed", homePageIos.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        Assertion.assertTrue("Add Task button is not displayed",homePageIos.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        Assertion.assertTrue("Go to Screen 1 is not displayed",homePageIos.isGoToScreenOneDisplayed(),"Go to Screen 1 is Displayed");
        Assertion.assertTrue("Go to Screen 2 is not displayed",homePageIos.isGoToScreenTwoDisplayed(),"Go to Screen 2 is Displayed");
        Assertion.assertTrue("Go to Screen 1 is not Enabled",homePageIos.isGoToScreenOneButtonEnabled(),"Go to Screen 1 is Enabled");
        Assertion.assertTrue("Go to Screen 2 is not Enabled",homePageIos.isGoToScreenTwoButtonEnabled(),"Go to Screen 2 is Enabled");
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify add Task functionality on HomePage")
    public void verifyAddTaskFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePageIos.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePageIos.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePageIos.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePageIos.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePageIos.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePageIos.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePageIos.getEnteredTaskName(), homePageIos.getTaskText(), "Task is added and successfully verified:"+homePageIos.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify added task on HomePage")
    public void verifyAddedTaskFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePageIos.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePageIos.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePageIos.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePageIos.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePageIos.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePageIos.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePageIos.getEnteredTaskName(), homePageIos.getTaskText(), "Task is added and successfully verified:"+homePageIos.getTaskText());
        Assertion.assertTrue("Task is not added and is not displayed",homePageIos.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePageIos.getEnteredTaskName(), homePageIos.getTaskText(), "Task is added and successfully verified:"+homePageIos.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify Done task functionality")
    public void verifyDoneTaskFunctionality() throws InterruptedException {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePageIos.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePageIos.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePageIos.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePageIos.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePageIos.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePageIos.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePageIos.getEnteredTaskName(), homePageIos.getTaskText(), "Task is added and successfully verified:"+homePageIos.getTaskText());
        Assertion.assertTrue("Done Button is not displayed",homePageIos.isDoneButtonDisplayed(),"Done Button is displayed");
        Assertion.assertTrue("Done Button is not Enabled",homePageIos.isDoneButtonEnabled(),"Done Button is Enabled");
        homePageIos.clickOnDoneButton();
        Assertion.assertTrue("Undo Button is not displayed",homePageIos.isUndoButtonVisible(),"Undo Button is Displayed");
        homePageIos.clickOnUndoButton();
        Assertion.assertEquals( homePageIos.getEnteredTaskName(), homePageIos.getTaskText(), "Task is added and successfully verified:"+homePageIos.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Verify delete task functionality")
    public void verifyDeleteTaskFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("HomePage header is not displayed", homePageIos.isHomePageHeaderDisplayed() , "HomePage header is displayed");
        Assertion.assertTrue("Enter Task text box is not displayed", homePageIos.enterTaskTextBoxDisplayed() , "Enter Task text box is displayed");
        homePageIos.enterTaskDescription("Task1");
        Assertion.assertTrue("Add Task button is not displayed",homePageIos.isAddTaskButtonDisplayed(),"Add Task button is Displayed");
        homePageIos.clickAddTaskButton();
        Assertion.assertTrue("Task is not added and is not displayed",homePageIos.isAddedTaskDisplayed(),"Task is added and successfully displayed");
        Assertion.assertEquals( homePageIos.getEnteredTaskName(), homePageIos.getTaskText(), "Task is added and successfully verified:"+homePageIos.getTaskText());
        Assertion.assertTrue("Delete Button is not displayed",homePageIos.isDoneButtonDisplayed(),"Delete Button is displayed");
        Assertion.assertTrue("Delete Button is not Enabled",homePageIos.isDoneButtonEnabled(),"Delete Button is Enabled");
        homePageIos.clickOnDeleteButton();
        Assertion.assertNotNullField("Task is not delete and is still displayed", homePageIos.getTaskText());
        LOGGER.info("==========TestCase End===============");
    }
}
