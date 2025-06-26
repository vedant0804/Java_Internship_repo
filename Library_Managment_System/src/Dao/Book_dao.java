package Dao;

import java.util.List;

import Model.Book;

public interface Book_dao {

	public boolean Addbook(Book book);

	public boolean Remove_book(int id);
	
	public List<Book> Available_books();
}
