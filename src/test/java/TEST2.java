import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadTxt;
import utilities.WriteToTxt;

public class TEST2 {
    @Test
    public void testName() {
        Assert.fail("test 2");

    }

    @Test
    public void test() {
        WriteToTxt.saveTitle("fille","icerik");
    }
}
