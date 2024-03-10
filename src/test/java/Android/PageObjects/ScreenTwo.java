package Android.PageObjects;

import Base.BasePage;
import Utils.Action;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class ScreenTwo extends BasePage {

    public ScreenTwo(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@text,'Screen2')]")
    private WebElement screenTwoHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'SCHEDULE APPOINTMENT')]")
    private WebElement scheduleAppointmentButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    private List<WebElement> calendarDays;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Sun')]")
    private WebElement sunday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Mon')]")
    private WebElement monday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Tue')]")
    private WebElement tuesday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Wed')]")
    private WebElement wednesday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Thu')]")
    private WebElement thursday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Fri')]")
    private WebElement friday;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Sat')]")
    private WebElement saturday;

    @AndroidFindBy(id="undefined.header.title")
    private WebElement monthYearHeaderTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Upcoming Appointment')]")
    private WebElement upcomingAppointment;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Enter appointment details')]")
    private WebElement enterAppointmentDetailsTextBox;

    @AndroidFindBy(xpath="//android.view.ViewGroup[3]/android.widget.TextView[2]")
    private WebElement appointmentDate;

    @AndroidFindBy(id="undefined.header.rightArrow")
    private WebElement rightArrowSeekbar;

    @AndroidFindBy(id="undefined.header.leftArrow")
    private WebElement leftArrowSeekbar;


    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\" Sunday 31 March 2024 \"]")
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

    public boolean isCalendarDaysDisplayed(){
        return Action.isDisplayed(calendarDays);
    }

    public boolean isUpcomingAppointmentTextDisplayed(){
        return Action.isDisplayed(upcomingAppointment);
    }

    public void enterAppointmentDetailsTextBox(String details){
        Action.sendText(enterAppointmentDetailsTextBox,details);
    }

    public boolean selectedAppointmentDateDisplayed(){
       return Action.isDisplayed(appointmentDate);
    }


    public boolean isScheduleAppointmentButtonEnabled(){
        return Action.isEnabled(scheduleAppointmentButton);
    }

    public void clickOnScheduleAppointmentButton(){
        Action.click(scheduleAppointmentButton);
        Action.click(scheduleAppointmentButton);
    }

    public boolean isRightArrowDisplayed(){
        return Action.isDisplayed(rightArrowSeekbar);
    }

    public void clickOnRightArrow(){
        Action.click(rightArrowSeekbar);
        Action.click(rightArrowSeekbar);
    }

    public boolean isLeftArrowDisplayed(){
        return Action.isDisplayed(leftArrowSeekbar);
    }


    public boolean isDateDisplayed(){
        return Action.isDisplayed(dateSelection);
    }

    public void clickOnDate(){
        Action.click(dateSelection);
        Action.click(dateSelection);
    }

}
