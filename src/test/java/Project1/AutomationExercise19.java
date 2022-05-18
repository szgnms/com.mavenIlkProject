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

public class AutomationExercise19 {
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
        //4. Verify that Brands are visible on left side bar
        WebElement verifyBrand = driver.findElement(By.xpath("//h2[normalize-space()='Brands']"));
        Assert.assertTrue(verifyBrand.isDisplayed());
        //5. Click on any brand name
        driver.findElement(By.xpath("//a[@href='/brand_products/Madame']")).click();
        //6. Verify that user is navigated to brand page and brand products are displayed
        WebElement verifyBm = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyBm.isDisplayed());
        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[@href='/brand_products/Babyhug']")).click();
        //8. Verify that user is navigated to that brand page and can see products
        WebElement verifyBh = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyBh.isDisplayed());
    }
}