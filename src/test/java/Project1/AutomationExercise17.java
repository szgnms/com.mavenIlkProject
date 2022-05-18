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
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class AutomationExercise17 {
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
        WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
        Assert.assertTrue(home.isDisplayed());
        //4. Add products to cart
        Robot rbt = new Robot();
        rbt.mouseWheel(4);
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        //5. Click 'Cart' button
        rbt.keyPress(KeyEvent.VK_HOME);
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
        //8. Verify that product is removed from the cart
        Thread.sleep(2000);
        WebElement verifyRemove = driver.findElement(By.xpath("//b[normalize-space()='Cart is empty!']"));
        Assert.assertTrue(verifyRemove.isDisplayed());


    }
}
