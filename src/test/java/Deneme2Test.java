import org.testng.annotations.Test;

public class Deneme2Test {
    @Test
    public void print() {
        System.out.println("Hello World");
        System.out.println("sss");
    }

    @Test(groups = "smoke")
    public void testName() {
        System.out.println("a");
    }
}
