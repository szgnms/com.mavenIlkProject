package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class AutomationExercise9 {
    WebDriver driver;
    ChromeOptions options;

    @Before
    public void setUp(){
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
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
        Assert.assertTrue(home.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());
        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Blue top");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement productSrc1 = driver.findElement(By.xpath("//div[@class='product-overlay']"));
        Assert.assertTrue(productSrc1.isDisplayed());
        driver.navigate().back();
        //8. Verify all the products related to search are visible
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
         for (WebElement product : products){
             System.out.println(product.getText());
         }
        products.forEach(WebElement::isDisplayed);


    }
}
