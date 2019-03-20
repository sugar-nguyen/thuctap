package model;

import entities.Devices;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class UserCatalog {

    List<Devices> ds = new ArrayList<>();

    public List<Devices> getList() throws ParseException {
//        Session ses = HibernateUtil.open();
//        ses.beginTransaction();
//        List<Devices> dsdv = ses.createQuery("from devices").list();
        SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");

        Devices dv1 = new Devices("123", dfm.parse("14/12/2019"), Byte.MAX_VALUE);
        Devices dv2 = new Devices("123", dfm.parse("14/12/2019"), Byte.MAX_VALUE);
        Devices dv3 = new Devices("123", dfm.parse("14/12/2019"), Byte.MAX_VALUE);
        Devices dv4 = new Devices("123", dfm.parse("14/12/2019"), Byte.MAX_VALUE);
        ds.add(dv1);
        ds.add(dv2);
        ds.add(dv3);
        ds.add(dv4);
        return ds;
    }
}
