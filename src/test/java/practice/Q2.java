package practice;

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

public class Q2 {

    WebDriver driver;
    ChromeOptions options;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPath-Plugin.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //    9.  Tum sayfalari kapatiniz
        driver.quit();
    }

    @Test
    public void test() {
        //    1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        //    2.  Bir mail adersi giriniz
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pass@word.com");
        //    3.  Bir password giriniz
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        //    4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//button[@name='commit']")).click();
        //    5.  "There was a problem with your login." texti gorunur ise
        WebElement login = driver.findElement(By.xpath("//div[@role='alert']"));
        //    6.  "kayit yapilamadi" yazdiriniz
        //    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
       try {
           Assert.assertEquals("There was a problem with your login.", login.getText());
           System.out.println("kayit yapilamadi");
        } catch (Exception e) {
            System.out.println("Kayit Yapildi");
        }


    }

}
