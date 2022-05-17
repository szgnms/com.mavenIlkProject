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

public class AutomationExercise12 {
    WebDriver driver;
    ChromeOptions options;

    @Before
    public void setUp() {
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
        //driver.close();
    }

    @Test
    public void test() throws AWTException, InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
        Assert.assertTrue(home.isDisplayed());
        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Hover over first product and click 'Add to cart'
        Robot rbt = new Robot();
        rbt.mouseWheel(4);
        String prc1 = driver.findElement(By.xpath("(//div[@class='overlay-content']/h2)[1]")).getText().replaceAll("\\D","");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        //6. Click 'Continue Shopping' button
        String prc2 = driver.findElement(By.xpath("(//div[@class='overlay-content']/h2)[2]")).getText().replaceAll("\\D","");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        //8. Click 'View Cart' buttonr5t.

        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
        //9. Verify both products are added to Cart
        WebElement prd1 = driver.findElement(By.xpath("//a[normalize-space()='Blue Top']"));
        Assert.assertTrue(prd1.isDisplayed());
        WebElement prd2 = driver.findElement(By.xpath("//a[normalize-space()='Men Tshirt']"));
        Assert.assertTrue(prd2.isDisplayed());
        //10. Verify their prices, quantity and total price
        String sptPrc1 = driver.findElement(By.xpath("(//td[@class='cart_price'])[1]")).getText().replaceAll("\\D","");
        Assert.assertEquals("500", sptPrc1);
        String sptPrc2 = driver.findElement(By.xpath("(//td[@class='cart_price'])[2]")).getText().replaceAll("\\D","");
        Assert.assertEquals("400", sptPrc2);
        String quantity1 = driver.findElement(By.xpath("//tr[@id='product-1']//button[@class='disabled'][normalize-space()='1']")).getText();
        String quantity2 = driver.findElement(By.xpath("//tr[@id='product-2']//button[@class='disabled'][normalize-space()='1']")).getText();
        System.out.println(quantity1);
        Assert.assertEquals("1", quantity1);
        Assert.assertEquals("1", quantity2);
        String total1= driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 500']")).getText().replaceAll("\\D","");
        System.out.println(total1);
        String total2= driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 400']")).getText().replaceAll("\\D","");
        System.out.println(total2);
       //Assert.assertSame(Integer.parseInt(total1),(Integer.parseInt(prc1)*Integer.parseInt(sptPrc1)));
       //Assert.assertSame(Integer.parseInt(total2),(Integer.parseInt(prc2)*Integer.parseInt(sptPrc2)));





    }


}
