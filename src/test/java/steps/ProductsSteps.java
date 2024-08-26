package steps;

import org.testng.Assert;

import core.screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import screens.store.products.ProductsScreen;

public class ProductsSteps {

    public static void clickOnCartButton(AppiumDriver driver){
        new ProductsScreen(driver).clickOnCartButton();
    }

    public static void assertCartItemCountNotVisible(AppiumDriver driver, String count){
        String actualCount= new ProductsScreen(driver).getCartItmeCount();
        Assert.assertNull(actualCount, count);
    }

    public static void assertProductImageIsVisibleByPosition(AppiumDriver driver, int position){
        ProductsScreen productsScreen = new ProductsScreen(driver);
        boolean isDisplayed = productsScreen.isProductImageVisibleByPosition(position);
        Assert.assertEquals(true, isDisplayed);
    }

    public static void assertProductNameIsVisibleByPosition(AppiumDriver driver, int position){
        ProductsScreen productsScreen = new ProductsScreen(driver);
        String productNameAtFifthPosition = productsScreen.getProductNameByPosition(position);
        Assert.assertNotNull(productNameAtFifthPosition);
    }

    public static void assertProductPriceIsVisibleByPosition(AppiumDriver driver, int position){
        ProductsScreen productsScreen = new ProductsScreen(driver);
        productsScreen.getProductPriceByPosition(position);
    }

    public static void assertAddToCartButtonForProductIsVisibleByPosition(AppiumDriver driver, int position){
        ProductsScreen productsScreen = new ProductsScreen(driver);
        boolean isDisplayed = productsScreen.isAddToCartButtonForProductVisibleByPosition(position);
        Assert.assertEquals(true, isDisplayed);
    }

    public static void addToCartByPosition(AppiumDriver driver, int position) {
        new ProductsScreen(driver)
                .clickOnAddtoCartButtonByPosition(position);
    }

    public static void assertCartItemForCount(AppiumDriver driver, String count){
        String actualCount= new ProductsScreen(driver).getCartItmeCount();
        Assert.assertEquals(actualCount, count);
    }

    public static void assertProductNameIsVisibleByPosition1(AppiumDriver driver, int position) {
        String productNameAtFifthPosition = new ProductsScreen(driver).getProductNameByPosition(position);
        Assert.assertNotNull(productNameAtFifthPosition);
    }

    public static void assertCurrentScreenIsProductScreen(AppiumDriver driver) {
        String nextScreenName = BaseScreen.getCurrentScreen(driver);
        Assert.assertEquals(nextScreenName, "Products");
    }
}
