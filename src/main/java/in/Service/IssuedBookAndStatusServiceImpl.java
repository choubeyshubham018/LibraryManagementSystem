package in.Service;

import java.util.Date;
import java.util.List;

import in.Dao.IIssueBookAndStatus;
import in.DaoFactory.IssuedBookDaoFactory;
import in.dto.Book;
import in.dto.IssuedBooks;

public class IssuedBookAndStatusServiceImpl implements IIssueBookAndStatusService {

	IIssueBookAndStatus ibook;
	
	public IssuedBookAndStatusServiceImpl(){
		ibook=IssuedBookDaoFactory.getIssuedBook();
	}
	
	
	public String issueBook(Book book, String stdid) {
		Date date = new Date();
		
		return  ibook.issueBook(book, stdid, date);
	}

	public List<IssuedBooks> getIssuedStdBooks(String stdid) {
		
		return ibook.getBooks(stdid);
	}

	public Float returnIssuedBook(Book book, String stdid) {
		Date date = new Date();
		
		return ibook.submitBook(date, book, stdid);
	}


	public List<IssuedBooks> getIssuedBookList() {

		return ibook.getIssuedBookList();
	}

}
