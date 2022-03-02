import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.SelectApp;

public class DataBase {

    SelectApp selectApp =  new SelectApp();
    @Test
    void name() {
        String path = "onetime.db";
        selectApp.insert(path,3,"skip1","skip2");

    }


}
