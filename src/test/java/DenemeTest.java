import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DenemeTest {
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
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://stackoverflow.com/");


    }

    @Test(groups = "smoke")
    public void testBase() {
    }
}
