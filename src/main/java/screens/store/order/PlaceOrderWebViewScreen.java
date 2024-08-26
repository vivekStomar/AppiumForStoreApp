package screens.store.order;

import org.openqa.selenium.By;

import core.screen.BaseScreen;
import io.appium.java_client.AppiumDriver;

public class PlaceOrderWebViewScreen extends BaseScreen {

    public PlaceOrderWebViewScreen(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton() {
        By signInButton = By.xpath("//div[@id=\"gb\"]/div/div[1]/a");
        waitForElementToBePresent(signInButton);
        findElement(signInButton).click();
    }
}
