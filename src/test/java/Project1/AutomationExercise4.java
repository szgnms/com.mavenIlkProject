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

import java.io.File;
import java.time.Duration;

public class AutomationExercise4 {
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
        driver.quit();
    }

    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement verifyLogin = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(verifyLogin.isDisplayed());
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pass@word.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement verifyLogged = driver.findElement(By.xpath("//li[9]//a[1]"));
        Assert.assertTrue(verifyLogged.isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        //10. Verify that user is navigated to login page
        WebElement verifyLogin2 = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(verifyLogin2.isDisplayed());
    }
}
