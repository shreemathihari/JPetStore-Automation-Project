package stepdefinitions;
import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import utils.CheckOutExcelReader;
 
public class CheckOutSteps extends BaseTest {
 
    private CheckOutPage checkoutPage;
 
    @When("user opens the cart for checkout")
    public void user_opens_the_cart_for_checkout() {
 
        checkoutPage = new CheckOutPage(driver);
 
        checkoutPage.clickCart();
    }
 
    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
 
        checkoutPage.clickProceedToCheckout();
    }
 
    @And("user enters checkout details for {string}")
    public void user_enters_checkout_details_for(String testId) {
 
        String cardType = CheckOutExcelReader.getData(testId, 2);
        String cardNumber = CheckOutExcelReader.getData(testId, 3);
        String expiryDate = CheckOutExcelReader.getData(testId, 4);
 
        String firstName = CheckOutExcelReader.getData(testId, 5);
        String lastName = CheckOutExcelReader.getData(testId, 6);
 
        String address1 = CheckOutExcelReader.getData(testId, 7);
        String address2 = CheckOutExcelReader.getData(testId, 8);
 
        String city = CheckOutExcelReader.getData(testId, 9);
        String state = CheckOutExcelReader.getData(testId, 10);
        String zip = CheckOutExcelReader.getData(testId, 11);
        String country = CheckOutExcelReader.getData(testId, 12);
 
        System.out.println("Test ID: " + testId);
        System.out.println("Card Type: " + cardType);
        System.out.println("First Name: " + firstName);
 
        checkoutPage.enterCardType(cardType);
        checkoutPage.enterCardNumber(cardNumber);
        checkoutPage.enterExpiryDate(expiryDate);
 
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
 
        checkoutPage.enterAddress1(address1);
        checkoutPage.enterAddress2(address2);
        checkoutPage.enterCity(city);
        checkoutPage.enterState(state);
        checkoutPage.enterZip(zip);
        checkoutPage.enterCountry(country);
    }
 
    @And("user clicks continue on checkout")
    public void user_clicks_continue_on_checkout() {
 
        checkoutPage.clickContinue();
    }
}
 