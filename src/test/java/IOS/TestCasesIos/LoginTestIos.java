package IOS.TestCasesIos;

import AppiumConfigurations.AppiumDriverFactory;
import Base.BasePage;
import IOS.PageObjects.LoginPageIos;
import Utils.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestIos extends BasePage {
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    LoginPageIos loginPageIos;


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppiumDriverFactory.initialiseDriver();
        loginPageIos = new LoginPageIos(driver);
        LOGGER.info("get driver executed");
    }

    @Test(description ="Verify all elements on login screen")
    public void verifyLoginPageElements() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("UserName text field is not displayed", loginPageIos.isUserNameTextBoxDisplayed() , "UserName text box is displayed");
        Assertion.assertTrue("UserName text field is not Enabled", loginPageIos.isUserNameTextBoxEnabled() , "UserName text field is not Enabled");
        Assertion.assertTrue("Password field is not displayed",loginPageIos.isPasswordTextBoxDisplayed(),"Password field is Displayed");
        Assertion.assertTrue("Password field is not Enabled",loginPageIos.isPasswordTextBoxEnabled(),"Password field is Enabled");
        Assertion.assertTrue("Login Button is not displayed",loginPageIos.isLoginButtonDisplayed(),"Login Button is Displayed");
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Validate valid credential functionality ")
    public void verifyValidLogin() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("UserName text field is not displayed", loginPageIos.isUserNameTextBoxDisplayed() , "UserName text box is displayed");
        loginPageIos.enterUserName("Test");
        Assertion.assertTrue("Password field is not displayed",loginPageIos.isPasswordTextBoxDisplayed(),"Password field is Displayed");
        loginPageIos.enterPassword("Test@123");
        Assertion.assertTrue("Login Button is not displayed",loginPageIos.isLoginButtonDisplayed(),"Login Button is Displayed");
        loginPageIos.clickOnLoginButton();
        LOGGER.info("==========TestCase End===============");
    }

    @Test(description ="Validate invalid credentials functionality")
    public void verifyInValidLogin() {
        LOGGER.info("==========TestCase Start===============");
        Assertion.assertTrue("UserName text field is not displayed", loginPageIos.isUserNameTextBoxDisplayed() , "UserName text box is displayed");
        loginPageIos.enterIncorrectUserName();
        Assertion.assertTrue("Password field is not displayed",loginPageIos.isPasswordTextBoxDisplayed(),"Password field is Displayed");
        loginPageIos.enterIncorrectPassword();
        Assertion.assertTrue("Login Button is not displayed",loginPageIos.isLoginButtonDisplayed(),"Login Button is Displayed");
        loginPageIos.clickOnLoginButton();
        Assertion.assertTrue("Invalid Credential Message is not displayed",loginPageIos.isInvalidCredentialAlertDisplayed(),"Invalid Credential Message is displayed");
        Assertion.assertEquals("Invalid Credentials",loginPageIos.invalidCredentialGetText(),"Text received is not as per the expected text");
        Assertion.assertTrue("Invalid Credential Message is not displayed",loginPageIos.isInvalidCredentialAlertDisplayed(),"Invalid Credential Message is displayed");
        Assertion.assertEquals("Invalid Credentials",loginPageIos.invalidCredentialGetText(),"Text received is not as per the expected text - Invalid Credentials Expected");
        Assertion.assertEquals("Please enter correct username and password.",loginPageIos.alertMessageGetText(),"Text received is not as per the expected text - Username and password correct message Expected");
        loginPageIos.clickOnOkButton();
        Assertion.assertTrue("Login Button is not displayed",loginPageIos.isLoginButtonDisplayed(),"Login Button is Displayed");
        LOGGER.info("==========TestCase End===============");
    }
}
