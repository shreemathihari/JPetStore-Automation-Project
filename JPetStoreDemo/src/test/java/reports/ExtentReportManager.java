package reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportManager {
 
    private static ExtentReports extent;
 
    public static ExtentReports getExtentReports() {
 
        if (extent == null) {
 
            String reportPath = "target/ExtentReport/ExtentReport.html";
 
            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);
 
            sparkReporter.config().setDocumentTitle("JPetStore Automation Report");
            sparkReporter.config().setReportName("JPetStore Test Execution Report");
 
            extent = new ExtentReports();
 
            extent.attachReporter(sparkReporter);
 
            extent.setSystemInfo("Project", "JPetStore");
            extent.setSystemInfo("Automation", "Selenium + Cucumber");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Browser", "Chrome");
        }
 
        return extent;
    }
}