package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Book;

public class Book_dao_impli implements Book_dao {

	private static List<Book> books;
	static {
		books = new ArrayList<>();
		books.add(new Book(1, "Harry potter", false, "J.K.Rowlins", true));
		books.add(new Book(2, "Atomic habits", false, "A.B.C", true));
	}

	@Override
	public boolean Addbook(Book book) {
		for (Book bks : books) {
			if (bks.getBook_id() == book.getBook_id()) {
				return false;
			}
		}
		books.add(book);
		return true;
	}

	@Override
	public boolean Remove_book(int id) {
		for (Book book : books) {
			if (book.getBook_id() == id) {
				books.remove(book);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Book> Available_books() {
		// TODO Auto-generated method stub
		List<Book> avail= new ArrayList<>();
		for(Book book :books)
		{
			if(book.isIs_available()==true)
			{
			   avail.add(book); 
			}
		}
		if(avail!=null)
		{
			return avail;
		}
		else
			
		return null;
	}

	


}
