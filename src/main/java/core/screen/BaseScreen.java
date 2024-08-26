package core.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseScreen {
    protected AppiumDriver driver;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By by) {
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return element;
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void waitForElementToBePresent(By by) {
        // Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToBeVisible(WebElement elem) {
        // Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public static boolean isScreenTitleVisible(AppiumDriver driver){
        By byScreenTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
        BaseScreen baseScreen = new BaseScreen(driver);
        baseScreen.waitForElementToBePresent(byScreenTitle);
        WebElement screenTitle = baseScreen.findElement(byScreenTitle);
        return screenTitle == null ? false : screenTitle.isDisplayed();
    }

    public static String getCurrentScreen(AppiumDriver driver){
        By byScreenTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
        BaseScreen baseScreen = new BaseScreen(driver);
        baseScreen.waitForElementToBePresent(byScreenTitle);
        return baseScreen.findElement(byScreenTitle).getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getToastMessage(){
        By byToast = By.xpath("/hierarchy/android.widget.Toast");

        waitForElementToBePresent(byToast);
        WebElement toast = findElement(byToast);
        return toast.getText(); 
    }
}
