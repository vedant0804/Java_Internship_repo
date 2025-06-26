package Model;

import java.util.List;

public class Library {

	private List<Book> Books;
	private List<User> users;

	public Library() {
		super();
	}

	public Library(List<Book> books, List<User> users) {
		super();
		Books = books;
		this.users = users;
	}

	public List<Book> getBooks() {
		return Books;
	}

	public void setBooks(List<Book> books) {
		Books = books;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Library [Books=" + Books + ", users=" + users + "]";
	}

}
