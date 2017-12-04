package com.asiainfo.test;

import com.asiainfo.action.GoddessAction;
import com.asiainfo.model.Goddess;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MicroKibaco on 04/12/2017.
 */
public class TestAction {

    public static void main(String[] arg) throws Exception {
        GoddessAction action = new GoddessAction();
       /* 查询 List<Goddess> result = action.query();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());
        }*/

        Goddess g = new Goddess();
        g.setUser_name("Admin");
        g.setSex(1);
        g.setAge(24);
        g.setBirthday(new Date());
        g.setEmail("569015640@qq.com");
        g.setMobile("18390833563");
        g.setIsdel(10);
        g.setId(4);
       // action.add(g);

       // action.edit(g);
       // action.del(4);

        List<Map<String,Object>> params = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name","user_name");
        map.put("rela","=");
        map.put("value","'小美'");
        params.add(map);


    }

}
