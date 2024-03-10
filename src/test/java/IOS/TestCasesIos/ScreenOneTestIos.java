package IOS.TestCasesIos;

import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import IOS.PageObjects.HomePageIos;
import IOS.PageObjects.LoginPageIos;
import IOS.PageObjects.ScreenOneIos;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenOneTestIos extends BasePage {

    @DataProvider(name = "patientDetails")
    public Object[][] getPatientDetails() {
        return new Object[][]{
                {"Rajesh", "9989898291", "26", "170", "70", "130/90", "Normal"},
        };
    }

    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPageIos loginPageIos;

    HomePageIos homePageIos;

    ScreenOneIos screenOneIos;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPageIos = new LoginPageIos(driver);
        homePageIos = loginPageIos.navigateToHomePageIos();
        screenOneIos= homePageIos.navigateToScreenOnePage();
        LOGGER.info("get driver executed");
    }

    @Test(description = "To Add all details on screen 1 and save" , dataProvider = "patientDetails")
    public void testAddPatient(String name, String contact, String age, String height, String weight, String bloodPressure, String sugarLevel) {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("Screen One header is not displayed",screenOneIos.isScreenOneheaderDisplayed(),"Screen one header text is displayed");
        Assertion.assertTrue("Patient Details text is not displayed",screenOneIos.isaddPatientDetailsDisplayed(),"Patient Details text is displayed");
        screenOneIos.fillPatientDetails(name, contact, age, height, weight, bloodPressure, sugarLevel);
        Assertion.assertTrue("Add patient button is not enabled",screenOneIos.isAddPatientButtonEnabled(),"Add patient button is enabled");
        Assertion.assertTrue("Patient list text is not displayed",screenOneIos.isPatientListTextDisplayed(),"Patient list text is displayed");
        Assertion.assertFalse("Patient added and list is appearing - failure",screenOneIos.isPatientAddedDetailsSectionDisplayed(),"Patient is not added in the list ");
        screenOneIos.clickOnAddPatientButton();
        Assertion.assertTrue("Patient details not displayed",screenOneIos.isPatientAddedDetailsSectionDisplayed(),"Patient details visible");
        LOGGER.info("==========TestCase Ends===============");
    }
}
