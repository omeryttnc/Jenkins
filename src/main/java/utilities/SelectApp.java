package utilities;

import java.sql.*;

public class SelectApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect(String path) {
        // SQLite connection string
        String url = "jdbc:sqlite:" + path;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public void selectAll(String path, String tableName) {
        String sql = "SELECT * FROM " + tableName;

        try (Connection conn = this.connect(path);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getString("first_name") + "\t" +
                        rs.getInt("lat") + "\t" +
                        rs.getInt("lng"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }







    public void insert(String path,  int id, String skip, String  unskip) {
        String sql = "INSERT INTO " + "weekly" + "(id,skip,unskip) VALUES(?,?,?)";

        try (Connection conn = this.connect(path);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, skip);
            pstmt.setString(3, unskip);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }






















    public void insert2(String path, String tableName, int id, String url, String ProductName, int price) {
        String sql = "INSERT INTO " + tableName + "(id,url,ProductName,price) VALUES(?,?,?,?)";

        try (Connection conn = this.connect(path);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, url);
            pstmt.setString(3, ProductName);
            pstmt.setInt(4, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

//    public void update(String path, String tableName,int id, String name, double capacity) {
//        String sql = "UPDATE "+tableName+" SET name = ? , "
//                + "capacity = ? "
//                + "WHERE id = ?";
//
//        try (Connection conn = this.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            // set the corresponding param
//            pstmt.setString(1, name);
//            pstmt.setDouble(2, capacity);
//            pstmt.setInt(3, id);
//            // update
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
