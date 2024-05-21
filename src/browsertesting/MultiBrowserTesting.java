package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */

public class MultiBrowserTesting {

    static String browser = "edge";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // Launch the browser
        if (browser.equalsIgnoreCase("Chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();
        else if (browser.equalsIgnoreCase("Firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("Browser name not valid");

        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //To get the title of the page
        System.out.println("Title of page " + driver.getTitle());
        //Get current URL
        System.out.println("Current URL " + driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page source " + driver.getPageSource());

        driver.findElement(By.linkText("Sign In")).click();
        System.out.println("Current URL " + driver.getCurrentUrl());

        //Enter credentials
        driver.findElement(By.id("user[email]")).sendKeys("test@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("test123");
        //click login
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        //navigate to base url
        driver.navigate().to(baseUrl);
        //navigate forward
        driver.navigate().forward();
        driver.navigate().to(baseUrl);
        //refresh the page
        driver.navigate().refresh();
        //close browser
        driver.quit();


    }

}
