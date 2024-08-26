package screens.store.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.screen.BaseScreen;
import io.appium.java_client.AppiumDriver;

public class CartScreen extends BaseScreen {

    public CartScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getCartTotalValue() {
        By byCartValue = By.id("com.androidsample.generalstore:id/totalAmountLbl");
        WebElement cartValue = findElement(byCartValue);
        return cartValue.getText();
    }

    public String getCartTotalValueLableValue() {
        By byCartValueLable = By.xpath("//android.widget.TextView[@text=\"Total Purchase Amount:  \"]");
        WebElement cartValueLable = findElement(byCartValueLable);
        return cartValueLable.getText();
    }

    public String getSendMeEmailLableValue() {
        By bySendMeEmailLable = By.xpath(
                "//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]");
        WebElement sendMeEmailLable = findElement(bySendMeEmailLable);
        return sendMeEmailLable.getText();
    }

    public String getTermsAndConditionLableValue() {
        By byTermsButton = By.xpath("com.androidsample.generalstore:id/termsButton");
        WebElement termsButton = findElement(byTermsButton);
        return termsButton.getText();
    }

    public boolean isProductListVisible(int position) {
        By byProductList = By.id(String.format(
                "com.androidsample.generalstore:id/rvCartProductList",
                position));
        WebElement productList = findElement(byProductList);
        return productList == null ? false : productList.isDisplayed();
    }

    public void ClickOnSendMeEmailCheckBox() {
        By bySendMeEmailLable = By.xpath(
                "//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]");
        WebElement sendMeEmailLable = findElement(bySendMeEmailLable);
        click(sendMeEmailLable);
    }

    public void clickOnCompleteOrderButton() {
        By byCompleteOrder = By.id("com.androidsample.generalstore:id/btnProceed");
        WebElement completeOrder = findElement(byCompleteOrder);
        click(completeOrder);
    }

    public boolean isProductImageByPositionVisible(int position) {
        By byProductImage = By.xpath(String.format(
                "(//android.widget.ImageView[@resource-id=\"com.androidsample.generalstore:id/productImage\"])[%1$s]",
                position));
        WebElement productImage = findElement(byProductImage);
        return productImage == null ? false : productImage.isDisplayed();
    }

    public boolean isProductByPositionVisible(int position) {
        By byProduct = By.xpath(String.format(
                "//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvCartProductList\"]/android.widget.RelativeLayout[%1$s]/android.widget.LinearLayout",
                position));
        WebElement product = findElement(byProduct);
        return product == null ? false : product.isDisplayed();
    }

    public String getProductNameByPosition(int position) {
        By byProductNameText = By
                .xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]");
        List<WebElement> productNameTextList = findElements(byProductNameText);
        return getText(productNameTextList.get(position - 1));
    }

    public String getProductPriceByPosition(int position) {
        By byProductPriceText = By
                .xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]");
        List<WebElement> productPriceTextList = findElements(byProductPriceText);
        return getText(productPriceTextList.get(position - 1));
    }
}
