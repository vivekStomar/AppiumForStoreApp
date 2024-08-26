import constants.TestGroups;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductsSteps;

@Test(groups = { TestGroups.CART })
public class CartFeatureTest extends BaseTest {

     /*
     * Scenario:
     * validate if required UI elements are present on screen.
     * screen i.e. "Product" screen.
     */
    // public void testCartScreenDetails() {
    // title visible
    // Product list visible
    // total cart value visible
    // send me email checkbox visible
    // compete ordr button visible
    // term and condition visible
    // }

     /*
     * Scenario:
     * validate total cart value against item value added to cart
     * for single item in the cart
     *
     * To-Do TBD random no-of-items and item at random position by running same test case multiple times.
     */
    @Test(groups = { "testCartTotalValueForTotalOfEachItemValueInTheCart" })
    public void testCartTotalValueForTotalOfEachItemValueInTheCart() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);
        ProductsSteps.assertCartItemForCount(driver, "1");

        ProductsSteps.clickOnCartButton(driver);
        CartSteps.assertCartScreenIsVisible(driver);

        String totalCartValue = CartSteps.getCartTotalValue(driver);
        String firstProductPrice = CartSteps.getProductPriceByPosition(driver, 1);
        Assert.assertEquals(totalCartValue.replaceAll("\\s+", ""), firstProductPrice);
    }

     /*
     * Scenario:
     * validate if after addeing items to Cart and Clicking "Complete Order" button
     * takes to next screen i.e. "PlaceOrderWebView" screen.
     * 
     * To-Do TBD random no-of-items and item at random position by running same test case.
     */
    @Test(groups = { "testCompletePurchaseAtCart" })
    public void testCompletePurchaseAtCart() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);

        ProductsSteps.addToCartByPosition(driver, 1);
        ProductsSteps.assertCartItemForCount(driver, "1");

        ProductsSteps.clickOnCartButton(driver);
        CartSteps.assertCartScreenIsVisible(driver);

        CartSteps.clickOnCompleteOrderButton(driver);
    }

     /*
     * Scenario:
     * validate if pressing back button takes to previous screen
     * i.e. "Product" screen.
     */
    public void testNavigationBackButton() {
        // back button should take to Product Screen
    }

    // driver.activateApp("com.android.chrome");
    // driver.activateApp("io.appium.android.apis");

    // By views = By.xpath("//android.widget.TextView[@content-desc=\"Views\"]");
    // driver.findElement(views).click();

    // driver.findElementByAndroidUIAutomator().click();
    // driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new
    // UiSelector().scrollable(true).instance(0)).scrollIntoView(new
    // UiSelector().textContains(\"WebView\").instance(0))")).click();

    // System.out.println("<><><><><" + driver.getContextHandles()); // getting
    // available contexts
    // driver.context("WEBVIEW_com.androidsample.generalstore"); // switching to
    // webview_chorome content
    // driver.context("WEBVIEW_io.appium.android.apis");
    // Set handles = driver.getContextHandles();
    // String webContext = new ArrayList<String>(handles).get(2);
    // System.out.println(webContext);
    // driver.context("WEBVIEW_io.appium.android.apis");

    // By input =
    // By.xpath("//android.webkit.WebView[@resource-id=\"io.appium.android.apis:id/wv1\"]");
    // driver.findElement(input).click();

    // CartSteps.waitForBrowser(driver);

    //
    // WebElement signinButton =
    // driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
    // signinButton.click();

    // driver.findElement(By.xpath("//input[@type=‘email’]")).sendKeys("abcd@gmail.com");
    // driver.findElement(By.xpath("//input[@type=‘password’]")).sendKeys("abcd@1234");
    // driver.findElement(By.id("signInSubmit")).click();
    // driver.context("NATIVE_APP"); // setting context to native app
    // driver.activateApp("com.androidsample.generalstore"); // activating the
    // native app
}
