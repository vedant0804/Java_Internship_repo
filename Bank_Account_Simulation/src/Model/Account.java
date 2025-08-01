package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

	private String Name;
	private double Balance;
	private List<String> Transaction_history;

	public Account() {
		super();
		this.Transaction_history = new ArrayList<>();
		
	}

	public Account(String name, double balance) {
		super();
		Name = name;
		this.Balance = balance;
		this.Transaction_history = new ArrayList<>();
	}

	public Account(String name) {
		super();
		Name = name;
		this.Balance = 0.0;
		this.Transaction_history = new ArrayList<>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		this.Balance = balance;
	}

	public List<String> getTransaction_history() {
		return Transaction_history;
	}

	public void setTransaction_history(List<String> transaction_history) {
		Transaction_history = transaction_history;
	}

	public void Deposit(double money) {
		if (money > 0) {
			this.Balance += money;
			Transaction_history.add("Deposite successfull of Rs " + money + LocalDateTime.now());
			System.out.println("Deposit Successful of " + money + " Rs Total Balance is " + Balance);
		}

	}
	public void Withdraw (Double Amount)
	{
		if(Amount < 0)
		{
			System.out.println("Enter valid Amount");
		}
		else if(Amount>Balance)
		{
			System.out.println("No sufficient Balance in the account");
		}
		Balance-=Amount;
		Transaction_history.add("Withdrawal successfull of Rs " + Amount + LocalDateTime.now());
		System.out.println("Withdrawal successful of Rs " + Amount + "Total balance is " + Balance);
	}

	@Override
	public String toString() {
		return "Account [Name=" + Name + ", balance=" + Balance + ", Transaction_history=" + Transaction_history + "]";
	}

}
