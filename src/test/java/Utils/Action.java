package Utils;

import AppiumConfigurations.DriverManager;
import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;
import java.util.*;

public class Action extends BasePage {
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);


    public static WebElement fluentWaitFindElement(final WebElement webElement, final int timeoutSeconds) {
        FluentWait<AppiumDriver> wait = new FluentWait<>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofSeconds(Constants.POLLING_DURATION_IN_MILLIS)).ignoring(NoSuchElementException.class);
        return wait.until(wbDriver -> webElement);
    }

    public static <T> WebElement getElement(T elementAttr) {
        return fluentWaitFindElement((WebElement) elementAttr, Constants.TIME_OUT_SECONDS);
    }

    public static void waitForVisibility(WebElement mobileElement) {
        System.out.println("Waiting for visibility of element: " + mobileElement);
        fluentWaitFindElement((WebElement) mobileElement, Constants.TIME_OUT_SECONDS);
        System.out.println("Element is now visible: " + mobileElement);

    }

    public static void waitForClickable(WebElement mobileElement) {
        fluentWaitFindElement((WebElement) mobileElement, Constants.TIME_OUT_SECONDS);
        System.out.println("Element is now visible: " + mobileElement);
    }

    public static <T> boolean isDisplayed(T elementAttr) {
        WebElement element;
        try {
            element = getElement(elementAttr);
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            LOGGER.error("Unable to verify if element is displayed with following error message: " + e.getMessage());
            return false;
        }
    }

    public static <T> boolean isEnabled(T elementAttr) {
        WebElement mobileElement = getElement(elementAttr);
        try {
            return mobileElement.isEnabled();
        } catch (NoSuchElementException e) {
            LOGGER.error("Unable to verify if " + mobileElement.toString() + " was enabled with following error message: "
                    + e.getMessage());
            return false;
        }
    }

    public static <T> boolean isSelected(T elementAttr) {
        WebElement mobileElement = getElement(elementAttr);
        try {
            return mobileElement.isSelected();
        } catch (NoSuchElementException e) {
            LOGGER.error("Unable to verify if " + mobileElement.toString() + " was enabled with following error message: "
                    + e.getMessage());
            return false;
        }
    }

    public static <T> String getAttribute(T elementAttr , String attribute) {
        WebElement targetElement = getElement(elementAttr);
        try {
            waitForVisibility(targetElement);
            return targetElement.getAttribute(attribute);
        } catch (NoSuchElementException e) {
            LOGGER.error("Unable to get text from " + targetElement.toString() + " with following error message: "
                    + e.getMessage());
            return StringUtils.EMPTY;
        } catch (TimeoutException e) {
            LOGGER.error("Unable to find the element " + targetElement.toString()
                    + " on the screen with following error message: " + e.getMessage());
            return StringUtils.EMPTY;
        }
    }


    public static <T> String getText(T elementAttr) {
        WebElement targetElement = getElement(elementAttr);
        try {
            waitForVisibility(targetElement);
            return targetElement.getText();
        } catch (NoSuchElementException e) {
            LOGGER.error("Unable to get text from " + targetElement.toString() + " with following error message: "
                    + e.getMessage());
            return StringUtils.EMPTY;
        } catch (TimeoutException e) {
            LOGGER.error("Unable to find the element " + targetElement.toString()
                    + " on the screen with following error message: " + e.getMessage());
            return StringUtils.EMPTY;
        }
    }

    public static void click(WebElement element) {
        try {
            waitForVisibility(element);
            waitForClickable(element);
            element.click();
        } catch (Exception e) {
            LOGGER.error(
                    "Unable to click on " + element.toString() + " with following error message: " + e.getMessage());
        }
    }
    public static void scrollup() throws InterruptedException {
        LOGGER.info("scrolling up");
        Dimension dimension=DriverManager.getDriver().manage().window().getSize();
        int start_x=(int)(dimension.width*0.5);
        int start_y=(int)(dimension.height*0.70);

        int end_x=(int)(dimension.width*0.5);
        int end_y=(int)(dimension.height*0.1);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger,1);

        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),(int)start_x,(int)start_y));

        swipe.addAction(finger.createPointerDown(0));

        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),(int)end_x,(int)end_y));

        swipe.addAction(finger.createPointerUp(0));

        DriverManager.getDriver().perform(Arrays.asList(swipe));
    }

    public static <T> boolean sendText(T elementAttr, String text) {
        WebElement inputBox = getElement(elementAttr);

        //Some pages need us to click on the webelement before we enter text.
        //While we saw other pages don't allow clicking on the textbox.
        try {
            waitForVisibility(inputBox);
            inputBox.click();
            inputBox.clear();
        } catch (WebDriverException we) {
            LOGGER.info("Unable to click on " + inputBox.toString() + ". Proceeding to send text to it.");
        }
        try {
            inputBox.sendKeys(text);
            return true;
        } catch (NoSuchElementException e) {
            LOGGER.error("Unable to send the " + text + " into " + inputBox.toString()
                    + " with following error message: " + e.getMessage());
            return false;
        }
    }


    public static boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public static String generateRandomStringInRange() {
        Random random = new Random();
        int length = random.nextInt(4) + 7;
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

}
