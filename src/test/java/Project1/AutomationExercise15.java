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

public class AutomationExercise15 {
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
    WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
    Assert.assertTrue(home.isDisplayed());
    //4. Click 'Signup / Login' button
    driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    //5. Fill all details in Signup and create account
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("aaaaaausernameusera");
    driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aaaaaapasspass@wordd.com");
    driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
    driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
    driver.findElement(By.xpath("//input[@id='name']")).clear();
    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("name");
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
    WebElement daySlct = driver.findElement(By.xpath("//select[@id='days']"));
    daySlct.click();
    daySlct.sendKeys("23");
    daySlct.click();
    WebElement monthSlct = driver.findElement(By.xpath("//select[@id='months']"));
    monthSlct.click();
    monthSlct.sendKeys("N");
    monthSlct.click();
    WebElement yearSlct = driver.findElement(By.xpath("//select[@id='years']"));
    yearSlct.click();
    yearSlct.sendKeys("1980");
    yearSlct.click();
    WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
    firstName.sendKeys("szgn");
    WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
    lastName.sendKeys("szgn");
    WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
    company.sendKeys("ictpera");
    WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
    address1.sendKeys("Umit , 2526 ");
    WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
    address2.sendKeys(" 4/1");
    WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
    country.click();
    country.sendKeys("can");
    driver.findElement(By.xpath("//input[@id='state']")).sendKeys("onta");
    driver.findElement(By.xpath("//input[@id='city']")).sendKeys("ontanario");
    driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("2054 Ont");
    driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+1 500 50 50505");
    driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
    WebElement accCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
    Assert.assertTrue(accCreate.isDisplayed());
    //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    WebElement acCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
    Assert.assertTrue(acCreate.isDisplayed());
    driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    //7. Verify ' Logged in as username' at top
    WebElement logIn = driver.findElement(By.xpath("//li[9]//a[1]"));
    Assert.assertTrue(logIn.isDisplayed());
    //8. Add products to cart
    Robot rbt = new Robot();
    rbt.mouseWheel(4);
    driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
    driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
    //9. Click 'Cart' button
    rbt.keyPress(KeyEvent.VK_HOME);
    driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
    //10. Verify that cart page is displayed
    WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
    Assert.assertTrue(cartPage.isDisplayed());
    //11. Click Proceed To Checkout
    driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
    //12. Verify Address Details and Review Your Order
    WebElement adress = driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
    Assert.assertTrue(adress.isDisplayed());
    WebElement review = driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
    Assert.assertTrue(review.isDisplayed());
    //13. Enter description in comment text area and click 'Place Order'
    rbt.mouseWheel(7);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testtest test");
    driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
    //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("szgnmm");
    driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234123412341324");
    driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
    driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("11");
    driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("25");
    //15. Click 'Pay and Confirm Order' button
    driver.findElement(By.xpath("//button[@id='submit']")).click();
    //16. Verify success message 'Your order has been placed successfully!'
    WebElement success = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
    Assert.assertTrue(success.isDisplayed());
    //17. Click 'Delete Account' button
    driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
    //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    // This page isn`t avaible

}




}
