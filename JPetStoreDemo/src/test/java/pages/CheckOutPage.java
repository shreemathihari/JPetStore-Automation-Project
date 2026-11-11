package pages;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
public class CheckOutPage {
    private WebDriver driver;
    private By cartLink =
            By.xpath("//a[contains(@href,'viewCart')]");
    private By proceedToCheckout =
            By.xpath("//a[text()='Proceed to Checkout']");
    By cardType =
    	    By.xpath("//select[@name='cardType']");
    private By cardNumber = By.name("creditCard");
    private By expiryDate = By.name("expiryDate");
 
    private By firstName = By.name("billToFirstName");
    private By lastName = By.name("billToLastName");
    private By address1 = By.name("billAddress1");
    private By address2 = By.name("billAddress2");
    private By city = By.name("billCity");
    private By state = By.name("billState");
    private By zip = By.name("billZip");
    private By country = By.name("billCountry");
    private By continueButton = By.xpath("//button[normalize-space()='Continue']");
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void clickCart() {
        driver.findElement(cartLink).click();
    }
    public void clickProceedToCheckout() {

        WebElement element = driver.findElement(proceedToCheckout);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        System.out.println("After click URL: " + driver.getCurrentUrl());
        System.out.println("Before checkout URL: "
                + driver.getCurrentUrl());

        System.out.println("Sign Out count: "
                + driver.findElements(
                        By.linkText("Sign Out"))
                        .size());

        System.out.println("My Account count: "
                + driver.findElements(
                        By.linkText("My Account"))
                        .size());
    }
    public void enterCardType(String value) {

        System.out.println("URL AT CARD TYPE : "
                + driver.getCurrentUrl());

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//select[@name='cardType']")));

        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }
    public void enterCardNumber(String value) {
        driver.findElement(cardNumber).clear();
        driver.findElement(cardNumber).sendKeys(value);
    }
 
    public void enterExpiryDate(String value) {
        driver.findElement(expiryDate).clear();
        driver.findElement(expiryDate).sendKeys(value);
    }
 
    public void enterFirstName(String value) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(value);
    }
 
    public void enterLastName(String value) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(value);
    }
 
    public void enterAddress1(String value) {
        driver.findElement(address1).clear();
        driver.findElement(address1).sendKeys(value);
    }
 
    public void enterAddress2(String value) {
        driver.findElement(address2).clear();
        driver.findElement(address2).sendKeys(value);
    }
 
    public void enterCity(String value) {
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(value);
    }
 
    public void enterState(String value) {
        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(value);
    }
 
    public void enterZip(String value) {
        driver.findElement(zip).clear();
        driver.findElement(zip).sendKeys(value);
    }
 
    public void enterCountry(String value) {
        driver.findElement(country).clear();
        driver.findElement(country).sendKeys(value);
    }
    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     
        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(continueButton)
        );
     
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", button
        );
     
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", button
        );
    }
}
 
