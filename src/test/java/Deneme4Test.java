import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Deneme4Test {
    WebDriver driver;


    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test(groups = "regression")
    public void testName() throws InterruptedException {
        setUp();
        Thread.sleep(5000);  // Let the user actually see something!


        driver.get("https://stackoverflow.com/");

        Thread.sleep(600000);  // Let the user actually see something!
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");

        Thread.sleep(50000);  // Let the user actually see something!

        driver.quit();
    }
}
