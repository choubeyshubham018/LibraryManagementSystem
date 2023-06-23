package in.Service;

import java.util.List;

import in.dto.Book;
import in.dto.IssuedBooks;

public interface IIssueBookAndStatusService {

	String issueBook(Book book,String stdid);
	
	List<IssuedBooks> getIssuedStdBooks(String stdid);
	
	List<IssuedBooks> getIssuedBookList();
	
	Float returnIssuedBook(Book book,String stdid);
}
