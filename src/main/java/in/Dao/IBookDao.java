package in.Dao;

import java.util.List;

import in.dto.Book;

public interface IBookDao extends IDao{

	String addBook(Book book);
	String deleteBook(String bTitle);
	List<Book> searchBook(Book book);
	List<Book> getBookList();
}
