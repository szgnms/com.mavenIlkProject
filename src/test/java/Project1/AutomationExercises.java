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
        if (homePage.isDisplayed()) {
            System.out.println("home page is visible successfully");
        } else System.out.println("home page isn`t visible ");
//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
//5. Verify 'New User Signup!' is visible
        WebElement newUSer = driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
        if (newUSer.isDisplayed()) {
            System.out.println("'New User Signup!' is visible");
        } else System.out.println("'New User Signup!' isn`t visible ");
        loginMethodu(driver);

//16. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//li[9]//a[1]"));
        if (logged.isDisplayed()) {
            System.out.println("Logged in as username' is visible");
        } else System.out.println("Logged in as username' isn`t visible");

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement delAccount = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
        String arananKelime = "ACCOUNT DELETED!";
        if (delAccount.equals(arananKelime)) {
            System.out.println("'ACCOUNT DELETED!' is visible");
        } else System.out.println("'ACCOUNT DELETED!' isn`t visible");
        driver.close();
    }

    private static void signupMethodu(ChromeDriver driver) {
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement entAccInfo = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
        if (entAccInfo.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION' is visible");
        } else System.out.println("ENTER ACCOUNT INFORMATION' isn`t visible");
//9. Fill details: Title, Name, Email, Password, Date of birth
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
//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//label[@for='optin']")).click();
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
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
//13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
//14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        if (accCreate.isDisplayed()) {
            System.out.println("'ACCOUNT CREATED!' is visible");
        } else System.out.println("'ACCOUNT CREATED!' isn`t visible ");
//15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }

    private static void loginMethodu(ChromeDriver driver) {
//6. Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("pass@word.com");
//7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        WebElement already = driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"));
        if (already.isDisplayed()) {
            driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pass@word.com");
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        } else {
            signupMethodu(driver);
        }
    }
}
