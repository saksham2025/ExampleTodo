package IOS.PageObjects;

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

public class ScreenOneIos extends BasePage {

    public ScreenOneIos(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Screen1\"`][2]")
    private WebElement screenOneHeader;

    @iOSXCUITFindBy(accessibility = "Add Patient Details")
    private WebElement addPatientDetailsText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Name\"`]")
    private WebElement nameTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Contact\"`]")
    private WebElement contactTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Age\"`]")
    private WebElement ageTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Height (cm)\"`]")
    private WebElement heightTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Weight (kg)\"`]\n")
    private WebElement weightTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Blood Pressure\"`]\n")
    private WebElement bloodPressureTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Sugar Level\"`]")
    private WebElement sugarLevelTextBox;

    @iOSXCUITFindBy(accessibility="Add Patient")
    private WebElement addPatientButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Patient List\"`]")
    private WebElement patientListText;

    @AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Patient List\"]/following-sibling::XCUIElementTypeOther")
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
