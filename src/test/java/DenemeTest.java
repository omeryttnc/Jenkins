import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseDriver;
import utilities.Driver;

public class DenemeTest {
    void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    @Test(groups = "smoke")
    public void print() {
        System.out.println("smoke 2");
        System.out.println("sss");
    }

    @Test(groups = "smoke")
    public void testName() {
        System.out.println("smoke 3");
    }

    @Test
    public void testDriver() {

        Driver.getDriver().get("https://stackoverflow.com/");
        wait(100);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");
        Driver.closeDriver();


    }


    @Test
    public void testBase() {

        BaseDriver.getDriver().get("https://stackoverflow.com/");
        waitForPageToLoad(100);
        wait(100);
        String currentUrl = BaseDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");
        BaseDriver.DriverQuit();

    }


}
