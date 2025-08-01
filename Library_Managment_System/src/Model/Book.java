package Model;

public class Book {
	private int Book_id;
	private String Book_name;
	private boolean Is_issued;
	private String Author_name;
	private boolean Is_available;

	public Book() {

	}

	public Book(int book_id, String book_name, boolean is_issued, String author_name, boolean is_available) {
		super();
		Book_id = book_id;
		Book_name = book_name;
		Is_issued = is_issued;
		Author_name = author_name;
		Is_available = is_available;
	}

	public int getBook_id() {
		return Book_id;
	}

	public void setBook_id(int book_id) {
		Book_id = book_id;
	}

	public String getBook_name() {
		return Book_name;
	}

	public void setBook_name(String book_name) {
		Book_name = book_name;
	}

	public boolean isIs_issued() {
		return Is_issued;
	}

	public void setIs_issued(boolean is_issued) {
		Is_issued = is_issued;
	}

	public String getAuthor_name() {
		return Author_name;
	}

	public void setAuthor_name(String author_name) {
		Author_name = author_name;
	}

	public boolean isIs_available() {
		return Is_available;
	}

	public void setIs_available(boolean is_available) {
		Is_available = is_available;
	}

	@Override
	public String toString() {
		return "Book [Book_id=" + Book_id + ", Book_name=" + Book_name + ", Is_issued=" + Is_issued + ", Author_name="
				+ Author_name + ", Is_available=" + Is_available + "]";
	}

}