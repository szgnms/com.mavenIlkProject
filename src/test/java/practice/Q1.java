package practice;

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

import java.awt.*;
import java.io.File;
import java.time.Duration;

public class Q1 {


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
    public void tearDown(){
     // close driver
        driver.close();
 }

 @Test
    public void test() throws AWTException {
     //Navigate to website  https://testpages.herokuapp.com/styled/index.html
     driver.get(" https://testpages.herokuapp.com/styled/index.html");
     // Under the  ORIGINAL CONTENTS
     Robot rbt =new Robot();
     rbt.mouseWheel(20);
     // click on Alerts
     driver.findElement(By.xpath("//a[@id='alerts']")).click();
     //print the URL
     System.out.println("Alerts Url = "+driver.getCurrentUrl());
     //navigate back
     driver.navigate().back();
     //print the URL
     System.out.println("Home Url ="+driver.getCurrentUrl());
     // Click on Basic Ajax
     driver.findElement(By.xpath("//a[@id='basicajax']")).click();
     // print the URL
     System.out.println("Ajax Url ="+driver.getCurrentUrl());
     // enter value-> 20 and Enter
     driver.findElement(By.xpath("//input[@id='lteq30']")).sendKeys("20"+ Keys.ENTER);
     // and then verify Submitted Values is displayed open page
     WebElement subVal = driver.findElement(By.xpath("//p[normalize-space()='Submitted Values']"));
     Assert.assertTrue(subVal.isDisplayed());



 }

}
