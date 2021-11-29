import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.BaseDriver;
import utilities.Driver;

public class Deneme4Test {
    WebDriver driver;




    @Test(groups = "regression")
    public void testName() throws InterruptedException {

        Thread.sleep(5000);  // Let the user actually see something!


        Driver.getDriver().get("https://stackoverflow.com/");

        Thread.sleep(5000);  // Let the user actually see something!
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");

        Thread.sleep(5000);  // Let the user actually see something!

    }
}
