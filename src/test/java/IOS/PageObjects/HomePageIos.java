package IOS.PageObjects;

import Android.PageObjects.ScreenOne;
import Android.PageObjects.ScreenTwo;
import Android.TestCases.ScreenTwoTest;
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

public class HomePageIos  extends BasePage {

    public String enteredTaskName;
    public HomePageIos(AppiumDriver driver) throws MalformedURLException {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Home\"])[6]")
    private WebElement homePageHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Enter a task\"`]")
    private WebElement enterTaskTextBox;

    @iOSXCUITFindBy(accessibility = "Add Task")
    private WebElement addTaskButton;

    @iOSXCUITFindBy(accessibility = "Go to Screen 1")
    private WebElement goToScreen1;

    @iOSXCUITFindBy(accessibility = "Go to Screen 2")
    private WebElement goToScreen2;

    @iOSXCUITFindBy(accessibility = "Done")
    private WebElement doneButton;

    @iOSXCUITFindBy(accessibility = "Delete")
    private WebElement deleteButton;

    @iOSXCUITFindBy(accessibility = "Undo")
    private WebElement undoButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Task already exists\"`]")
    private WebElement taskExistsDisclaimer;

    @iOSXCUITFindBy(accessibility = "You cannot add a task with the same name\n")
    private WebElement disclaimerMessage;

    @iOSXCUITFindBy(accessibility="OK")
    private WebElement okButton;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='*']")
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

    public ScreenOneIos navigateToScreenOnePage() throws MalformedURLException {
        Action.waitForVisibility(goToScreen1);
        clickGoToScreen1Button();
        return new ScreenOneIos(DriverManager.getDriver());
    }

    public ScreenTwoIos navigateToScreenTwoPage() throws MalformedURLException {
        Action.waitForVisibility(goToScreen2);
        clickGoToScreen2Button();
        return new ScreenTwoIos(DriverManager.getDriver());
    }
}

