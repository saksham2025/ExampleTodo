package Android.PageObjects;

import AppiumConfigurations.DriverManager;
import Base.BasePage;
import Utils.Action;
import com.beust.ah.A;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class HomePage extends BasePage {

    public String enteredTaskName;
    public HomePage(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@text,'Home')]")
    private WebElement homePageHeader;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Enter a task')]")
    private WebElement enterTaskTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Add Task')]")
    private WebElement addTaskButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Go to Screen 1')]")
    private WebElement goToScreen1;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Go to Screen 2')]")
    private WebElement goToScreen2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Done\"]")
    private WebElement doneButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Delete\"]")
    private WebElement deleteButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Undo\"]")
    private WebElement undoButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Task already exists')]")
    private WebElement taskExistsDisclaimer;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'You cannot add a task with the same name')]")
    private WebElement disclaimerMessage;

    @AndroidFindBy(id="android:id/button1")
    private WebElement okButton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
    private WebElement taskName;

    public boolean isHomePageHeaderDisplayed(){
        return Action.isDisplayed(homePageHeader);
    }

    public String getHomePageHeaderText(){
        return Action.getText(homePageHeader);
    }

    public boolean enterTaskTextBoxDisplayed(){
        return Action.isDisplayed(enterTaskTextBox);
    }

    public String enterTaskDescription(String name){
        Action.sendText(enterTaskTextBox,name);
        enteredTaskName=name;
        DriverManager.getDriver().navigate().back();
        return name;
    }

    public boolean isAddTaskButtonDisplayed(){
        return Action.isDisplayed(addTaskButton);
    }

    public void clickAddTaskButton(){
        Action.click(addTaskButton);
    }

    public boolean isGoToScreenOneDisplayed(){
        return Action.isDisplayed(goToScreen1);
    }

    public void clickGoToScreen1Button(){
        Action.click(goToScreen1);
    }
    public void clickGoToScreen2Button(){
        Action.click(goToScreen2);
    }

    public boolean isGoToScreenTwoDisplayed(){
        return Action.isDisplayed(goToScreen2);
    }

    public boolean isGoToScreenTwoButtonEnabled(){
        return Action.isEnabled(goToScreen2);
    }
    public boolean isGoToScreenOneButtonEnabled(){
        return Action.isEnabled(goToScreen2);
    }

    public boolean isDoneButtonDisplayed(){
        return Action.isDisplayed(doneButton);
    }

    public boolean isDoneButtonEnabled(){
        return Action.isEnabled(doneButton);
    }

    public void clickOnDoneButton(){
        Action.click(doneButton);
        System.out.println("clicked on done button 1");
        Action.click(doneButton);
        System.out.println("clicked on done button 2");
    }

    public void clickOnDeleteButton(){
        Action.click(deleteButton);
        System.out.println("Clicked on delete successfully");
        Action.click(deleteButton);
        System.out.println("Clicked on delete successfully twice");
    }

    public boolean isUndoButtonVisible(){
        System.out.println("Inside is displayed Undo");
        return Action.isElementVisible(undoButton);
    }

    public void clickOnUndoButton(){
        Action.click(undoButton);
        System.out.println("Clicked on Undo");
    }


    public boolean isAddedTaskDisplayed(){
        Action.waitForVisibility(taskName);
        return Action.isDisplayed(taskName);
    }
    public String getTaskText(){
        return Action.getText(taskName);
    }

    public void addTasksInLoop(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            String randomTask = Action.generateRandomStringInRange(); // Change the length as needed
            enterTaskDescription(randomTask);
            clickAddTaskButton();
        }
    }

    public String getEnteredTaskName(){
        return enteredTaskName;
    }

    public ScreenOne navigateToScreenOnePage() throws MalformedURLException {
        Action.waitForVisibility(goToScreen1);
        clickGoToScreen1Button();
        return new ScreenOne(DriverManager.getDriver());
    }

    public ScreenTwo navigateToScreenTwoPage() throws MalformedURLException {
        Action.waitForVisibility(goToScreen2);
        clickGoToScreen2Button();
        return new ScreenTwo(DriverManager.getDriver());
    }
}
//
//    You have to validate, you are successfully navigating in app or not
//        Verify all elements on Home Screen
//        Verify add task functionality on Home Screen
//        Verify added task
//        Verify Done task functionality
//        Verify Delete task functionality
//        Go to the screen1
//        Add all details on screen 1 and save
//        Navigate on screen2 and verify all elements
//        Verify schedule appointment functionality