package MyProject;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Baseclass {
    
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void startReport() {
        
        String path = System.getProperty("user.dir") + "/reports";
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(path + "/FlipkartExtentReport.html");
        reporter.config().setReportName("Flipkart Automation Report");
        reporter.config().setDocumentTitle("Flipkart Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Project", "Flipkart Application");
        extent.setSystemInfo("Tester", "Nisha");
        extent.setSystemInfo("Browser", "Chrome");
    }
  
    @BeforeClass
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options); 
   
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.flipkart.com");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void saveReport() {
        extent.flush(); 
    }
    
    public void TakeMyScreenShot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File destin = new File("./Screenshot/" + fileName + ".png");
        FileUtils.copyFile(src, destin);
    }  

}
