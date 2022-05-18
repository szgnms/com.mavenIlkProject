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

public class AutomationExercise22 {
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
        //3. Scroll to bottom of page
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_END);
        //4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommended = driver.findElement(By.xpath("//h2[normalize-space()='recommended items']"));
        Assert.assertTrue(recommended.isDisplayed());
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[69]")).click();
        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("(//p[@class='text-center'])[2]")).click();
        //7. Verify that product is displayed in cart page
        WebElement prdDetails = driver.findElement(By.xpath("//button[@class='disabled']"));
        Assert.assertTrue(prdDetails.isDisplayed());
    }
}
