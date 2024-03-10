package IOS.TestCasesIos;
import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import IOS.PageObjects.HomePageIos;
import IOS.PageObjects.LoginPageIos;
import IOS.PageObjects.ScreenTwoIos;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenTwoTestIos extends BasePage {

    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPageIos loginPageIos;
    HomePageIos homePageIos;

    ScreenTwoIos screenTwoIos;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPageIos = new LoginPageIos(driver);
        homePageIos = loginPageIos.navigateToHomePageIos();
        screenTwoIos= homePageIos.navigateToScreenTwoPage();
        LOGGER.info("get driver executed");
    }

    @Test(description = "To verify all elements on ScreenTwo")
    public void verifyScreenTwo() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("Screen Two header is not displayed",screenTwoIos.isScreenTwoHeaderVisible(),"Screen two header text is displayed");
        Assertion.assertTrue("Sunday is not displayed",screenTwoIos.isSundayDisplayedOnCalendar(),"Sunday text is displayed");
        Assertion.assertTrue("Monday is not displayed",screenTwoIos.isMondayDisplayedOnCalendar(),"Monday text is displayed");
        Assertion.assertTrue("Tuesday is not displayed",screenTwoIos.isTuesdayDisplayedOnCalendar(),"Tuesday text is displayed");
        Assertion.assertTrue("Wednesday is not displayed",screenTwoIos.isWednesdayDisplayedOnCalendar(),"Wednesday text is displayed");
        Assertion.assertTrue("Thursday is not displayed",screenTwoIos.isThursdayDisplayedOnCalendar(),"Thursday text is displayed");
        Assertion.assertTrue("Friday is not displayed",screenTwoIos.isFridayDisplayedOnCalendar(),"Friday text is displayed");
        Assertion.assertTrue("Saturday is not displayed",screenTwoIos.isSaturdayDisplayedOnCalendar(),"Saturday text is displayed");
        Assertion.assertTrue("Schedule appointment button is not enabled",screenTwoIos.isScheduleAppointmentButtonEnabled(),"Schedule Appointment is Enabled");
        LOGGER.info("==========TestCase Ends===============");
    }

    @Test(description = "To Verify schedule appointment functionality")
    public void verifyAppointmentScheduleFunctionality() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("Screen Two header is not displayed",screenTwoIos.isScreenTwoHeaderVisible(),"Screen two header text is displayed");
        Assertion.assertTrue("Date is not displayed",screenTwoIos.isDateDisplayed(),"Date is displayed");
        screenTwoIos.clickOnDate();
        Assertion.assertTrue("Upcoming Appointment Text is not displayed",screenTwoIos.isUpcomingAppointmentTextDisplayed(),"Upcoming Appointment Texi is displayed");
        screenTwoIos.clickOnScheduleAppointmentButton();
        Assertion.assertFalse("Appointment is scheduled-Fail",screenTwoIos.isUpcomingAppointmentTextDisplayed(),"Appointment is not reflected - Pass");
        LOGGER.info("==========TestCase Ends===============");
    }
}