package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
     public void verifyUserCanLoginSuccessfully() {

        driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();

        String expectedmessage = "Welcome Paul";
        WebElement message = driver.findElement(By.xpath("//div[@id='branding']/a[text()='Welcome Paul']"));
        String actualmessage = message.getText();
        Assert.assertEquals("", expectedmessage, actualmessage);

        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        driver.findElement(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a")).click();

        driver.findElement(By.xpath("//div[text()='LOGIN Panel']"));

        String expectedmessage2 = "LOGIN Panel";
        WebElement message2 = driver.findElement(By.xpath("//div[@id='divLoginForm']/form/div[1]"));
        String actualmessage2 = message2.getText();
        Assert.assertEquals("LOGIN Panel", expectedmessage2, actualmessage2);

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}


