package Android.PageObjects;

import AppiumConfigurations.DriverManager;
import Base.BasePage;
import Utils.Action;
import io.appium.java_client.AppiumDriver;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.rmi.activation.ActivationID;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Username')]")
    private WebElement userNameTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Password')]")
    private WebElement passwordTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'LOGIN')]")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'')]")
    private WebElement showPasswordButton;

    @AndroidFindBy(id="android:id/alertTitle")
    private WebElement inValidCredentialsAlert;

    @AndroidFindBy(id="android:id/message")
    private WebElement alertMessage;

    @AndroidFindBy(id="android:id/button1")
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

    public boolean isShowPasswordButtonDisplayed(){
        return Action.isDisplayed(showPasswordButton);
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

    public void clickOnShowPassword(){
        Action.click(showPasswordButton);
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

    public HomePage navigateToHomePage() throws MalformedURLException {
        Action.sendText(userNameTextBox,"Test");
        Action.sendText(passwordTextBox,"Test@123");
        clickOnLoginButton();
        return new HomePage(DriverManager.getDriver());
    }
}

