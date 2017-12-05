package com.asiainfo.dao;

import com.asiainfo.db.DBUtil;
import com.asiainfo.model.Goddess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MicroKibaco on 04/12/2017.
 */
public class ProduceDao {

    public static List<Goddess> select_filter(String sp_name) throws SQLException {
        Connection conn = DBUtil.getConnection();
        List<Goddess> gs=new ArrayList<Goddess>();
        CallableStatement call = conn.prepareCall("call sp_select_nofiter(?)");
        call.setString(1,sp_name);
        call.execute();
        ResultSet rs = call.getResultSet();
        Goddess god = null;
        while (rs.next()){

            god = new Goddess();
            god.setId(rs.getInt("id"));
            god.setUser_name(rs.getString("user_name"));
            god.setAge(rs.getInt("age"));
            gs.add(god);

        }
        return gs;

    }

    public static void select_nofilter() throws SQLException {

        Connection conn = DBUtil.getConnection();
        CallableStatement call = conn.prepareCall("call sp_select_nofiter()");
        call.execute();
        ResultSet rs = call.getResultSet();

        while (rs.next()){

            System.out.println(rs.getString("user_name")+
                    rs.getString("email")+rs.getString("mobile"));

        }

    }

    public static List<Goddess> queryByProduce() throws SQLException {

        List<Goddess> result = new ArrayList<>();
        Goddess g = null;

        Connection conn = DBUtil.getConnection();
        CallableStatement call = conn.prepareCall("query_db.sp_select_nofiter()");
        call.execute();
        ResultSet rs = call.getResultSet();
        return result;

    }

    public static Integer select_count() throws SQLException {

        Integer count = 0;
        Connection conn = DBUtil.getConnection();
        CallableStatement call = conn.prepareCall("call sp_select_count(?)");
        call.registerOutParameter(1, Types.INTEGER);
        call.execute();
        count = call.getInt(1);
        return count;

    }

}
