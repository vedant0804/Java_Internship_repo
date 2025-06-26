package service;

import java.util.List;

import Model.Book;
import Model.User;

public interface Library_service {

	public boolean Add_book(Book book);

	public boolean Issue_book(int id, int book_id);

	public boolean Return_book(int id, int book_id);

	public String Add_user();
	
	public String Add_book();
	
	public List<Book>Available_books();
	
	public List<User>All_users();
}
