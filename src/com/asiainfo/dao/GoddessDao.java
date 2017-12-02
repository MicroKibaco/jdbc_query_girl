package com.asiainfo.dao;

import com.asiainfo.db.DBUtil;
import com.asiainfo.model.Goddess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MicroKibaco on 02/12/2017.
 */
public class GoddessDao {

    public void addGoddess(){

        Connection conn = DBUtil.getConnection();

    }

    public void updateGoddess(){

    }

    public void delGoddess(){

    }

    public List<Goddess> queryGoddess() throws SQLException{

        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select user_name,age from query_girl");

        List<Goddess> gs = new ArrayList<>();
        Goddess g = null;

        while (rs.next()){
            g = new Goddess();
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);
        }
        
        return gs;

    }

    public Goddess getGoddess(){
        return null;
    }

}
