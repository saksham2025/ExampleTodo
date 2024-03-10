package Android.TestCases;

import Android.PageObjects.LoginPage;
import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest extends BasePage {
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPage = new LoginPage(driver);
        LOGGER.info("get driver executed");
    }

    @Test(description ="Verify all elements on login screen")
    public void verifyLoginPageElements() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("UserName text field is not displayed", loginPage.isUserNameTextBoxDisplayed() , "UserName text box is displayed");
        Assertion.assertTrue("UserName text field is not Enabled", loginPage.isUserNameTextBoxEnabled() , "UserName text field is not Enabled");
        Assertion.assertTrue("Password field is not displayed",loginPage.isPasswordTextBoxDisplayed(),"Password field is Displayed");
        Assertion.assertTrue("Password field is not Enabled",loginPage.isPasswordTextBoxEnabled(),"Password field is Enabled");
        Assertion.assertTrue("Login Button is not displayed",loginPage.isLoginButtonDisplayed(),"Login Button is Displayed");
        Assertion.assertTrue("Show Password icon is not displayed",loginPage.isShowPasswordButtonDisplayed(),"Show Password Icon is displayed");
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Validate valid credential functionality ")
    public void verifyValidLogin() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("UserName text field is not displayed", loginPage.isUserNameTextBoxDisplayed() , "UserName text box is displayed");
        loginPage.enterUserName("Test");
        Assertion.assertTrue("Password field is not displayed",loginPage.isPasswordTextBoxDisplayed(),"Password field is Displayed");
        loginPage.enterPassword("Test@123");
        loginPage.clickOnShowPassword();
        Assertion.assertTrue("Login Button is not displayed",loginPage.isLoginButtonDisplayed(),"Login Button is Displayed");
        loginPage.clickOnLoginButton();
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Validate invalid credentials functionality")
    public void verifyInValidLogin() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("UserName text field is not displayed", loginPage.isUserNameTextBoxDisplayed() , "UserName text box is displayed");
        loginPage.enterIncorrectUserName();
        Assertion.assertTrue("Password field is not displayed",loginPage.isPasswordTextBoxDisplayed(),"Password field is Displayed");
        loginPage.enterIncorrectPassword();
        Assertion.assertTrue("Login Button is not displayed",loginPage.isLoginButtonDisplayed(),"Login Button is Displayed");
        loginPage.clickOnLoginButton();
        Assertion.assertTrue("Invalid Credential Message is not displayed",loginPage.isInvalidCredentialAlertDisplayed(),"Invalid Credential Message is displayed");
        Assertion.assertEquals("Invalid Credentials",loginPage.invalidCredentialGetText(),"Text received is not as per the expected text");
        Assertion.assertTrue("Invalid Credential Message is not displayed",loginPage.isInvalidCredentialAlertDisplayed(),"Invalid Credential Message is displayed");
        Assertion.assertEquals("Invalid Credentials",loginPage.invalidCredentialGetText(),"Text received is not as per the expected text - Invalid Credentials Expected");
        Assertion.assertEquals("Please enter correct username and password.",loginPage.alertMessageGetText(),"Text received is not as per the expected text - Username and password correct message Expected");
        loginPage.clickOnOkButton();
        Assertion.assertTrue("Login Button is not displayed",loginPage.isLoginButtonDisplayed(),"Login Button is Displayed");
        LOGGER.info("==========TestCase End===============");
    }
}
