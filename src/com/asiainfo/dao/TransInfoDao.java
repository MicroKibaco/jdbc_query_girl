package com.asiainfo.dao;

import com.asiainfo.db.myJDBAUnits;
import com.asiainfo.model.TransInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TransInfoDao {


   public void insert(TransInfo transInfo) throws Exception{
	    Connection conn= myJDBAUnits.getConnection();
		String sql=""+"insert into trans_info" +
				"(source_id,source_account,destination_id,destination_account,amount) values(?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, transInfo.getSourceId());
		ptmt.setString(2, transInfo.getSourceAccount());
		ptmt.setInt(3, transInfo.getDestinationId());
		ptmt.setString(4, transInfo.getDestinationAccount());
		ptmt.setDouble(5, transInfo.getAmount());
		ptmt.execute();
   }

   public void update(TransInfo transInfo) throws Exception{
	    Connection conn=myJDBAUnits.getConnection();
		String sql=""+" update trans_info" +
				" set source_id=?,source_account=?,destination_id=?," +
				" destination_account=?,amount=? where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, transInfo.getSourceId());
		ptmt.setString(2, transInfo.getSourceAccount());
		ptmt.setInt(3, transInfo.getDestinationId());
		ptmt.setString(4, transInfo.getDestinationAccount());
		ptmt.setDouble(5, transInfo.getAmount());
		ptmt.setInt(6, transInfo.getId());
		ptmt.execute();
  }

   public void delete(Integer id) throws Exception{
	    Connection conn=myJDBAUnits.getConnection();
		String sql=""+"delete trans_info where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
  }

   public List<TransInfo> query(String source_account) throws Exception{
	    Connection conn=myJDBAUnits.getConnection();
   	    List<TransInfo> tr=new ArrayList<TransInfo>();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from trans_info");
		sb.append(" where source_account like ?");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1,"%"+source_account+"%");
		
		ResultSet rs = ptmt.executeQuery();
		TransInfo t=null;
		while(rs.next()){
			t=new TransInfo();
			t.setId(rs.getInt("id"));
			t.setSourceAccount(rs.getString("source_account"));
			t.setSourceId(rs.getInt("source_id"));
			t.setDestinationAccount(rs.getString("destination_account"));
			t.setDestinationId(rs.getInt("destination_id"));
			t.setAmount(rs.getDouble("amount"));
			t.setCreateAt(rs.getDate("create_at"));
			tr.add(t);
			
		}
   	return tr;
   	
   }
}
