package IOS.PageObjects;

import Base.BasePage;
import Utils.Action;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class ScreenTwoIos  extends BasePage {

    public ScreenTwoIos(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Screen2\"`][2]")
    private WebElement screenTwoHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Schedule Appointment\"`]")
    private WebElement scheduleAppointmentButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[1]")
    private WebElement sunday;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[2]")
    private WebElement monday;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[3]")
    private WebElement tuesday;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[4]")
    private WebElement wednesday;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[5]")
    private WebElement thursday;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[6]")
    private WebElement friday;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"undefined.header.dayNames\"`]/XCUIElementTypeStaticText[7]")
    private WebElement saturday;

    @iOSXCUITFindBy(accessibility="undefined.header")
    private WebElement monthYearHeaderTitle;

    @iOSXCUITFindBy(accessibility = "Upcoming Appointment")
    private WebElement upcomingAppointment;

    @iOSXCUITFindBy(accessibility= "undefined.day_2024-03-31")
    private WebElement dateSelection;

    public boolean isScreenTwoHeaderVisible(){
        return Action.isElementVisible(screenTwoHeader);
    }

    public boolean isSundayDisplayedOnCalendar(){
        return Action.isDisplayed(sunday);
    }

    public boolean isMondayDisplayedOnCalendar(){
        return Action.isDisplayed(monday);
    }

    public boolean isTuesdayDisplayedOnCalendar(){
        return Action.isDisplayed(tuesday);
    }

    public boolean isWednesdayDisplayedOnCalendar(){
        return Action.isDisplayed(wednesday);
    }

    public boolean isThursdayDisplayedOnCalendar(){
        return Action.isDisplayed(thursday);
    }

    public boolean isFridayDisplayedOnCalendar(){
        return Action.isDisplayed(friday);
    }

    public boolean isSaturdayDisplayedOnCalendar(){
        return Action.isDisplayed(saturday);
    }

    public boolean isMonthHeaderTitleVisible(){
        return Action.isElementVisible(monthYearHeaderTitle);
    }

    public boolean isUpcomingAppointmentTextDisplayed(){
        return Action.isDisplayed(upcomingAppointment);
    }

    public boolean isScheduleAppointmentButtonEnabled(){
        return Action.isEnabled(scheduleAppointmentButton);
    }

    public void clickOnScheduleAppointmentButton(){
        Action.click(scheduleAppointmentButton);
        Action.click(scheduleAppointmentButton);
    }

    public boolean isDateDisplayed(){
        return Action.isDisplayed(dateSelection);
    }

    public void clickOnDate(){
        Action.click(dateSelection);
        Action.click(dateSelection);
    }
}
