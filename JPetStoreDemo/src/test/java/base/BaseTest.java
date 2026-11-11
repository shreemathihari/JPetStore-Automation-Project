package base;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
 
public class BaseTest {
 
    protected static WebDriver driver;
 
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://jpetstore.aspectran.com/");
    }
 
    public void tearDown() {
        DriverFactory.quitDriver();
        driver = null;
    }
}