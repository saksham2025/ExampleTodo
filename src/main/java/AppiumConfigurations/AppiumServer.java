package AppiumConfigurations;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppiumServer {

    public static AppiumDriverLocalService service;

    public static void ConfigureAppium() throws IOException {
        Properties prop=new Properties();
        prop.load(CapabilityReader.class.getClassLoader().getResourceAsStream("local.properties"));
        service= new AppiumServiceBuilder().withAppiumJS(new File("fileLocation"))
                .withIPAddress("IPAddress").usingPort(4723).build();
    }
    public static URL getAppiumServerUrl() {
        try {
            Properties prop=new Properties();
            prop.load(CapabilityReader.class.getClassLoader().getResourceAsStream("local.properties"));
            System.out.println("Reached on getServer");
            return new URL("URL");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
