package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class ProductPage {
 
    private WebDriver driver;
    ProductPage productPage;
    // Category links
    private By fishCategory = By.linkText("Fish");
    private By dogsCategory = By.linkText("Dogs");
    private By reptilesCategory = By.linkText("Reptiles");
    private By catsCategory = By.linkText("Cats");
    private By birdsCategory = By.linkText("Birds");
 
    // Product ID links
    private By productId(String productId) {
        return By.linkText(productId);
    }
 
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void clickCategory(String category) {
 
        switch (category.toLowerCase()) {
 
            case "fish":
                driver.findElement(fishCategory).click();
                break;
 
            case "dogs":
                driver.findElement(dogsCategory).click();
                break;
 
            case "reptiles":
                driver.findElement(reptilesCategory).click();
                break;
 
            case "cats":
                driver.findElement(catsCategory).click();
                break;
 
            case "birds":
                driver.findElement(birdsCategory).click();
                break;
 
            default:
                throw new IllegalArgumentException(
                    "Invalid category: " + category);
        }
    }
 
    public void clickProduct(String productId) {
        driver.findElement(productId(productId)).click();
    }
 
    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getProductName() {
        return driver.findElement(By.cssSelector("div#Catalog table tbody tr:nth-child(2) td:nth-child(2)")).getText();
    }
    public boolean isProductDisplayed(String productName) {
    	 
        By product = By.xpath("//*[normalize-space()='" + productName + "']");
     
        return driver.findElement(product).isDisplayed();
    }
}
 