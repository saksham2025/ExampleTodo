package Android.TestCases;

import Android.PageObjects.HomePage;
import Android.PageObjects.LoginPage;
import Android.PageObjects.ScreenOne;
import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenOneTest extends BasePage {

    @DataProvider(name = "patientDetails")
    public Object[][] getPatientDetails() {
        return new Object[][]{
                {"Rajesh", "9989898291", "26", "170", "70", "130/90", "Normal"},
        };
    }

    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPage loginPage;
    HomePage homePage;

    ScreenOne screenOne;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPage = new LoginPage(driver);
        homePage = loginPage.navigateToHomePage();
        screenOne= homePage.navigateToScreenOnePage();
        LOGGER.info("get driver executed");
    }

    @Test(description = "To Add all details on screen 1 and save" , dataProvider = "patientDetails")
    public void testAddPatient(String name, String contact, String age, String height, String weight, String bloodPressure, String sugarLevel) {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("Screen One header is not displayed",screenOne.isScreenOneheaderDisplayed(),"Screen one header text is displayed");
        Assertion.assertTrue("Patient Details text is not displayed",screenOne.isaddPatientDetailsDisplayed(),"Patient Details text is displayed");
        screenOne.fillPatientDetails(name, contact, age, height, weight, bloodPressure, sugarLevel);
        Assertion.assertTrue("Add patient button is not enabled",screenOne.isAddPatientButtonEnabled(),"Add patient button is enabled");
        Assertion.assertTrue("Patient list text is not displayed",screenOne.isPatientListTextDisplayed(),"Patient list text is displayed");
        Assertion.assertFalse("Patient added and list is appearing - failure",screenOne.isPatientAddedDetailsSectionDisplayed(),"Patient is not added in the list ");
        screenOne.clickOnAddPatientButton();
        Assertion.assertTrue("Patient details not displayed",screenOne.isPatientAddedDetailsSectionDisplayed(),"Patient details visible");
        LOGGER.info("==========TestCase Ends===============");
    }
}

