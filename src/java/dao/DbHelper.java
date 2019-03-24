package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DbHelper {
    private static Connection con = null;
    public static Connection getConnection() {
        if (con == null) {
            //Doc file cau hinh properties
//            ResourceBundle bundle = ResourceBundle.getBundle("db");
//            String url = bundle.getString("url");
//            String user = bundle.getString("user");
//            String pwd = bundle.getString("pwd");
            try {
                Class.forName("com.mysql.jdbc.Driver");
//                con = DriverManager.getConnection(url, user, pwd);
                con = DriverManager.getConnection("jdbc:mysql://localhost/the_shit","root","");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    public static void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}