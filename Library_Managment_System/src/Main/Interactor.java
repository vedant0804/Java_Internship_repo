package Main;

import java.util.List;
import java.util.Scanner;

import Dao.Book_dao_impli;
import Dao.User_dao_impli;
import Model.Book;
import Model.User;
import service.Library_service;
import service.Library_service_impli;

public class Interactor {

	public static void main(String[] args) {

		Library_service ls = new Library_service_impli(new Book_dao_impli(), new User_dao_impli());
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Library managment System\n-----------------------------------------------");
		int choice = 0;
		do {
			System.out.println(
					"1.View Book\n2.View Users\n3.Issue book\n4.Return book\n5.Add user\n6.Add book\n7.Exit\n-----------------------------------------------");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Book> bks = ls.Available_books();
				if (bks != null) {
					for (Book bkl : bks) {
						System.out.println(bkl);
					}
				} else
					System.out.println("Sorry no books available");
				System.out.println("-----------------------------------------------");
				break;
			case 2:
				List<User> uss = ls.All_users();
				if (uss != null) {
					for (User us : uss) {
						System.out.println(us);
					}
				} else
					System.out.println("Sorry no Users");
				System.out.println("-----------------------------------------------");
				break;
			case 3:
				System.out.println("Enter user id");
				int uid = sc.nextInt();
				System.out.println("Enter book id");
				int bid = sc.nextInt();
				boolean is = ls.Issue_book(uid, bid);
				if (is) {
					System.out.println("Book issued successfully");
				} else
					System.out.println("User id not found");

				break;
			case 4:
				System.out.println("Enter user id");
				int ui = sc.nextInt();
				System.out.println("Enter book id to be returned");
				int bi = sc.nextInt();
				boolean ans = ls.Return_book(ui, bi);
				if (ans) {
					System.out.println("Book returned successfully");
				} else
					System.out.println("Error returning book");
				break;
			case 5:
			     System.out.println(ls.Add_user());
				break;
			case 6:
			     System.out.println(ls.Add_book());
				break;
			case 7:
				System.out.println("THANKYOU PROGRAM EXITED SUCCESSFULLY!!!!!!!!!!!!!!!!!!");
				break;
			default:
				break;

			}

		} while (choice != 7);
	}
}
