package Cards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LIQ_Payment {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.pokoopka.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("Selenium");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='form']/a[1]")).click();
        driver.findElement(By.linkText("Пополнить счёт")).click();

        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("10");
        driver.findElement(By.id("mode_type_3")).click();
        driver.findElement(By.id("send_message")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertTrue(isElementPresent(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[4]/div[2]/div/div[2]/div[2]/input")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
