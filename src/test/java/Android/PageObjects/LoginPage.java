package Android.PageObjects;

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
import java.rmi.activation.ActivationID;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Android Paths
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Username')]")
    private WebElement userNameTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Password')]")
    private WebElement passwordTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'LOGIN')]")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'')]")
    private WebElement showPasswordButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement inValidCredentialsAlert;

    @AndroidFindBy(id = "android:id/message")
    private WebElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;

    //IOS paths
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Username\"`]")
    private WebElement iOSUserNameTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    private WebElement iOSPasswordTextBox;

    @iOSXCUITFindBy(accessibility = "Login")
    private WebElement iOSLoginButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Invalid Credentials\"`]")
    private WebElement iOSInvalidCredentialsAlert;

    @iOSXCUITFindBy(accessibility = "Please enter correct username and password.")
    private WebElement iOSAlertMessage;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement iOSOkButton;

//    public boolean isUserNameTextBoxDisplayed() {
//        return Action.isDisplayed(userNameTextBox);
//    }
//
//    public boolean isUserNameTextBoxEnabled() {
//        return Action.isEnabled(userNameTextBox);
//    }
//
//    public void clickOnUserName() {
//        Action.click(userNameTextBox);
//    }
//
//    public boolean isPasswordTextBoxDisplayed() {
//        return Action.isDisplayed(passwordTextBox);
//    }
//
//    public boolean isPasswordTextBoxEnabled() {
//        return Action.isEnabled(passwordTextBox);
//    }
//
//    public void clickOnPassword(){
//        Action.click(passwordTextBox);
//    }
//
//    public boolean isLoginButtonDisplayed(){
//       return Action.isDisplayed(loginButton);
//    }
//
//    public void clickOnLoginButton(){
//        Action.click(loginButton);
//    }
//
//    public boolean isShowPasswordButtonDisplayed(){
//        return Action.isDisplayed(showPasswordButton);
//    }
//
//    public void enterUserName(String name){
//        Action.sendText(userNameTextBox,name);
//    }
//
//    public void enterPassword(String password){
//        Action.sendText(passwordTextBox,password);
//    }
//
//    public String userNameAttribute() {
//        return Action.getAttribute(userNameTextBox, "value");
//    }
//    public String passwordAttribute() {
//        return Action.getAttribute(passwordTextBox, "value");
//    }
//
//    public void clickOnShowPassword(){
//        Action.click(showPasswordButton);
//    }
//
//    public void enterIncorrectUserName(){
//        Action.sendText(userNameTextBox,Action.generateRandomStringInRange());
//    }
//
//    public void enterIncorrectPassword(){
//        Action.sendText(passwordTextBox,Action.generateRandomStringInRange());
//    }
//
//    public boolean isInvalidCredentialAlertDisplayed(){
//        return Action.isDisplayed(inValidCredentialsAlert);
//    }
//
//    public String invalidCredentialGetText(){
//        return Action.getText(inValidCredentialsAlert);
//    }
//
//    public boolean isalertMessageDisplayed(){
//        return Action.isDisplayed(alertMessage);
//    }
//
//    public String alertMessageGetText(){
//        return Action.getText(alertMessage);
//    }
//
//    public boolean isOkButtonDisplayed(){
//        return Action.isDisplayed(okButton);
//    }
//
//    public void clickOnOkButton(){
//         Action.click(okButton);
//    }
//
//    public HomePage navigateToHomePage() throws MalformedURLException {
//        Action.sendText(userNameTextBox,"Test");
//        Action.sendText(passwordTextBox,"Test@123");
//        clickOnLoginButton();
//        return new HomePage(DriverManager.getDriver());
//    }

    public boolean isUserNameTextBoxDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(userNameTextBox);
        } else {
            return Action.isDisplayed(iOSUserNameTextBox);
        }
    }

    public boolean isUserNameTextBoxEnabled() {
        if (isAndroid()) {
            return Action.isEnabled(userNameTextBox);
        } else {
            return Action.isEnabled(iOSUserNameTextBox);
        }
    }

    public void clickOnUserName() {
        if (isAndroid()) {
            Action.click(userNameTextBox);
        } else {
            Action.click(iOSUserNameTextBox);
        }
    }

    public boolean isPasswordTextBoxDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(passwordTextBox);
        } else {
            return Action.isDisplayed(iOSPasswordTextBox);
        }
    }

    public boolean isPasswordTextBoxEnabled() {
        if (isAndroid()) {
            return Action.isEnabled(passwordTextBox);
        } else {
            return Action.isEnabled(iOSPasswordTextBox);
        }
    }

    public void clickOnPassword() {
        if (isAndroid()) {
            Action.click(passwordTextBox);
        } else {
            Action.click(iOSPasswordTextBox);
        }
    }

    public boolean isLoginButtonDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(loginButton);
        } else {
            return Action.isDisplayed(iOSLoginButton);
        }
    }

    public void clickOnLoginButton() {
        if (isAndroid()) {
            Action.click(loginButton);
        } else {
            Action.click(iOSLoginButton);
        }
    }

    public boolean isShowPasswordButtonDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(showPasswordButton);
        } else {
            // No show password button for iOS, return false
            return false;
        }
    }

    public void enterUserName(String name) {
        if (isAndroid()) {
            Action.sendText(userNameTextBox, name);
        } else {
            Action.sendText(iOSUserNameTextBox, name);
        }
    }

    public void enterPassword(String password) {
        if (isAndroid()) {
            Action.sendText(passwordTextBox, password);
        } else {
            Action.sendText(iOSPasswordTextBox, password);
        }
    }

    public String userNameAttribute() {
        if (isAndroid()) {
            return Action.getAttribute(userNameTextBox, "value");
        } else {
            return Action.getAttribute(iOSUserNameTextBox, "value");
        }
    }

    public String passwordAttribute() {
        if (isAndroid()) {
            return Action.getAttribute(passwordTextBox, "value");
        } else {
            return Action.getAttribute(iOSPasswordTextBox, "value");
        }
    }

    public void clickOnShowPassword() {
        if (isAndroid()) {
            Action.click(showPasswordButton);
        }
        // No show password button for iOS, do nothing
    }

    public void enterIncorrectUserName() {
        if (isAndroid()) {
            Action.sendText(userNameTextBox, Action.generateRandomStringInRange());
        } else {
            Action.sendText(iOSUserNameTextBox, Action.generateRandomStringInRange());
        }
    }

    public void enterIncorrectPassword() {
        if (isAndroid()) {
            Action.sendText(passwordTextBox, Action.generateRandomStringInRange());
        } else {
            Action.sendText(iOSPasswordTextBox, Action.generateRandomStringInRange());
        }
    }

    public boolean isInvalidCredentialAlertDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(inValidCredentialsAlert);
        } else {
            return Action.isDisplayed(iOSInvalidCredentialsAlert);
        }
    }

    public String invalidCredentialGetText() {
        if (isAndroid()) {
            return Action.getText(inValidCredentialsAlert);
        } else {
            return Action.getText(iOSInvalidCredentialsAlert);
        }
    }

    public boolean isalertMessageDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(alertMessage);
        } else {
            return Action.isDisplayed(iOSAlertMessage);
        }
    }

    public String alertMessageGetText() {
        if (isAndroid()) {
            return Action.getText(alertMessage);
        } else {
            return Action.getText(iOSAlertMessage);
        }
    }

    public boolean isOkButtonDisplayed() {
        if (isAndroid()) {
            return Action.isDisplayed(okButton);
        } else {
            return Action.isDisplayed(iOSOkButton);
        }
    }

    public void clickOnOkButton() {
        if (isAndroid()) {
            Action.click(okButton);
        } else {
            Action.click(iOSOkButton);
        }
    }

    public HomePage navigateToHomePage() throws MalformedURLException {
        String username = "Test";
        String password = "Test@123";
        if (isAndroid()) {
            Action.sendText(userNameTextBox, username);
            Action.sendText(passwordTextBox, password);
            clickOnLoginButton();
            return new HomePage(DriverManager.getDriver());
        } else {
            Action.sendText(iOSUserNameTextBox, username);
            Action.sendText(iOSPasswordTextBox, password);
            clickOnLoginButton();
            return new HomePage(DriverManager.getDriver());
        }
    }

}

