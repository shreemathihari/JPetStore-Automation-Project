package hooks;
import java.util.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.ExtentReportManager;
import base.BaseTest;
 
public class Hooks extends BaseTest {
 
    private static ExtentTest test;
 
    @Before
    public void beforeScenario(Scenario scenario) {
 
        setUp();
 
        test = ExtentReportManager.getExtentReports()
                .createTest(scenario.getName());
 
        test.info("Scenario started");
    }
 
    @After
    public void afterScenario(Scenario scenario) {
 
        if (scenario.isFailed()) {
 
            test.fail("Scenario Failed");
 
            byte[] screenshot =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
 
            scenario.attach(
                    screenshot,
                    "image/png",
                    "Failure Screenshot"
            );
 
            test.addScreenCaptureFromBase64String(
                    Base64.getEncoder().encodeToString(screenshot)
            );
 
        } else {
 
            test.pass("Scenario Passed");
        }
 
        ExtentReportManager.getExtentReports().flush();
 
        tearDown();
    }
}
 