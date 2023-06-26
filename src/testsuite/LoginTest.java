package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // click on the sign in tab
        driver.findElement(By.xpath("//a [@href = '/users/sign_in']")).click();
        // verify the text Welcome back
        String expectedMessage = "Welcome Back!";
        String actualMessage = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Welcome Back",expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        // click on the sign in tab
        driver.findElement(By.xpath("//a [@href = '/users/sign_in']")).click();
        // Enter Invalid Username
        driver.findElement(By.id("user[email]")).sendKeys("khilen@yahoo.com");
        // Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("kh1234");
        //click on login button
        driver.findElement(By.xpath("//button [@type = 'submit']")).click();
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li [@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("Invalid email or password",expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
       // closeBrowser();
    }
}
