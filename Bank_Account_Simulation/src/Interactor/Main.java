package Interactor;

import java.util.List;

import Model.Account;

public class Main {

	public static void main(String[] args) {
		
		Account acc= new Account("suersh");
		acc.Deposit(10000);
		acc.getTransaction_history();
		acc.Withdraw(7000.0);
		List<String>ass=acc.getTransaction_history();
		System.out.println(ass);
		System.out.println(acc);
	}
}
