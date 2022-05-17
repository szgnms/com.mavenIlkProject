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

public class AutomationExercise8 {
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
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws AWTException, InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement products = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(products.isDisplayed());
        //6. The products list is visible
        Robot rbt = new Robot();
        rbt.mouseWheel(34);
        Thread.sleep(1000);
        rbt.keyPress(KeyEvent.VK_HOME);
        WebElement productList = driver.findElement(By.xpath("//div[22]//div[1]//div[1]//div[2]"));
        Assert.assertTrue(productList.isDisplayed());
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]")).click();
        //8. User is landed to product detail page
        WebElement prdDetails = driver.findElement(By.xpath("//div[@class='view-product']//img[@alt='ecommerce website products']"));
        Assert.assertTrue(prdDetails.isDisplayed());
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement prdName=driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']"));
        Assert.assertTrue(prdName.isDisplayed());
        WebElement category=driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price=driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability=driver.findElement(By.xpath("//b[normalize-space()='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition=driver.findElement(By.xpath("//b[normalize-space()='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand=driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());

    }

}
