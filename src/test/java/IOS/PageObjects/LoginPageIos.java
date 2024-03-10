package IOS.PageObjects;

import Android.PageObjects.HomePage;
import AppiumConfigurations.DriverManager;
import Base.BasePage;
import Utils.Action;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPageIos extends BasePage {
    public LoginPageIos(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Username\"`]")
    private WebElement userNameTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    private WebElement passwordTextBox;

    @iOSXCUITFindBy(accessibility = "Login")
    private WebElement loginButton;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == \"Invalid Credentials\"`]")
    private WebElement inValidCredentialsAlert;

    @iOSXCUITFindBy(accessibility="Please enter correct username and password.")
    private WebElement alertMessage;

    @iOSXCUITFindBy(accessibility="OK")
    private WebElement okButton;

    public boolean isUserNameTextBoxDisplayed() {
        return Action.isDisplayed(userNameTextBox);
    }

    public boolean isUserNameTextBoxEnabled() {
        return Action.isEnabled(userNameTextBox);
    }

    public void clickOnUserName() {
        Action.click(userNameTextBox);
    }

    public boolean isPasswordTextBoxDisplayed() {
        return Action.isDisplayed(passwordTextBox);
    }

    public boolean isPasswordTextBoxEnabled() {
        return Action.isEnabled(passwordTextBox);
    }

    public void clickOnPassword(){
        Action.click(passwordTextBox);
    }

    public boolean isLoginButtonDisplayed(){
        return Action.isDisplayed(loginButton);
    }

    public void clickOnLoginButton(){
        Action.click(loginButton);
    }


    public void enterUserName(String name){
        Action.sendText(userNameTextBox,name);
    }

    public void enterPassword(String password){
        Action.sendText(passwordTextBox,password);
    }

    public String userNameAttribute() {
        return Action.getAttribute(userNameTextBox, "value");
    }
    public String passwordAttribute() {
        return Action.getAttribute(passwordTextBox, "value");
    }


    public void enterIncorrectUserName(){
        Action.sendText(userNameTextBox,Action.generateRandomStringInRange());
    }

    public void enterIncorrectPassword(){
        Action.sendText(passwordTextBox,Action.generateRandomStringInRange());
    }

    public boolean isInvalidCredentialAlertDisplayed(){
        return Action.isDisplayed(inValidCredentialsAlert);
    }

    public String invalidCredentialGetText(){
        return Action.getText(inValidCredentialsAlert);
    }

    public boolean isalertMessageDisplayed(){
        return Action.isDisplayed(alertMessage);
    }

    public String alertMessageGetText(){
        return Action.getText(alertMessage);
    }

    public boolean isOkButtonDisplayed(){
        return Action.isDisplayed(okButton);
    }

    public void clickOnOkButton(){
        Action.click(okButton);
    }

    public HomePageIos navigateToHomePageIos() throws MalformedURLException {
        Action.sendText(userNameTextBox,"Test");
        Action.sendText(passwordTextBox,"Test@123");
        clickOnLoginButton();
        return new HomePageIos(DriverManager.getDriver());
    }
}
