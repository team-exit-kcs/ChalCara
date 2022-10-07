package model;

import dao.AccountDAO;
import model.data.Account;
import model.data.Login;

public class LoginLogic {
	public Account exequte(Login login) {
		AccountDAO accountDAO = new AccountDAO();
		return accountDAO.findByAccount(login);
	}
}
