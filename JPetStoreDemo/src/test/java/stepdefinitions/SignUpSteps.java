package stepdefinitions;
import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;
import utils.SignUpExcelReader;
 
public class SignUpSteps extends BaseTest {
 
    private SignUpPage signUpPage;
 
    @When("user clicks on Sign In for registration")
    public void user_clicks_on_sign_in_for_registration() {
 
        signUpPage = new SignUpPage(driver);
 
        signUpPage.clickSignIn();
    }
 
    @And("user clicks on Register Now")
    public void user_clicks_on_register_now() {
 
        signUpPage.clickRegisterNow();
    }
 
    @And("user enters registration details for {string}")
    public void user_enters_registration_details_for(String userId) {
 
        String username = SignUpExcelReader.getData(userId, 2);
        String password = SignUpExcelReader.getData(userId, 3);
        String repeatPassword = SignUpExcelReader.getData(userId, 4);
 
        String firstName = SignUpExcelReader.getData(userId, 5);
        String lastName = SignUpExcelReader.getData(userId, 6);
        String email = SignUpExcelReader.getData(userId, 7);
        String phone = SignUpExcelReader.getData(userId, 8);
 
        String address1 = SignUpExcelReader.getData(userId, 9);
        String address2 = SignUpExcelReader.getData(userId, 10);
        String city = SignUpExcelReader.getData(userId, 11);
        String state = SignUpExcelReader.getData(userId, 12);
        String zip = SignUpExcelReader.getData(userId, 13);
        String country = SignUpExcelReader.getData(userId, 14);
        String language = SignUpExcelReader.getData(userId, 15);
        String favoriteCategory = SignUpExcelReader.getData(userId, 16);
 
        signUpPage.enterUsername(username);
        signUpPage.enterPassword(password);
        signUpPage.enterRepeatPassword(repeatPassword);
 
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPhone(phone);
 
        signUpPage.enterAddress1(address1);
        signUpPage.enterAddress2(address2);
        signUpPage.enterCity(city);
        signUpPage.enterState(state);
        signUpPage.enterZip(zip);
        signUpPage.enterCountry(country);
        signUpPage.selectLanguage(language);
        signUpPage.selectFavoriteCategory(favoriteCategory);
         
        signUpPage.selectMyList();
        signUpPage.selectMyBanner();
         
        signUpPage.clickSaveAccount();
    }
    @Then("user should complete registration successfully")
    public void user_should_complete_registration_successfully() {
     
        String currentUrl = driver.getCurrentUrl();
     
        Assert.assertFalse(
            "Registration was not completed",
            currentUrl.contains("Account.action")
        );
    }
     
}
 