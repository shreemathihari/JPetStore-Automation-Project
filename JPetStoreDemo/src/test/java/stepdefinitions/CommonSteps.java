package stepdefinitions;
 
import base.BaseTest;
import io.cucumber.java.en.Given;
 
public class CommonSteps extends BaseTest {
 
    @Given("user is on the JPetStore home page")
    public void user_is_on_the_jpet_store_home_page() {
        // Page is already opened by the Hooks
    }
}
 