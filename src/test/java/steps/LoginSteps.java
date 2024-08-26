package steps;

import org.testng.Assert;

import core.screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import screens.store.launch.LoginScreen;

public class LoginSteps {

    public static void clickOnLetsShopButton(AppiumDriver driver) {
        //To-Do improve the way we are accessing LoginScreen multiple times for different ops
        new LoginScreen(driver)
                .clickOnLetsShopButton();
    }

    public static void enterUserName(AppiumDriver driver, String userName) {
        new LoginScreen(driver)
                .enterName(userName);
    }

    public static void assetLoginScreenVisible(AppiumDriver driver) {
        String currentScreen = BaseScreen.getCurrentScreen(driver);
        Assert.assertEquals(currentScreen, "General Store");
    }

    public static void assetToastMessageForEmptyNameIsShown(AppiumDriver driver) {
        String toastMessage = new LoginScreen(driver)
                .clickOnLetsShopButton()
                .getToastMessage();
        Assert.assertEquals(toastMessage, "Please enter your name");
    }

    public static void assertDoubleBackPressToExit(AppiumDriver driver) {
        driver.navigate().back();
        String toastMessage = new LoginScreen(driver).getToastMessage();
        System.out.println("= " + toastMessage);
        Assert.assertEquals(toastMessage, "Press BACK again to exit");
        driver.navigate().back();
    }
}
