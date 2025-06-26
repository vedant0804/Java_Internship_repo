package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Dao.Book_dao;
import Dao.User_dao;
import Model.Book;
import Model.User;

public class Library_service_impli implements Library_service {

	private Book_dao bkd;
	private User_dao usd;

	Scanner sc = new Scanner(System.in);

	public Library_service_impli() {

	}

	public Library_service_impli(Book_dao bkd, User_dao usd) {
		super();
		this.bkd = bkd;
		this.usd = usd;
	}

	@Override
	public boolean Add_book(Book book) {

		if (bkd.Addbook(book)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean Issue_book(int id, int book_id) {
		List<Book> books = bkd.Available_books();
		User user = usd.Find_byid(id);
		if (user == null) {
			return false;
		}
	
		for (Book bks : books) {
			if(user.getIssued_books()==null)
			{
				List<Book> issuedbook = new ArrayList<>();
				issuedbook.add(bks);
				user.setIssued_books(issuedbook);
				bks.setIs_available(false);
				bks.setIs_issued(true);
				return true;
			}
			else if (book_id == bks.getBook_id()) {
				bks.setIs_issued(true);
				bks.setIs_available(false);
				List<Book> issuedbook = user.getIssued_books();
				issuedbook.add(bks);
				user.setIssued_books(issuedbook);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean Return_book(int id, int book_id) {
		User user = usd.Find_byid(id);
		if (user != null) {
			List<Book> user_books = user.getIssued_books();
			if (user_books != null) {
				for (Book bks : user_books) {
					if (bks.getBook_id() == book_id) {
						bks.setIs_available(true);
						bks.setIs_issued(false);
						user_books.remove(bks);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String Add_user() {
		User us = new User();
		System.out.println("Enter User Id");
		us.setPid(sc.nextInt());
		System.out.println("Enter User name");
		us.setName(sc.next());
		us.setIssued_books(null);
		boolean val = usd.Add_user(us);
		if (val) {
			return "USER CREATED SUCCESSFULLY USER ID IS :" + us.getPid();
		}

		return "FAILED TO CREATE USER";
	}

	@Override
	public String Add_book() {
		// TODO Auto-generated method stub
		Book bk = new Book();
		System.out.println("Enter book id");
		bk.setBook_id(sc.nextInt());
		System.out.println("Enter Book name");
		bk.setBook_name(sc.next());
		System.out.println("Enter book Author name");
		bk.setAuthor_name(sc.next());
		System.out.println("is Book Available Enter yes or no");
		String check = sc.next();
		if (check.toLowerCase() == "yes") {
			bk.setIs_available(true);
			bk.setIs_issued(false);
		} else {
			bk.setIs_available(false);
			bk.setIs_issued(true);
		}
		boolean val = bkd.Addbook(bk);
		if (val) {
			return "Book Added successfully Id is " + bk.getBook_id();
		}

		return "Book Id Already exists " + bk.getBook_id();
	}

	@Override
	public List<Book> Available_books() {
		List<Book> bks = bkd.Available_books();
		if (bks == null) {
			return null;
		}
		return bks;
	}

	@Override
	public List<User> All_users() {
		 List<User> us = usd.All_user();
		 if(us!=null)
		 {
			 return us;
		 }
		return null;
	}

}
