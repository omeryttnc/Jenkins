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
    @Test(groups = "smoke")
    public void print() {
        System.out.println("smoke 2");
        System.out.println("sss");
    }

    @Test(groups = "smoke")
    public void testName() {
        System.out.println("smoke 3");
    }

    @Test(groups = "regression")
    public void testDriver() {

        Driver.getDriver().get("https://stackoverflow.com/");
        wait(10);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");
        Driver.closeDriver();


    }


    @Test(groups = "regression")
    public void testBase() {

        BaseDriver.getDriver().get("https://stackoverflow.com/");
        wait(10);
        String currentUrl = BaseDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://stackoverflow.com/");
        BaseDriver.DriverQuit();

    }


}
