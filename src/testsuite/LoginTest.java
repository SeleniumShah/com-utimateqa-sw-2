package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test

    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //Click on the 'Sign In' link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Verify the text Welcome Back!

        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("welcome", expectedText, actualText);

        sleep(5000);
    }

    @Test
    public void verifyTheErrorMessage(){
        //Click on the 'Sign In' link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123");

        //Enter invalid password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("prime");

        // Click on Sign In button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the error message Invalid email or password.
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Wrong details", expectedText, actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }
