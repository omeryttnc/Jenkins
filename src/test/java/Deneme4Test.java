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




    @Test
    public void testName() throws InterruptedException {

        Thread.sleep(5000);  // Let the user actually see something!

BaseDriver.threadBrowserName.get();
        BaseDriver.getDriver().get("https://stackoverflow.com/");

        Thread.sleep(5000);  // Let the user actually see something!
        String currentUrl = BaseDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");


    }

    @Test(groups = "regression")
    public void testDriver() throws InterruptedException {
        System.out.println("1");
        Thread.sleep(5000);  // Let the user actually see something!
        System.out.println("2");

        Driver.getDriver().get("https://stackoverflow.com/");
        System.out.println("3");
        try {
            Thread.sleep(5000);  // Let the user actually see something!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4");
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("5");
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");
        System.out.println("6");

        try {
            Thread.sleep(5000);  // Let the user actually see something!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("7");
    }
}
