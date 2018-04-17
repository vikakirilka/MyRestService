package org.ITstep.service;

import org.ITstep.dao.AccountDAO;
import org.ITstep.model.Account;

public class AccountService {
	
	AccountDAO accDAO = new AccountDAO();
	
	public Long convertDate(String date) {
		
		
		return null;
	}
	
	public Account saveAccount(Account account) {
		return accDAO.save(account);
	}

}
