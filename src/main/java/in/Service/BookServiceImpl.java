package in.Service;

import java.util.List;

import in.Dao.IBookDao;
import in.DaoFactory.BookDaoFactory;
import in.dto.Book;

public class BookServiceImpl implements IBookService {
    
	IBookDao ibook=BookDaoFactory.getBook();
	public String addBook(Book book) {
   
		return ibook.addBook(book);
	}

	public String deleteBook(String bTitle) {
		
		return ibook.deleteBook(bTitle);
	}

	public List<Book> searchBook(Book book) {
		return ibook.searchBook(book);
	}

	public List<Book> getBookList() {
		return ibook.getBookList();
	}

}
