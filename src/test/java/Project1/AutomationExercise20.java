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
import java.util.List;

public class AutomationExercise20 {
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
        //5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Blue Top");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement verifySerPrd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifySerPrd.isDisplayed());
        //7. Verify all the products related to search are visible
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (WebElement product : products) {
            String prd = product.getText();
            System.out.println(prd);

        }

        products.forEach(WebElement::isDisplayed);
        // //8. Add those products to cart
        for (WebElement prdName : products) {
            driver.findElement(By.xpath("//input[@id='search_product']")).clear();
            driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(prdName.getText());
            driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
            Robot rbt = new Robot();
            rbt.mouseWheel(4);
            driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='modal-footer']")).click();
            Thread.sleep(1000);
            driver.navigate().back();


        }
         //9. Click 'Cart' button and verify that products are visible in cart
           driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
           List<WebElement> productsAllAdd = driver.findElements(By.xpath("//td[@class='cart_description']"));
          Assert.assertEquals(productsAllAdd.size(), products.size());
         //10. Click 'Signup / Login' button and submit login details
         driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
         driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pass@word.com");
         driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
         driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
         //11. Again, go to Cart page
         driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
         //12. Verify that those products are visible in cart after login as well1
         productsAllAdd.forEach(WebElement::isDisplayed);


    }
}
