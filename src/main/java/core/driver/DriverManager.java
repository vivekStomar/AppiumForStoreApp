package core.driver;

import constants.Target;
import exceptions.PlatformUnavailableException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import static core.utils.CapabilitiesHelper.readAndMakeCapabilities;

public class DriverManager {
    private static AppiumDriver driver;
    String APPIUM_SERVER_URL = "http://0.0.0.0:4723/wd/hub";

    public AppiumDriver getInstance(Target target) throws IOException, PlatformUnavailableException {
        System.out.println("Getting instance of: " + target.name());
        switch (target) {
            case ANDROID:
                return getAndroidDriver();
            case IOS:
                return getIOSDriver();
            default:
                throw new PlatformUnavailableException("Please provide supported target");
        }
    }

    private AppiumDriver getAndroidDriver() throws IOException {
        HashMap map = readAndMakeCapabilities("android-caps.json");
        return getDriver(map);
    }

    private AppiumDriver getIOSDriver() throws IOException {
        HashMap map = readAndMakeCapabilities("ios-caps.json");
        return getDriver(map);
    }

    private AppiumDriver getDriver(HashMap map) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(map);

        try {
            driver = new AppiumDriver(
                    new URL(APPIUM_SERVER_URL), desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }
}


