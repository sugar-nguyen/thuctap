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

public class UserCatalog {

    List<User> list = new ArrayList<>();

    public List<User> getListUser() {
        try {
            Session ses = HibernateUtil.open();
            ses.beginTransaction();
            list = ses.createCriteria(User.class).list();
            if (!list.isEmpty()) {
                ses.getTransaction().commit();
                ses.close();
                return list;
            }
            ses.getTransaction().commit();
            ses.close();
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            HibernateUtil.close();
        }

    }

    public Boolean login(String username) {
        try {
            Session ses = HibernateUtil.open();
            ses.beginTransaction();
            User login_user = (User) ses.createQuery("from User where username = :username");
            if (login_user != null) {
                ses.getTransaction().commit();
                ses.close();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }finally{
            HibernateUtil.close();
        }
    }
}
