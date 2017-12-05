package com.asiainfo.service;

import com.asiainfo.dao.AccountDao;
import com.asiainfo.dao.TransInfoDao;
import com.asiainfo.db.myJDBAUnits;
import com.asiainfo.model.Account;
import com.asiainfo.model.TransInfo;

import java.sql.Connection;


public class TransService {

	public String trans(Account from, Account to, double amount) throws Exception {

        AccountDao accountDao = new AccountDao();
        TransInfoDao transInfoDao = new TransInfoDao();
		from.setAmount(from.getAmount()-amount);
		accountDao.updateAccount(from);
		String a=null;
		a.split("1");
		
		to.setAmount(to.getAmount()+amount);
		accountDao.updateAccount(to);
		
		TransInfo info = new TransInfo();
		info.setSourceAccount(from.getAccount());
		info.setSourceId(from.getId());
		info.setDestinationAccount(to.getAccount());
		info.setDestinationId(to.getId());
		info.setAmount(amount);
		transInfoDao.insert(info);
        return "success";
	}

	public String transaction(Account from, Account to, double amount) throws Exception {
		Connection conn= myJDBAUnits.getConnection();
		conn.setAutoCommit(false);
		try {
			    AccountDao accountDao = new AccountDao();
		        TransInfoDao transInfoDao = new TransInfoDao();
		        
		        from.setAmount(from.getAmount()-amount);
				accountDao.updateAccount(from);
				String a=null;
				a.split("1");
				
				to.setAmount(to.getAmount()+amount);
				accountDao.updateAccount(to);
				
				TransInfo info = new TransInfo();
				info.setSourceAccount(from.getAccount());
				info.setSourceId(from.getId());
				info.setDestinationAccount(to.getAccount());
				info.setDestinationId(to.getId());
				info.setAmount(amount);
				transInfoDao.insert(info);
				
				conn.commit();
		        return "success";
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			return "fail";
		}
	}
	

}
