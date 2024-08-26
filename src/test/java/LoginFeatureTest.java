import constants.TestGroups;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.ProductsSteps;

@Test(groups = { TestGroups.LOGIN })
public class LoginFeatureTest extends BaseTest {

    /*
     * Scenario:
     * validate if first screen after launching the application is login screen i.e.
     * "General Store"
     */
    @Test(groups = { "testApplicationInitialLaunchScreen" })
    public void testApplicationInitialLaunchScreen() {
        LoginSteps.assetLoginScreenVisible(this.driver);
    }

    /*
     * Scenario:
     * validate UI elements present for it's visibility
     */
    // public void testLoginScreenDetails(){
    // //screen title visible
    // //country label visible
    // //county dropdown visible
    // //user name lable visible
    // //user name edittext visible
    // //gender lable visible
    // //gender radio button visible
    // //letsshop button visible
    // }

    /*
     * Scenario:
     * validate if pressing back button twice exit the application
     * 
     */
    @Test(groups = { "testNavigationBackButtonTwiceToExit" })
    public void testNavigationBackButtonTwiceToExit() {
        LoginSteps.assetLoginScreenVisible(this.driver);
        LoginSteps.assertDoubleBackPressToExit(driver);
    }

    /*
     * Scenario:
     * validate if without entering user name and pressing "Let's Shop" button
     * "throws error toast message on screen.
     */
    @Test(groups = { "testLetsShopButtonClickError" })
    public void testLetsShopButtonClickError() {
        LoginSteps.assetLoginScreenVisible(this.driver);
        LoginSteps.assetToastMessageForEmptyNameIsShown(this.driver);
    }

     /*
     * Scenario:
     * validates funtionality for Gender Selection Radio buttons available options and functionality
     */
    // //Test Gender selection

     /*
     * Scenario:
     * validates country selection dropdown available opetions and functionality
     */
    // //Test country selection

    /*
     * Scenario:
     * validate if after entering user name and pressing "let's Shop" takes to next
     * screen i.e. "Product" screen.
     */
    @Test(groups = { "testLetsShopButtonClickToProductScreen" })
    public void testLetsShopButtonClickToProductScreen() {
        LoginSteps.assetLoginScreenVisible(this.driver);

        LoginSteps.enterUserName(driver, "John Doe");
        LoginSteps.clickOnLetsShopButton(driver);

        ProductsSteps.assertCurrentScreenIsProductScreen(driver);
    }
}
