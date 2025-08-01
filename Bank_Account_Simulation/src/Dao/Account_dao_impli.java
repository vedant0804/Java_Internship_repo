package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Account;

public class Account_dao_impli implements Account_dao {

	private static List<Account> users;
	static {
		users = new ArrayList<>();
		users.add(new Account("naman", 20000.0));
		users.add(new Account("kaushik", 200000.0));
	}
	@Override
	public List<Account> All_accounts() {
		// TODO Auto-generated method stub
		return users;
	}
}
