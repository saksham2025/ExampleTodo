package Android.TestCases;

import Android.PageObjects.HomePage;
import Android.PageObjects.LoginPage;
import Android.PageObjects.ScreenOne;
import Android.PageObjects.ScreenTwo;
import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenTwoTest extends BasePage {

    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPage loginPage;
    HomePage homePage;

    ScreenTwo screenTwo;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPage = new LoginPage(driver);
        homePage = loginPage.navigateToHomePage();
        screenTwo= homePage.navigateToScreenTwoPage();
        LOGGER.info("get driver executed");
    }

    @Test(description = "To verify all elements on ScreenTwo")
    public void verifyScreenTwo() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("Screen Two header is not displayed",screenTwo.isScreenTwoHeaderVisible(),"Screen two header text is displayed");
        Assertion.assertTrue("Sunday is not displayed",screenTwo.isSundayDisplayedOnCalendar(),"Sunday text is displayed");
        Assertion.assertTrue("Monday is not displayed",screenTwo.isMondayDisplayedOnCalendar(),"Monday text is displayed");
        Assertion.assertTrue("Tuesday is not displayed",screenTwo.isTuesdayDisplayedOnCalendar(),"Tuesday text is displayed");
        Assertion.assertTrue("Wednesday is not displayed",screenTwo.isWednesdayDisplayedOnCalendar(),"Wednesday text is displayed");
        Assertion.assertTrue("Thursday is not displayed",screenTwo.isThursdayDisplayedOnCalendar(),"Thursday text is displayed");
        Assertion.assertTrue("Friday is not displayed",screenTwo.isFridayDisplayedOnCalendar(),"Friday text is displayed");
        Assertion.assertTrue("Saturday is not displayed",screenTwo.isSaturdayDisplayedOnCalendar(),"Saturday text is displayed");
        Assertion.assertTrue("Schedule appointment button is not enabled",screenTwo.isScheduleAppointmentButtonEnabled(),"Schedule Appointment is Enabled");
        LOGGER.info("==========TestCase Ends===============");
    }

    @Test(description = "To Verify schedule appointment functionality")
    public void verifyAppointmentScheduleFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("Screen Two header is not displayed",screenTwo.isScreenTwoHeaderVisible(),"Screen two header text is displayed");
        screenTwo.clickOnRightArrow();
        Assertion.assertTrue("Date is not displayed",screenTwo.isDateDisplayed(),"Date is displayed");
        screenTwo.clickOnDate();
        Assertion.assertTrue("Upcoming Appointment Text is not displayed",screenTwo.isUpcomingAppointmentTextDisplayed(),"Upcoming Appointment Texi is displayed");
        screenTwo.enterAppointmentDetailsTextBox("Test");
        Assertion.assertTrue("Selected appointment date is not displayed",screenTwo.selectedAppointmentDateDisplayed(),"Selected Appointment date is displayed");
        screenTwo.clickOnScheduleAppointmentButton();
        Assertion.assertFalse("Appointment is scheduled-Fail",screenTwo.isUpcomingAppointmentTextDisplayed(),"Appointment is not reflected - Pass");
        LOGGER.info("==========TestCase Ends===============");
    }
}
