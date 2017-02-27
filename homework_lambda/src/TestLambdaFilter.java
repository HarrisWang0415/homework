import java.util.*;

@FunctionalInterface
interface BookFilter {
	public boolean test(Book book);
}

enum Genre {
	ENGLISH, MATH, CHINESE;
}

class Book {
	private int pages;
	private Genre genre;

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPages() {
		return this.pages;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Genre getGenre() {
		return this.genre;
	}
}

public class TestLambdaFilter {

	public static List<Book> lambdaFilter(List<Book> bookList, BookFilter bookFilter) {
		List<Book> bookListFilter = new ArrayList<Book>();
		for (Book b : bookList) {
			if (bookFilter.test(b)) {
				bookListFilter.add(b);
			}
		}
		return bookListFilter;
	}

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<Book>();
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		b1.setGenre(Genre.ENGLISH);
		b2.setGenre(Genre.MATH);
		b3.setGenre(Genre.CHINESE);
		b1.setPages(300);
		b2.setPages(400);
		b3.setPages(500);
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);

		BookFilter bookFilter = (Book book) -> book.getPages() >= 400;
		List<Book> books = lambdaFilter(bookList, bookFilter);
		for (Book b : books) {
			System.out.println(b.getPages());
		}

		bookFilter = (Book book) -> book.getPages() >= 400 && book.getGenre() == Genre.MATH;
		books = lambdaFilter(bookList, bookFilter);
		for (Book b : books) {
			System.out.println(b.getPages() + " " + b.getGenre());
		}
	}
}