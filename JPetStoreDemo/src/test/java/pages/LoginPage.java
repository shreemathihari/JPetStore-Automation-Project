package pages;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class LoginPage {
 
    WebDriver driver;
    private LoginPage loginPage;
    By signIn = By.linkText("Sign In");
    By username = By.name("username");
    By password = By.name("password");
    By loginButton = By.name("signon");
    private By signOutLink = By.xpath("//a[@href='/account/signoff']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void clickSignIn() {
        driver.findElement(signIn).click();
    }
    public void login(String username, String password) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
     
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
     
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
     
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
     
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     
        System.out.println("URL AFTER LOGIN CLICK: " + driver.getCurrentUrl());
    }
    public boolean isLoggedIn() {
        return !driver.findElements(
                By.linkText("Sign Out"))
                .isEmpty();
    }
    public void clickSignOut() {
    	 
        // Click My Account dropdown
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     
        WebElement myAccount = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("dropdownMenuButton")
            )
        );
     
        myAccount.click();
     
        // Click Sign Out
        WebElement signOut = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/account/signoff']")
            )
        );
     
        signOut.click();
    }
   }
    