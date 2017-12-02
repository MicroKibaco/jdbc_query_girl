package com.asiainfo.action;

import com.asiainfo.dao.GoddessDao;
import com.asiainfo.model.Goddess;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MicroKibaco on 02/12/2017.
 */
public class GoddessAction {

    public static void main(String [] args) throws SQLException {

        GoddessDao g = new GoddessDao();

        List<Goddess> gs = g.queryGoddess();

        for (Goddess goddess : gs) {

            System.out.println(goddess.getUser_name()+","+goddess.getAge());

        }

    }

}
