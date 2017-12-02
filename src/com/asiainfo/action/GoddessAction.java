package com.asiainfo.action;

import com.asiainfo.dao.GoddessDao;
import com.asiainfo.model.Goddess;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by MicroKibaco on 02/12/2017.
 */
public class GoddessAction {

    public static void main(String [] args) throws SQLException {

        GoddessDao gd = new GoddessDao();

        Goddess g = new Goddess();

        g.setUser_name("小夏");
        g.setAge(22);
        g.setSex(1);
        g.setBirthday(new Date());
        g.setEmail("yzy569015640@gmail.com");
        g.setMobile("18390833563");
        g.setCreate_user("Admin");
        g.setUpdate_user("Admin");
        g.setIsdel(1);

        gd.addGoddess(g);

    }

}
