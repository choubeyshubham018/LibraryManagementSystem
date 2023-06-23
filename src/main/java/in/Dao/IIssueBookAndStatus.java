package in.Dao;
import java.util.*;

import in.dto.Book;
import in.dto.IssuedBooks;

public interface IIssueBookAndStatus extends IDao{
List<IssuedBooks> getBooks(String stdId);
List<IssuedBooks> getIssuedBookList();
Float submitBook(Date subDate,Book book,String stdid);
String issueBook(Book book,String stdid,Date date);
void removeRecord(String bTitle,String stdid);
}
