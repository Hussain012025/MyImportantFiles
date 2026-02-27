package MyProject;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Scanner;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Myflip extends Baseclass {
    
    @Test(priority = 1)
    public void loginWithMouseHover() {
        test = extent.createTest("Login Mouse Hover Test");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            try {
                // Handling the login popup using JS executor for reliable click
                WebElement popup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='✕'] | //span[@role='button']")));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", popup);
            } catch (Exception e) {
                System.out.println("Login popup not displayed. Moving forward.");
            }

            // Hover and click login
            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Login')] | //a[contains(text(),'Login')]")));
            Actions act = new Actions(driver);
            act.moveToElement(loginBtn).click().perform();
            test.pass("Mouse hovered and clicked on Login successfully");
        } catch(Exception e) {
            test.fail("Login Hover Failed");
        }
    }
    
    @Test(priority = 2)
    public void OTPAutoamtion() {
        test = extent.createTest("OTP Automation Test");
        try {
            // Increased timeout for manual OTP entry
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            WebElement loginLink = driver.findElement(By.xpath("//span[contains(text(),'Login')] | //a[contains(text(),'Login')]"));
            js.executeScript("arguments[0].click();", loginLink);
            
            // Robust XPath avoiding search box conflict
            WebElement ph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and not(@name='q')] | //input[@class='r4vIwl BV+Dqf' or @class='_2IX_2- VJZDxU']")));
            ph.sendKeys("7604924499"); 
            
            WebElement requestOtpBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Request OTP'] | //button[contains(@class,'KcXDCU')]")));
            js.executeScript("arguments[0].click();", requestOtpBtn); 
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the 6-digit OTP in the console:");
            String otp = scan.next(); 
            
            WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@maxlength='6'] | //input[contains(@class,'uMHqnd')]")));
            otpInput.sendKeys(otp);
            
            // Handling auto-submit vs manual submit for OTP
            try {
                WebElement verifyBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Verify')]")));
                js.executeScript("arguments[0].click();", verifyBtn);
            } catch(Exception e) {
                 System.out.println("Auto-submitted OTP successfully.");
            }
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))); 
            test.pass("OTP entered and logged in successfully");
        } catch(Exception e) {
            test.fail("OTP Test Failed");
            Assert.fail("OTP Test Failed");
        }
    }
     
    @Test(priority = 3)
    public void Search() throws AWTException {
        test = extent.createTest("Product Search & Verification Test");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.sendKeys("iphone");
            searchBox.submit(); 
            
            // Identifying the first product dynamically
            WebElement firstProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[contains(@href, '/p/') and @class='k7wcnx'])[1] | (//div[@data-id])[1]//a")));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstProduct);
            js.executeScript("arguments[0].click();", firstProduct); 
            
            test.pass("Search and click successful");
        } catch(Exception e) {
            test.fail("Search Test Failed: " + e.getMessage());
            Assert.fail("Search Test Failed");
        }
    }
    
    @Test(priority = 4)
    public void Addcart() {
        test = extent.createTest("Add to Cart / Buy Now Test");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            String parentWindow = driver.getWindowHandle();
            
            // Smart window handling logic (checking if new tab opens)
            try {
                WebDriverWait tabWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                tabWait.until(ExpectedConditions.numberOfWindowsToBe(2));
            } catch (Exception e) {
                System.out.println("Product opened in the same tab. Continuing execution.");
            }
            
            Set<String> handles = driver.getWindowHandles();
            for(String winHandle : handles){
                if(!winHandle.equals(parentWindow)) {
                    driver.switchTo().window(winHandle);
                    break;
                }
            }
            
            // Wait for full page load
            wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
            js.executeScript("window.scrollBy(0,500)", ""); 

            WebElement actionBtn = null;
            
            // 3-tier master logic to locate dynamic Add to Cart / Buy Now buttons
            try {
                actionBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'add to cart') or contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'buy now')])[last()]")));
            } catch (Exception e1) {
                try {
                    actionBtn = driver.findElement(By.xpath("//button[contains(@class, 'QqFHMw')] | //button[contains(@class, 'ihZ75k')] | //li//button"));
                } catch (Exception e2) {
                    actionBtn = driver.findElement(By.xpath("//*[contains(text(), 'Buy') or contains(text(), 'Cart') or contains(text(), 'cart') or contains(text(), 'buy')]"));
                }
            }

            if (actionBtn != null) {
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", actionBtn);
                js.executeScript("arguments[0].click();", actionBtn); 
                test.pass("Successfully clicked on Add to Cart or Buy Now button");
            } else {
                throw new Exception("Button not found on the page");
            }
            
        } catch(Exception e) {
            test.fail("Action button failed: " + e.getMessage());
            Assert.fail("Action button failed");
        }
    }
}