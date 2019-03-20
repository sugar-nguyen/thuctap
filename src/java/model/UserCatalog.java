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
            return list;
        } catch (Exception e) {
            return null;
        }

    }
}
