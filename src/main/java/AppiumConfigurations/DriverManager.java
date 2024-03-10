package AppiumConfigurations;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> dr=new ThreadLocal<>();
    public static AppiumDriver getDriver() {
        return dr.get();
    }
    public static void setDriver(AppiumDriver driver) {
        dr.set(driver);
    }
}