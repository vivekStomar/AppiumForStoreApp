package screens.store.products;

import io.appium.java_client.AppiumDriver;
// import io.appium.java_client.MobileBy;
// import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.screen.BaseScreen;

public class ProductsScreen extends BaseScreen {

    public ProductsScreen(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnCartButton() {
        By byCartButton = By.xpath(
                "//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]");
        click(findElement(byCartButton));
    }

    public String getCartItmeCount() {

        By byCartItemCount = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/counterText\"]");

        WebElement cartItemCount = findElement(byCartItemCount);

        return cartItemCount == null ? null : getText(cartItemCount);
    }

    public String getProductNameByPosition(int position) {
        By byProductNameText = By
                .xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]");
        List<WebElement> productNameTextList = findElements(byProductNameText);
        WebElement productName = productNameTextList.get(position - 1);

        return productName.getText();
    }

    public String getProductPriceByPosition(int position) {
        By byProductPriceText = By
                .xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]");
        List<WebElement> productPriceTextList = findElements(byProductPriceText);
        return getText(productPriceTextList.get(position - 1));
    }

    public boolean isProductImageVisibleByPosition(int position) {
        // (//android.widget.ImageView[@resource-id="com.androidsample.generalstore:id/productImage"])[1]
        By byProductImage = By.xpath(String.format(
                "(//android.widget.ImageView[@resource-id=\"com.androidsample.generalstore:id/productImage\"])[%1$s]",
                position));
        WebElement productImage = findElement(byProductImage);
        return productImage == null ? false : productImage.isDisplayed();
    }

    public boolean isAddToCartButtonForProductVisibleByPosition(int position) {
        By byAddCartButton = By.xpath(String.format(
                "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[%1$s]",
                position));
        WebElement addtoCartButton = findElement(byAddCartButton);
        return addtoCartButton == null ? false : addtoCartButton.isDisplayed();
    }

    public ProductsScreen clickOnAddtoCartButtonByPosition(int position) {
        By byAddCartButton = By.xpath(String.format(
                "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[%1$s]",
                position));
        WebElement addCartButton = findElement(byAddCartButton);

        // while(addCartButton==null){
        // swipeVertical(driver);
        // }

        click(addCartButton);

        return this;
    }

    // public static void swipeVertical(AppiumDriver driver) {
    // TouchAction action = new TouchAction(driver);
    // Dimension size = driver.manage().window().getSize();
    // int width = size.width;
    // int height = size.height;
    // int middleOfX = width / 2;
    // int startYCoordinate = (int) (height * .7);
    // int endYCoordinate = (int) (height * .3);

    // action.press(PointOption.point(middleOfX, startYCoordinate))
    // .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20)))
    // .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    // }

    // String locator =
    // "UiScrollable(\"className(\"android.widget.ScrollView\")\").scrollIntoView(resourceId(\"id_of_element_to_scroll_to\"))";
    // driver.findElement(MobileBy.AndroidUIAutomator(locator)).click();

    // public void scrollAndClick(String visibleText) {
    // MobileElement listItem = (MobileElement)
    // driver.findElement(MobileBy.AndroidUIAutomator(
    // "new UiScrollable(new UiSelector()).scrollIntoView(text(\"<Mention your
    // element text value here>\"))"));
    // }

    // check if image displayed
    // (//android.widget.ImageView[@resource-id="com.androidsample.generalstore:id/productImage"])[1]

    // //android.support.v7.widget.RecyclerView[@resource-id="com.androidsample.generalstore:id/rvProductList"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout

}
