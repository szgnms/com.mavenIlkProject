package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.File;
import java.time.Duration;

public class AutomationExercise21 {
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
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement verifyAlPrd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyAlPrd.isDisplayed());
        //5. Click on 'View Product' button
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //6. Verify 'Write Your Review' is visible
        Robot rbt = new Robot();
        rbt.mouseWheel(5);
        WebElement writeReview=driver.findElement(By.xpath("//a[normalize-space()='Write Your Review']"));
        Assert.assertTrue(writeReview.isDisplayed());
        //7. Enter name, email and review
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("szgn");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pass@word.com");
        driver.findElement(By.xpath("//textarea[@id='review']")).sendKeys("test");
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//button[@id='button-review']")).click();
        //9. Verify success message 'Thank you for your review.'
        WebElement reviewSuc=driver.findElement(By.xpath("//div[@id='review-section']"));
        Assert.assertTrue(reviewSuc.isDisplayed());




    }
}