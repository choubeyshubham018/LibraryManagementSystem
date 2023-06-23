package in.Service;

import java.util.List;

import in.dto.Book;

public interface IBookService {

	String addBook(Book book);
	String deleteBook(String bTitle);
	List<Book> searchBook(Book book);
	List<Book> getBookList();
}
