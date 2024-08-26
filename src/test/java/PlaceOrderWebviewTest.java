import org.testng.annotations.Test;

import constants.TestGroups;
import steps.CartSteps;
import steps.LoginSteps;
import steps.PlaceOrderWebViewSteps;
import steps.ProductsSteps;

@Test(groups = { TestGroups.PLACE_ORDER })
public class PlaceOrderWebviewTest extends BaseTest {

     /*
     * Scenario:
     * validate if user is able to place the order.
     * 
     * To-Do TBD random no-of-items and item at random postion by running same test case.
     */
    @Test(groups = { "testPlaceOrderWebView" })
    public void testPlaceOrderWebView() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);
        ProductsSteps.assertCartItemForCount(driver, "1");

        ProductsSteps.clickOnCartButton(driver);
        CartSteps.assertCartScreenIsVisible(driver);

        CartSteps.clickOnCompleteOrderButton(driver);

        PlaceOrderWebViewSteps.placeOrderAtWebView(driver);

        LoginSteps.assetLoginScreenVisible(driver);

        LoginSteps.assertDoubleBackPressToExit(driver);
    }

     /*
     * Scenario:
     * validate back button navigation after pressing takes to previous screen.
     * i.e. "Cart" screen.
     */
    @Test(groups = { "testNavigationBackButton" })
    public void testNavigationBackButton(){
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);
        ProductsSteps.assertCartItemForCount(driver, "1");

        ProductsSteps.clickOnCartButton(driver);
        CartSteps.assertCartScreenIsVisible(driver);

        CartSteps.clickOnCompleteOrderButton(driver);

        PlaceOrderWebViewSteps.placeOrderAtWebView(driver);

        PlaceOrderWebViewSteps.clickNavigationBackButton(driver);
        LoginSteps.assetLoginScreenVisible(driver);
    }
}
