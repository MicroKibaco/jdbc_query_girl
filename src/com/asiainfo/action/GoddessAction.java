package com.asiainfo.action;

import com.asiainfo.dao.GoddessDao;
import com.asiainfo.model.Goddess;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by MicroKibaco on 02/12/2017.
 */
public class GoddessAction {

    public static void main(String [] args) throws SQLException {

        GoddessDao gd = new GoddessDao();

        Goddess g = new Goddess();

        g.setUser_name("China");
        g.setAge(21);
        g.setSex(1);
        g.setBirthday(new Date());
        g.setEmail("yzy569015640@gmail.com");
        g.setMobile("0123456789");
        g.setUpdate_user("TinyBin");
        g.setIsdel(1);
        g.setId(3);

     //   gd.addGoddess(g);
      //  gd.delGoddess(3);
        List<Goddess> goddesses = gd.queryGoddess();
        for (Goddess goddess : goddesses) {
            System.out.println(goddess.toString());
        }

    }

}
