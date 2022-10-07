package model;

import dao.AccountDAO;
import model.data.Account;
import model.data.Login;

public class WithdrawLogic {
	public boolean exequte(Login login) {
		boolean result = false;
		LoginLogic loginLogic = new LoginLogic();
		AccountDAO accountDAO = new AccountDAO();
		
		Account account = loginLogic.exequte(login);
		
		if(account!=null) {
			result = accountDAO.deleteAccount(login);
		}
		
		return result;
	}
}
