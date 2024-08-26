package steps;

import org.testng.Assert;

import core.screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import screens.store.cart.CartScreen;

public class CartSteps {

    public static String getProductPriceByPosition(AppiumDriver driver, int position){
        return new CartScreen(driver).getProductPriceByPosition(position);
    }
    
    public static String getCartTotalValue(AppiumDriver driver){
        return new CartScreen(driver).getCartTotalValue();
    }

    public static void assertCartScreenIsVisible(AppiumDriver driver){
        String nextScreenName = BaseScreen.getCurrentScreen(driver);
        Assert.assertEquals(nextScreenName, "Cart");
    } 

    public static void clickOnCompleteOrderButton(AppiumDriver driver){
         new CartScreen(driver).clickOnCompleteOrderButton();
    }

}
