package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
public class SignUpPage {
 
    private WebDriver driver;
 
    // Sign Up link
    private By signInLink = By.linkText("Sign In");
    private By registerLink = By.linkText("Sign Up");
 
    // Account Information
    private By username = By.name("username");
    private By password = By.name("password");
    private By repeatPassword = By.name("repeatedPassword");
 
    // Personal Information
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By email = By.name("email");
    private By phone = By.name("phone");
    private By address1 = By.name("address1");
    private By address2 = By.name("address2");
    private By city = By.name("city");
    private By state = By.name("state");
    private By zip = By.name("zip");
    private By country = By.name("country");
    private By language = By.name("languagePreference");
    private By favoriteCategory = By.name("favouriteCategoryId");
     
    private By myList = By.name("listOption");
    private By myBanner = By.name("bannerOption");
     
    private By saveAccount =
            By.xpath("//button[contains(text(),'Save Account Information')]");
 
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }
 
    public void clickRegisterNow() {

        WebElement signUpBtn =
                driver.findElement(registerLink);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", signUpBtn);
    }
 
    public void enterUsername(String value) {
        driver.findElement(username).sendKeys(value);
    }
 
    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }
 
    public void enterRepeatPassword(String value) {
        driver.findElement(repeatPassword).sendKeys(value);
    }
 
    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }
 
    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }
 
    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }
 
    public void enterPhone(String value) {
        driver.findElement(phone).sendKeys(value);
    }
 
    public void enterAddress1(String value) {
        driver.findElement(address1).sendKeys(value);
    }
 
    public void enterAddress2(String value) {
        driver.findElement(address2).sendKeys(value);
    }
 
    public void enterCity(String value) {
        driver.findElement(city).sendKeys(value);
    }
 
    public void enterState(String value) {
        driver.findElement(state).sendKeys(value);
    }
 
    public void enterZip(String value) {
        driver.findElement(zip).sendKeys(value);
    }
 
    public void enterCountry(String value) {
        driver.findElement(country).sendKeys(value);
    }
    public void selectLanguage(String value) {
        driver.findElement(language).sendKeys(value);
    }
     
    public void selectFavoriteCategory(String value) {
        driver.findElement(favoriteCategory).sendKeys(value);
    }
     
    public void selectMyList() {

        WebElement element =
                driver.findElement(myList);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element);
    }
     
    public void selectMyBanner() {

        WebElement element =
                driver.findElement(myBanner);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element);
    }
    public void clickSaveAccount() {

        WebElement element =
                driver.findElement(
                        By.xpath("//button[contains(text(),'Save Account Information')]"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        element);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element);
    }
     
}
 
