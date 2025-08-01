package Model;

import java.util.List;

public class User {

	private int Pid;
	private String Name;
	private List<Book> Issued_books;

	public User() {

	}

	public User(int pid, String name, List<Book> issued_books) {
		super();
		Pid = pid;
		Name = name;
		Issued_books = issued_books;
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Book> getIssued_books() {
		return Issued_books;
	}

	public void setIssued_books(List<Book> issued_books) {
		Issued_books = issued_books;
	}

	@Override
	public String toString() {
		return "User [Pid=" + Pid + ", Name=" + Name + ", Issued_books=" + Issued_books + "]";
	}

}
