package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class AutomationExercise6 {

    WebDriver driver;
    ChromeOptions options;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPath-Plugin.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        //1. Launch browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Test
    public void test() throws AWTException, InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement verifyGIT = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
        Assert.assertTrue(verifyGIT.isDisplayed());
        Robot rbt = new Robot();
        rbt.mouseWheel(5);
        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("name Surname");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("pass@word.com");
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("testting my test");
        //7. Upload file
       WebElement upload= driver.findElement(By.xpath("//input[@name='upload_file']"));
       upload.sendKeys("C:\\Users\\ms\\Downloads\\XPath.crx");
       driver.findElement(By.xpath("//input[@name='upload_file']"));
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //9. Click OK button
        rbt.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement uploadSuccess = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(uploadSuccess.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
        WebElement homePage1 = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage1.isDisplayed());


    }

}
