package com.asiainfo.action;

import com.asiainfo.dao.GoddessDao;
import com.asiainfo.model.Goddess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MicroKibaco on 02/12/2017.
 */
public class GoddessAction {

    public static void main(String [] args) throws SQLException {

        GoddessDao gd = new GoddessDao();

        Goddess g = new Goddess();

        ArrayList<Map<String, Object>> params = new ArrayList<>();
        HashMap<String, Object> param = new HashMap<>();
        param.put("name","user_name");
        param.put("rela","like");
        param.put("value","'%China%'");
        params.add(param);
        param = new HashMap<>();
        param.put("name","mobile");
        param.put("rela","like");
        param.put("value","'%0123456789%'");
        params.add(param);
        List<Goddess> goddesses = gd.queryGoddess(params);
        for (int i = 0; i < goddesses.size(); i++) {
            System.out.println(goddesses.get(i).toString());
        }

    }

}
