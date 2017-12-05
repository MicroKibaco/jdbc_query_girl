package com.asiainfo.test;

import com.asiainfo.dao.ProduceDao;
import com.asiainfo.model.Goddess;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MicroKibaco on 04/12/2017.
 */
public class JDBCTestProduce {

    public static void main(String [] args) throws SQLException {

        ProduceDao dao = new ProduceDao();
       // dao.select_nofilter();
        String sp_name = "";
        List<Goddess> result = dao.select_filter(sp_name);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getId()+" : " + result.get(i).getUser_name()+
                    ":"+result.get(i).getAge());
        }

    }



}
