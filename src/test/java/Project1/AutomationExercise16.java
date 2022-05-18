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

public class AutomationExercise16 {
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
        driver.close();
    }

    @Test
    public void test() throws AWTException, InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
        Assert.assertTrue(home.isDisplayed());
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pass@word.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //6. Verify 'Logged in as username' at top
        WebElement loggedInAsUserName = driver.findElement(By.xpath("//li[9]//a[1]"));
        Assert.assertTrue(loggedInAsUserName.isDisplayed());
        //7. Add products to cart
        Robot rbt = new Robot();
        rbt.mouseWheel(4);
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        //8. Click 'Cart' button
        rbt.keyPress(KeyEvent.VK_HOME);
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        //9. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //11. Verify Address Details and Review Your Order
        WebElement adress = driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(adress.isDisplayed());
        WebElement review = driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(review.isDisplayed());
        //12. Enter description in comment text area and click 'Place Order'
        rbt.mouseWheel(7);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testtest test");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("szgnmm");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234123412341324");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("25");
        //14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //15. Verify success message 'Your order has been placed successfully!'
        WebElement success = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(success.isDisplayed());
        //16. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        // This page isn`t avaible
    }

}
