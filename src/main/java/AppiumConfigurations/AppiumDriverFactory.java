package AppiumConfigurations;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


import java.io.IOException;


import static AppiumConfigurations.AppiumServer.ConfigureAppium;
import static AppiumConfigurations.AppiumServer.getAppiumServerUrl;


public class AppiumDriverFactory{
    public static AppiumDriver driver;

    public static AppiumDriver initialiseDriver() throws IOException {
        ConfigureAppium();
        String platform = System.getProperty("platform", "android").toLowerCase();
        switch (platform) {
            case "android":
                // Set up capabilities for Android
                driver = new AndroidDriver(getAppiumServerUrl(), CapabilityReader.androidCapabilities());
                DriverManager.setDriver(driver);
                break;
            case "ios":
                // Set up capabilities for iOS
                driver = new IOSDriver(getAppiumServerUrl(), CapabilityReader.iosCapabilites());
                DriverManager.setDriver(driver);
                break;
            default:
                throw new IllegalArgumentException("Invalid platform: " + platform);
        }
         return DriverManager.getDriver();
    }
    public static boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }
}

