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

public class AutomationExercise13 {
    WebDriver driver;
    ChromeOptions options;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPath-Plugin.crx"));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(cap);
        //1. Launch browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws AWTException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
        Assert.assertTrue(home.isDisplayed());
        //4. Click 'View Product' for any product on home page
        Robot rbt = new Robot();
        rbt.mouseWheel(4);
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //5. Verify product detail is opened
        WebElement verifyPrd = driver.findElement(By.xpath(" //h2[normalize-space()='Blue Top']"));
        Assert.assertTrue(verifyPrd.isDisplayed());
        //6. Increase quantity to 4
        driver.findElement(By.xpath("//input[@id='quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("4");
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
       WebElement prdName=driver.findElement(By.xpath("//a[normalize-space()='Blue Top']"));
       Assert.assertTrue(prdName.isDisplayed());
       WebElement prdQty=driver.findElement(By.xpath("//button[@class='disabled']"));
       Assert.assertTrue(prdQty.getText().contains("4"));
//

    }
}
