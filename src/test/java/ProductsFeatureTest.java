import constants.TestGroups;
import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductsSteps;

import org.testng.annotations.Test;

@Test(groups = { TestGroups.PRODUCTS })
public class ProductsFeatureTest extends BaseTest {

     /*
     * Scenario:
     * validate if required UI elements are visible
     */
    // public void testProductScreenDetails(){
    //     //Cart button visible
    //     //product list visible
    //     //screen title visible
    // }

     /*
     * Scenario:
     * validate cart count if no item been added to cart.
     */
    @Test(groups = { "testAddToCartCountWithoutAddToCart" })
    public void testAddToCartCountWithoutAddToCart() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.assertCartItemForCount(driver, null);
    }

     /*
     * Scenario:
     * validate if requred details of each product are visible
     * 
     * * To-Do TBD validate multiple items more than one by running same test case multiple times.
     */
    @Test(groups = { "testProductDetailsAreVisibleForAllProducts" })
    public void testProductDetailsAreVisibleForFirstProduct() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.assertProductImageIsVisibleByPosition(driver, 1);
        ProductsSteps.assertProductNameIsVisibleByPosition(driver, 1);
        ProductsSteps.assertProductPriceIsVisibleByPosition(driver, 1);
        ProductsSteps.assertAddToCartButtonForProductIsVisibleByPosition(driver, 1);
    }

     /*
     * Scenario:
     * validate if able to add single product to cart.
     * 
     * To-Do TBD validate multiple items more than one by running same test case multiple times.
     */
    @Test(groups = { "testSingleProductAddToCart" })
    public void testSingleProductAddToCart() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);

        ProductsSteps.assertCartItemForCount(driver, "1");
    }

     /*
     * Scenario:
     * validate if multiple items been able to be added to cart
     * and cart item count update against added items.
     * 
     * To-Do TBD currently it's only 1st and 2nd should be random. 
     * random no-of-items and random items.
     */
    @Test(groups = { "testFirstTwoProductAddToCart" })
    public void testFirstTwoProductAddToCart() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);
        ProductsSteps.addToCartByPosition(driver, 2);

        ProductsSteps.assertCartItemForCount(driver, "2");
    }

     /*
     * Scenario:
     * validate if after adding product to Cart
     * and clicking on Cart button takes to Cart Screen.
     * 
     * To-Do TBD random no-of-items and item at random position.
     */
    @Test(groups = { "testCartButtonClickToCartScreen" })
    public void testCartButtonClickToCartScreen() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);
        ProductsSteps.assertCartItemForCount(driver, "1");

        ProductsSteps.clickOnCartButton(driver);
        CartSteps.assertCartScreenIsVisible(driver);
    }

    /*
     * Scenario:
     * validate total number of products available to display
     * 
     * Source of truth needs to be identified to validate against.
     */
    // total number of product available

    /*
     * Scenario:
     * validate product details are present for every product available on display.
     * 
     * Source of truth needs to be identified to validate against.
     */
    // validate product price and name and image and addtocart button visible for
    // all products

    /*
     * Scenario:
     * validate validate back button navigation take user to previous screen
     * i.e. Login Screen.
     */
    // public void testNavigationBackButton(){
    //     //back button should take to Login Screen
    // }

    // android.support.v7.widget.RecyclerView[@resource-id="com.androidsample.generalstore:id/rvProductList"]
}
