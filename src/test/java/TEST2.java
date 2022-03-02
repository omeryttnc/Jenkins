import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TEST2 {
    @Test
    public void testName() {
        Assert.fail("test 2");

    }
    public  void updateOneTime(String type, String data) {
        Connection connection;
        Statement statement;

        String string = "jdbc:mysql://51.15.253.0:3366/urbanicfarm";
        String username = "urbanicfarm_mysql_user";
        String password = "urbanicfarm_mysql_password";
        String sql = "UPDATE `tester` SET `"+type+"` = '"+data+"' WHERE `tester`.`id` = 1;";

        try {
            connection = DriverManager.getConnection(string, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = "smoke")
    public void test() {

        updateOneTime("skip","aaa");
        WriteToTxt.saveTitle("fille","icerik");
    }
}
