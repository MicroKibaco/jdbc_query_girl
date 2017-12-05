package com.asiainfo.dao;

import com.asiainfo.db.DBCPUtil;
import com.asiainfo.db.myJDBAUnits;
import com.asiainfo.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AccountDao {
	


	public void addAccount(Account acc) throws Exception{
		Connection conn= myJDBAUnits.getConnection();
		String sql=""+"insert into account_info" +
				"(account,amount,create_at) values(?,?,current_date())";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, acc.getAccount());
		ptmt.setDouble(2, acc.getAmount());
//		ptmt.setDate(3, new Date(acc.getCreate_at().getTime()));
		ptmt.execute();
	}


	public void updateAccount(Account acc) throws Exception{
		Connection conn=myJDBAUnits.getConnection();
		conn.setAutoCommit(false);
		String sql=""+"update  account_info" +
				" set account=?,amount=? where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, acc.getAccount());
		ptmt.setDouble(2, acc.getAmount());
		ptmt.setInt(3, acc.getId());
		ptmt.execute();
	}


	public void delAccount(Integer id) throws Exception{
		Connection conn=myJDBAUnits.getConnection();
		String sql=""+"delete from account_info where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
	}


	 public Account get(Integer id) throws Exception{
		    Account acc=null;
		    Connection conn=myJDBAUnits.getConnection();
		    conn.setAutoCommit(false);
			String sql=""+"select * from account_info where id=?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				acc=new Account();
				acc.setId(rs.getInt("id"));
				acc.setAccount(rs.getString("account"));
				acc.setAmount(rs.getDouble("amount"));
				acc.setCreate_at(rs.getDate("create_at"));
			}
			return acc;
	 }


    public List<Account> query() throws Exception{
    	Connection conn=myJDBAUnits.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,account,amount,create_at from account_info");
		List<Account> ac=new ArrayList<Account>();
		Account acc=null;
		while(rs.next()){
			acc=new Account();
			acc.setId(rs.getInt("id"));
			acc.setAccount(rs.getString("account"));
			acc.setAmount(rs.getDouble("amount"));
			acc.setCreate_at(rs.getDate("create_at"));
			ac.add(acc);
			
		}
    	return ac;
    	
    }


    public List<Account> query(String account) throws Exception{
    	Connection conn=myJDBAUnits.getConnection();
    	List<Account> ac=new ArrayList<Account>();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from account_info");
		sb.append(" where account like ?");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1,"%"+account+"%");
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		Account acc=null;
		while(rs.next()){
			acc=new Account();
			acc.setId(rs.getInt("id"));
			acc.setAccount(rs.getString("account"));
			acc.setAmount(rs.getDouble("amount"));
			acc.setCreate_at(rs.getDate("create_at"));
			ac.add(acc);
			
		}
    	return ac;
    	
    }


    public List<Account> query(List<Map<String,Object>> params) throws Exception{
    	Connection conn=myJDBAUnits.getConnection();
    	List<Account> ac=new ArrayList<Account>();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from account_info where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for(int i=0;i<params.size();i++){
				Map<String,Object> map=params.get(i);
				sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
			}
		}
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		Account acc=null;
		while(rs.next()){
			acc=new Account();
			acc.setId(rs.getInt("id"));
			acc.setAccount(rs.getString("account"));
			acc.setAmount(rs.getDouble("amount"));
			acc.setCreate_at(rs.getDate("create_at"));
			ac.add(acc);
			
		}
    	return ac;
    	
    }


    public Account getByDbcpConn(Integer id) throws Exception{
	    DBCPUtil db=new DBCPUtil();
	    Connection conn=db.getConn();
	    Account acc=null;
		String sql=""+"select * from account_info where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			acc=new Account();
			acc.setId(rs.getInt("id"));
			acc.setAccount(rs.getString("account"));
			acc.setAmount(rs.getDouble("amount"));
			acc.setCreate_at(rs.getDate("create_at"));
		}
		return acc;
 }
  
}
