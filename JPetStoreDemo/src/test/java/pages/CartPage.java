package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CartPage {
    private WebDriver driver;
    private CartPage cartPage;
    private By cartLink = By.linkText("Cart"); 
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void clickCart() {
        driver.findElement(cartLink).click();
    }
    public void addProduct(String category, String productId) {
        driver.findElement(By.linkText(category)).click();
        driver.findElement(By.linkText(productId)).click();
        driver.findElement(By.xpath("//a[contains(@href,'addItemToCart')]")).click();
    }
 
    public void updateQuantity(String quantity) {
        By quantityField = By.name("quantity");
 
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(quantity);
 
        driver.findElement(By.name("updateCartQuantities")).click();
    }
 
    public void removeProduct() {
        driver.findElement(By.linkText("Remove")).click();
    }
    public boolean isProductInCart(String productName) {
    	 
        By product = By.xpath("//*[normalize-space()='" + productName + "']");
     
        return driver.findElement(product).isDisplayed();
    }
    
}