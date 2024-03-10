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

public class ScreenOne extends BasePage{

    public ScreenOne(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@text,'Screen1')]")
    private WebElement screenOneHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Add Patient Details')]")
    private WebElement addPatientDetailsText;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Name')]")
    private WebElement nameTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Contact')]")
    private WebElement contactTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Age')]")
    private WebElement ageTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Height (cm)')]")
    private WebElement heightTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Weight (kg)')]")
    private WebElement weightTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Blood Pressure')]")
    private WebElement bloodPressureTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Sugar Level')]")
    private WebElement sugarLevelTextBox;

    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"ADD PATIENT\"]/android.widget.TextView")
    private WebElement addPatientButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Patient List')]")
    private WebElement patientListText;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement patientAddedDetailsSection;

    public void fillPatientDetails(String name, String contact, String age, String height, String weight, String bloodPressure, String sugarLevel) {
        Action.sendText(nameTextBox, name);
        Action.sendText(contactTextBox, contact);
        Action.sendText(ageTextBox, age);
        Action.sendText(heightTextBox, height);
        Action.sendText( weightTextBox, weight);
        Action.sendText( bloodPressureTextBox, bloodPressure);
        Action.sendText(sugarLevelTextBox, sugarLevel);
        DriverManager.getDriver().navigate().back();
    }

    public boolean isScreenOneheaderDisplayed(){
        return Action.isDisplayed(screenOneHeader);
    }

    public boolean isaddPatientDetailsDisplayed(){
        return Action.isDisplayed(addPatientDetailsText);
    }

    public boolean isPatientListTextDisplayed(){
        return Action.isDisplayed(patientListText);
    }

    public boolean isAddPatientButtonEnabled(){
        return Action.isEnabled(addPatientButton);
    }

    public void clickOnAddPatientButton(){
        Action.click(addPatientButton);
        System.out.println("Clicked on button ");
        Action.click(addPatientButton);
        System.out.println("Clicked on button 2");
    }

    public boolean isPatientAddedDetailsSectionDisplayed(){
        return Action.isDisplayed(patientAddedDetailsSection);
    }

}


