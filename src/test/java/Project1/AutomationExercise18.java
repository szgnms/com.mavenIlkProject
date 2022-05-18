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

public class AutomationExercise18 {
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
        //3. Verify that categories are visible on left side bar
        WebElement verifyCategories = driver.findElement(By.xpath("//h2[normalize-space()='Category']"));
        Assert.assertTrue(verifyCategories.isDisplayed());
        //4. Click on 'Women' category
        driver.findElement(By.xpath("//a[normalize-space()='Women']")).click();
        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")).click();
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement verifyWd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyWd.isDisplayed());
        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[normalize-space()='Men']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Tshirts']")).click();
        //8. Verify that user is navigated to that category page
        WebElement verifyMt = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyMt.isDisplayed());
    }
}