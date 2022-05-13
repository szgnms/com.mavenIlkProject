package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.time.Duration;


public class AutomationExercises {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPath-Plugin.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //1. Launch browser
        ChromeDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
//3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("html"));
        if (homePage.isDisplayed()){
            System.out.println("home page is visible successfully");
        }else System.out.println("home page isn`t visible ");
//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
//5. Verify 'New User Signup!' is visible
        WebElement newUSer =driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
        if (newUSer.isDisplayed()){
            System.out.println("'New User Signup!' is visible");
        }else System.out.println("'New User Signup!' isn`t visible ");
//6. Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("pass@word.com");
//7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement entAccInfo = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
        if (entAccInfo.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION' is visible");
        }else System.out.println("ENTER ACCOUNT INFORMATION' isn`t visible");
//9. Fill details: Title, Name, Email, Password, Date of birth

//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }
}
