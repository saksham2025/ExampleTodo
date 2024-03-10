package Base;

import AppiumConfigurations.AppiumDriverFactory;
import AppiumConfigurations.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;

public class BasePage extends AppiumDriverFactory {

    protected static Logger logger = LogManager.getLogger(BasePage.class);

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver = DriverManager.getDriver();
        if (driver != null) {
            try {
                driver.quit();
                logger.info("driver is removed");
            } catch (Exception e) {
                logger.warn("Error closing Driver: {}", e.getMessage());
            }
        }
    }
}