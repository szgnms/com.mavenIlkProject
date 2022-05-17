package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;

public class h  {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://qa-environment.concorthotel.com/");
        driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        /*
        Home, Rooms, Restaurant, About, Blog, Contact,
        ve Log in butonlari gorunur olmali.
         */
        WebElement home = driver.findElement(By.xpath("(//*[@class='nav-link'])[1]"));
        Assert.assertTrue(home.isDisplayed());
        WebElement rooms = driver.findElement(By.xpath("(//*[@class='nav-link'])[2]"));
        Assert.assertTrue(rooms.isDisplayed());
        WebElement restaurant = driver.findElement(By.xpath("(//*[@class='nav-link'])[3]"));
        Assert.assertTrue(restaurant.isDisplayed());
        WebElement about = driver.findElement(By.xpath("(//*[@class='nav-link'])[4]"));
        Assert.assertTrue(about.isDisplayed());
        WebElement blog = driver.findElement(By.xpath("(//*[@class='nav-link'])[5]"));
        Assert.assertTrue(blog.isDisplayed());
        WebElement contact = driver.findElement(By.xpath("(//*[@class='nav-link'])[6]"));
        Assert.assertTrue(contact.isDisplayed());
        WebElement logIn = driver.findElement(By.xpath("(//*[@class='nav-link'])[7]"));
        Assert.assertTrue(logIn.isDisplayed());
    }

    @Test
    public void test2() throws InterruptedException {
        /*
        Navbar'da bulunan butonlar kullaniciyi ilgili
        sayfaya yonlendirmeli.
         */
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
    }

    @Test
    public void test3() throws InterruptedException {
        /*
        CHECK-IN DATE elementine tiklanir ve giris tarihi icin
     secim yapilir.
        CHECK-OUT DATE elementine tiklanir ve cikis tarihi icin
     secim yapilir.
        ROOM elementine tiklanir ve dropdown menuden uygun
     room type secilir.
        CUSTOMER elemtine tiklanir ve dropdown menuden
     yetiskin kisi sayisi sacilir.
         */
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,850)");
        driver.findElement(By.xpath("//*[@id='checkin_date']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='checkin_date']")).sendKeys("06/17/2022");
        //driver.findElement(By.xpath("//*[@id='checkout_date']")).click();
        driver.findElement(By.xpath("//*[@id='checkout_date']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='checkout_date']")).sendKeys("06/27/2022");
        WebElement dropDownRoom = driver.findElement(By.xpath("//*[@id='IDRoomType']"));
        Select select1 = new Select(dropDownRoom);
        Thread.sleep(2000);
        select1.selectByVisibleText("King");
        WebElement dropDownCustomer = driver.findElement(By.xpath("//*[@id='AdultCount']"));
        Select select2 = new Select(dropDownCustomer);
        select2.selectByIndex(2);
        driver.findElement(By.xpath("//input[@value='Check Availability']")).click();

    }

    @Test
    public void test4() throws AWTException {
        /*
        Welcome to our hotel bolumu gorunur olmali.
        Main Page'de ilgili bolum gorulene kadar scrolldown yapilir.
         */
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,850)");

    }

    @Test
    public void test5() throws InterruptedException {
        /*
        Our Rooms bolumu ve icerisindeki elementler
        gorunur ve tiklanabilir olmali.
         */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2100)");
        WebElement ourRoom = driver.findElement(By.xpath("/html/body/section[5]/div/div[1]"));
        Assert.assertTrue(ourRoom.isDisplayed());
        WebElement rm1 = driver.findElement(By.xpath("/html/body/section[5]"));
        Assert.assertTrue(rm1.isDisplayed());
        WebElement rm2 = driver.findElement(By.xpath("/html/body/section[5]"));
        Assert.assertTrue(rm2.isDisplayed());
        WebElement rm3 = driver.findElement(By.xpath("/html/body/section[5]"));
        Assert.assertTrue(rm3.isDisplayed());
        WebElement rm4 = driver.findElement(By.xpath("/html/body/section[5]"));
        Assert.assertTrue(rm4.isDisplayed());
        WebElement rm5 = driver.findElement(By.xpath("/html/body/section[5]"));
        Assert.assertTrue(rm5.isDisplayed());
        WebElement rm6 = driver.findElement(By.xpath("/html/body/section[5]"));
        Assert.assertTrue(rm6.isDisplayed());
    }
    @Test
    public void test6() throws InterruptedException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2100)");
        WebElement oda1 = driver.findElement(By.xpath("(//*[@class='btn-custom'])[1]"));
        driver.findElement(By.xpath("(//*[@class='btn-custom'])[1]")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement oda2 = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        oda2.click();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement oda3 = driver.findElement(By.xpath("(//a[@class='btn-custom'])[3]"));
        oda3.click();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement oda4 = driver.findElement(By.xpath("(//a[@class='btn-custom'])[4]"));
        oda4.click();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement oda5 = driver.findElement(By.xpath("(//a[@class='btn-custom'])[5]"));
        oda5.click();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement oda6 = driver.findElement(By.xpath("(//a[@class='btn-custom'])[6]"));
        oda6.click();
        Thread.sleep(2000);
        driver.navigate().back();
    }
}












