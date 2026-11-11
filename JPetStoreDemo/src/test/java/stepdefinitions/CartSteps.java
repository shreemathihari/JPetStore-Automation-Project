package stepdefinitions;
import org.junit.Assert;

import base.BaseTest;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.CartExcelReader;
 
public class CartSteps extends BaseTest {
 
    private CartPage cartPage;
    public CartSteps() {
        cartPage = new CartPage(DriverFactory.getDriver());
    }
     @When("user adds the product for cart test {string}")
    public void user_adds_the_product_for_cart_test(String testId) {
 
    	 String category = CartExcelReader.getData(testId, 2);
    	 String productId = CartExcelReader.getData(testId, 3);
    	  
    	 System.out.println("Test ID: " + testId);
    	 System.out.println("Category: " + category);
    	 System.out.println("Product ID: " + productId);
    	  
    	 cartPage.addProduct(category, productId);
    }
 
    @And("user updates the cart quantity for test {string}")
    public void user_updates_the_cart_quantity_for_test(String testId) {
 
        String quantity = CartExcelReader.getData(testId, 5);
 
        System.out.println("Quantity: " + quantity);
 
        cartPage.updateQuantity(quantity);
    }
 
    @And("user removes the product from cart")
    public void user_removes_the_product_from_cart() {
 
        cartPage.removeProduct();
    }
    @Then("cart should contain the expected product for test {string}")
    public void cart_should_contain_the_expected_product_for_test(String testId) {
     
        String productName = CartExcelReader.getData(testId, 4);
     
        boolean displayed = cartPage.isProductInCart(productName);
     
        Assert.assertTrue(
            "Product was not found in cart: " + productName,
            displayed
        );
    }
}
 