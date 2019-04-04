package model;

import entities.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import dao.DbHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCatalog {

    public List<User> getListUser() {
        List<User> list = new ArrayList<>();
        try {
            String sql = "Select * From user";
            PreparedStatement prepare = DbHelper.getConnection().prepareStatement(sql);
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
        }
        return list;
    }

    public BooleanResult login(String username, String password) {
        try {
            String sql = "Select * From user Where username = ? and pass_word = ?";
            PreparedStatement pspm = DbHelper.getConnection().prepareStatement(sql);
            pspm.setString(1, username);
            pspm.setString(2, password);
            ResultSet rs = pspm.executeQuery();
            if (rs.next()) {
                return new BooleanResult(true);
            }
            return new BooleanResult(false);
        } catch (SQLException ex) {
            Logger.getLogger(UserCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new BooleanResult(false);
    }

    public BooleanResult register(String username, String password, String email) {
        try {
            String checkSql = "Select * From user Where username = ? Or email = ?";
            PreparedStatement Checkpspm =DbHelper.getConnection().prepareStatement(checkSql);
            Checkpspm.setString(1, username);
            Checkpspm.setString(2, email);
             ResultSet rs =  Checkpspm.executeQuery();
            if (rs.next()) {
                return new BooleanResult(false);
            }
            Date date = new Date();
            User user = new User(email, username, password, date);
            String sql = "Insert into user(username, pass_word, email, date_signup) Values(?,?,?,?)";
            PreparedStatement pspm = DbHelper.getConnection().prepareStatement(sql);
            pspm.setString(1, user.getUsername());
            pspm.setString(2, user.getPassWord());
            pspm.setString(3, user.getEmail());
            java.sql.Date sqlDate = new java.sql.Date(user.getDateSignup().getTime());
            pspm.setDate(4, (java.sql.Date) sqlDate);
            int effectRow = pspm.executeUpdate();
            if(effectRow >0){
                return new BooleanResult(true);
            }
            return new BooleanResult(false);
        } catch (SQLException ex) {
            Logger.getLogger(UserCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return new BooleanResult(false);
    }
}
