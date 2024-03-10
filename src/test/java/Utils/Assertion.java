package Utils;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class Assertion extends BasePage {
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);


    public static void assertTrue(String assertErrorMessage, boolean conditionToVerify, String conditionLogMessage) {
        LOGGER.info("Verifying if {} is true", conditionLogMessage);
        Assert.assertTrue(conditionToVerify, assertErrorMessage);
        LOGGER.info("Validation successful for {} ", conditionLogMessage);
    }

    public static void assertFalse(String assertErrorMessage, boolean conditionToVerify, String conditionLogMessage) {
        LOGGER.info("Verifying if {} is false", conditionLogMessage);
        Assert.assertFalse(conditionToVerify, assertErrorMessage);
        LOGGER.info("Validation successful for {}", conditionLogMessage);
    }

    public static void assertEquals(String expectedTextMessage, String actualTextMessage, String assertErrorMessage)
    {
        LOGGER.info("Verifying if the Actual text appearing is equal to the Expected text");
        Assert.assertEquals(actualTextMessage, expectedTextMessage, assertErrorMessage);
        LOGGER.info("Validation successful: Expected text is appearing");
    }

    public static void assertNullField(String assertErrorMessage, Object field) {
        LOGGER.info("Verifying if the field is Null");
        Assert.assertNull(assertErrorMessage, String.valueOf(field));
        LOGGER.info("Validation successful: The field is not Null.");
    }
    public static void assertNotNullField(String message, Object field) {
        LOGGER.info("Verifying if the field is not Null");
        Assert.assertNotNull(message, String.valueOf(field));
        LOGGER.info("Validation successful: The field is not Null.");
    }
}