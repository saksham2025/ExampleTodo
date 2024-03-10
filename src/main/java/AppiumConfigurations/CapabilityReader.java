package AppiumConfigurations;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
public class CapabilityReader {

    public static DesiredCapabilities androidCapabilities() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("Inside capabilities");
        Properties prop = new Properties();
        InputStream input = CapabilityReader.class.getClassLoader().getResourceAsStream("local.properties");
        prop.load(input);
        capabilities.setCapability("udid", prop.getProperty("deviceUdid"));
        capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
        capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
        capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
        capabilities.setCapability("platformName", prop.getProperty("platformName"));
        capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
        capabilities.setCapability("autoGrantPermissions", true);

        return capabilities;
    }

    public static DesiredCapabilities iosCapabilites() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> options = new HashMap<String, Object>();
        Properties prop = new Properties();
        prop.load(CapabilityReader.class.getClassLoader().getResourceAsStream("ios.properties"));
        String buildName = prop.getProperty("build", "IOS");
        options.put("deviceName",prop.getProperty("deviceName"));
        options.put("platformVersion", prop.getProperty("platformVersionIos"));
        options.put("app","app");
        options.put("autoAcceptAlerts", prop.getProperty("autoAcceptAlerts"));
        System.out.println(options);
        return capabilities;
    }
}

