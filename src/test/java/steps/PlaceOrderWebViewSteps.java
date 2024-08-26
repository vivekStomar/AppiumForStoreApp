package steps;

import java.util.Set;

import io.appium.java_client.AppiumDriver;
import screens.store.order.PlaceOrderWebViewScreen;

public class PlaceOrderWebViewSteps {

    public static void placeOrderAtWebView(AppiumDriver driver) {

        Set handles = null;
        do {
            handles = driver.getContextHandles();
        } while (handles.size() != 2);

        driver.context("WEBVIEW_com.androidsample.generalstore");
        new PlaceOrderWebViewScreen(driver).clickOnSignInButton();
        driver.context("NATIVE_APP");
        driver.navigate().back();
    }


    public static void clickNavigationBackButton(AppiumDriver driver) {
        driver.navigate().back();
    }

}