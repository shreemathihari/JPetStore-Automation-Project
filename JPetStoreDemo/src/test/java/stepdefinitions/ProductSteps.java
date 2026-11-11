package stepdefinitions;
import org.junit.Assert;
 
import base.BaseTest;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import utils.ProductExcelReader;
 
public class ProductSteps extends BaseTest { 
    String category;
    String productId;
    String productName; 
    private ProductPage productPage;
    public ProductSteps() {
        productPage = new ProductPage(DriverFactory.getDriver());
    }
    @When("user selects the category for test {string}")
    public void user_selects_the_category_for_test(String testId) {
 
        category = ProductExcelReader.getData(testId, 2);
 
        System.out.println("Test ID: " + testId);
        System.out.println("Category: " + category);
 
        productPage.clickCategory(category);
    }
 
    @And("user selects the product for test {string}")
    public void user_selects_the_product_for_test(String testId) {
 
        productId = ProductExcelReader.getData(testId, 3);
        productName = ProductExcelReader.getData(testId, 4);
 
        System.out.println("Product ID: " + productId);
        System.out.println("Product: " + productName);
 
        productPage.clickProduct(productId);
    }
 
    @Then("user should see the expected product for test {string}")
    public void user_should_see_the_expected_product_for_test(String testId) {
 
        boolean result = productPage.isProductDisplayed(productName);
 
        Assert.assertTrue(
                "Expected product was not displayed: " + productName,
                result
        );
    }
}
 
