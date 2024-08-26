package store.screen.launch;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.screen.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public LoginScreen clickOnLetsShopButton() {
         // By byButtonLetsShop = By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]");
        By byButtonLetsShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
        waitForElementToBePresent(byButtonLetsShop);
        WebElement buttonLetsShop = findElement(byButtonLetsShop);
        click(buttonLetsShop);
        return this;
    }
    
    public LoginScreen enterName(String name){
        By byEditText = By.id("com.androidsample.generalstore:id/nameField");
        waitForElementToBePresent(byEditText);
        WebElement editText = findElement(byEditText);
        typeText(editText, name);
        return this;
    }

    //gender selection
    //country selection

}
