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

public class BestBuyAssertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //        ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

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
        //driver.close();
}

@Test
    public void test() {
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    driver.get(" https://www.bestbuy.com/");
    //        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
     Assert.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
    //        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
      Assert.assertFalse(driver.getTitle().contains("Rest"));
    //        ○ logoTest => BestBuy logosunun görüntülendigini test edin
       Assert.assertTrue(driver.findElement(By.xpath("//div[@lang='en']//img[@alt='Best Buy Logo']")).isDisplayed());
    //        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
       Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());




}

}
