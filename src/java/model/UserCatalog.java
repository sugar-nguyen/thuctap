package model;

import entities.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import dao.DbHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCatalog {

    public List<User> getListUser() {
        try {
            List<User> list = new ArrayList<>();
            String sql = "select * from user";
            PreparedStatement prepare = (PreparedStatement) DbHelper.getConnection().prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPassWord(rs.getString(4));
                user.setDateSignup(rs.getDate(5));
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbHelper.close();
        }
        return null;
    }

    public Boolean login(String username, String password) {
        try {
            String sql = "Select * From user Where username = ? and pass_word = ?";
            PreparedStatement pspm = DbHelper.getConnection().prepareStatement(sql);
            pspm.setString(1, username);
            pspm.setString(2, password);
            ResultSet rs= pspm.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
