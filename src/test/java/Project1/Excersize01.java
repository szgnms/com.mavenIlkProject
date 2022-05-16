package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Excersize01 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPath-Plugin.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown() {
       // driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("trendyol" + Keys.ENTER);
        driver.findElement(By.xpath("//h3[contains(text(),'En Trend Ürünler Türkiye')]")).click();
        driver.findElement(By.xpath("//div[@title='Kapat']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")).sendKeys("avize" + Keys.ENTER);
        String trnHand=driver.getWindowHandle();
       String list  = driver.findElement(By.xpath("//div[@class='dscrptn']")).getText();
        String[] arr = list.split(" ");
        System.out.println("Listelenen urun sayisi : "+arr[3]);
        driver.switchTo().newWindow(WindowType.TAB).get("https://morhipo.com");
        driver.findElement(By.xpath("//input[@id='pw-search-input']")).sendKeys("avize"+Keys.ENTER);
        String morHand=driver.getWindowHandle();
        String morUrun=driver.findElement(By.xpath("//span[@id='total-product-count']")).getText();
        System.out.println("toplam urun sayisi"+morUrun);

        int trendyol =Integer.parseInt(arr[3]);

        int morhipo = Integer.parseInt(morUrun);

       Assert.assertTrue(trendyol>morhipo);
       driver.switchTo().window(trnHand);
       //driver.close();







        }

    }


