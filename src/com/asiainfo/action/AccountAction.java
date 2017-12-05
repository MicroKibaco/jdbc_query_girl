package com.asiainfo.action;

import com.asiainfo.dao.AccountDao;
import com.asiainfo.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class AccountAction {
   public static void main(String[] args) throws Exception {
	AccountDao a=new AccountDao();

	List<Map<String,Object>> params=new ArrayList<Map<String,Object>>();
	Map<String,Object> param=new HashMap<String,Object>();
	param.put("name", "account");
	param.put("rela", "like");
	param.put("value", "'%ma%'");
	params.add(param);
	List<Account> result2 = a.query(params);
	for (int i = 0; i < result2.size(); i++) {
		System.out.println(result2.get(i).toString());
	}

	
	a.delAccount(3);
	

	List<Account> ac=a.query();
	for (Account account : ac) {
		System.out.println(account.getId()+"\t"+account.getAccount()+"\t"
	+account.getAmount()+"\t"+account.getCreate_at());
	}
}
}
