import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Deneme3Test {
    @Test(groups = "regression")
    public void name(){
        System.out.println("regression testi");
        System.out.println("s");
    }

    @Test(groups = "regression")
    public void testGoogleSearch() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
         System.setProperty("webdriver.chrome.driver", "C:/Users/savsa/Desktop/chromedriver_win32/chromedriver.exe");
         WebDriver driver = new ChromeDriver();


        Thread.sleep(5000);  // Let the user actually see something!


        driver.get("https://stackoverflow.com/");

        Thread.sleep(5000);  // Let the user actually see something!
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");

        Thread.sleep(5000);  // Let the user actually see something!

        driver.quit();

    }

}
