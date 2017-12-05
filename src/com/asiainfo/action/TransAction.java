package com.asiainfo.action;

import com.asiainfo.dao.AccountDao;
import com.asiainfo.model.Account;
import com.asiainfo.service.TransService;


public class TransAction {
  public static void main(String[] args) throws Exception {
	try {
		String res=trans();
		System.out.println(res);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}
  public static String trans() throws Exception{
	  AccountDao accountDao = new AccountDao();
	  TransService transService = new TransService();
	  
	  Account from=null;
	  Account to=null;
	  from =accountDao.get(2);
	  to=accountDao.get(1);
	  
	  return transService.transaction(from,to,10d);
	  
  }
}
