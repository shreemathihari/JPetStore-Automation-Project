package stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;
import base.BaseTest;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.LoginExcelReader;
 
public class LoginSteps extends BaseTest {
 
    private LoginPage loginPage; 
    public LoginSteps() {
    	}
    @When("user clicks on Sign In")
    public void user_clicks_on_sign_in() {
    	loginPage=new LoginPage(driver);
        loginPage.clickSignIn();
    }
 
    @And("user logs in using credentials for test {string}")
    public void user_logs_in_using_credentials_for_test(String testId) {
    	Assert.fail("Temporary test failure for AI analysis");
    	 
        String username = LoginExcelReader.getData(testId, 2);
        String password = LoginExcelReader.getData(testId, 3);
 
        System.out.println("Test ID: " + testId);
        System.out.println("Username: " + username);
 
        loginPage.login(username, password);
        
        System.out.println("URL after login: " + driver.getCurrentUrl());
        System.out.println("Page text: " + driver.findElement(By.tagName("body")).getText());
         
    }
 
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
 
        String pageTitle = driver.getTitle();
 
        Assert.assertNotNull(
                "Page title should not be null",
                pageTitle
        );
    }
    @When("user clicks on Sign Out")
    public void user_clicks_on_sign_out() {
        loginPage.clickSignOut();
    }
    @Then("user should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        Assert.assertTrue(
            driver.findElements(By.linkText("Sign In")).size() > 0
        );
}
}
 