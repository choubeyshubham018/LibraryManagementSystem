package in.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import in.dto.Book;
import in.dto.IssuedBooks;
import in.jdbcUtil.JdbcUtil;

public class IssueBookAndStatusImpl implements IIssueBookAndStatus{

	 private Connection connection;
	
	
	 public IssueBookAndStatusImpl() {
		 connection = JdbcUtil.getConnection();
		
	}
	 public String issueBook(Book book, String stdid, java.util.Date iDate) {
		 String sqlQuery1="insert into issued_books(`stdid`,`bTitle`,`bAuthor`,`bCategory`,`doi`)values(?,?,?,?,?)";
		 
		 try {
			 //Checking Particular Id Available in the Data base or not
			 String validate = validateStdid(stdid);
			 System.out.println(validate);
			 if(validate!=null) {
			PreparedStatement pst = connection.prepareStatement(sqlQuery1);
			if(pst!=null) {
				pst.setString(1, stdid);
				pst.setString(2, book.getbTitle());
				pst.setString(3, book.getbAuthor());
				pst.setString(4, book.getbCategory());
				pst.setDate(5, new java.sql.Date(iDate.getTime()));
				int status = pst.executeUpdate();
				if(status>0) {
					String bookStatus = updateIssuedBookStatus(book);
					System.out.println(bookStatus);
					return "success";
				}
			}}
			else {
				return "id not found";
			}
			
		} catch (SQLException e) {
		  e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}

	@SuppressWarnings("deprecation")
	public Float submitBook(java.util.Date subDate,Book book,String stdid) {
		Date doi=null;
		String sqlQuery1="Select `doi` from issued_books where stdid=? and bTitle=? and bAuthor=? ";
		
		Float fine=0f;
		try {
			
			PreparedStatement pst1 = connection.prepareStatement(sqlQuery1);
			if(pst1!=null) {
				
				pst1.setString(1, stdid);
				pst1.setString(2, book.getbTitle());
				pst1.setString(3, book.getbAuthor());
				ResultSet resultSet = pst1.executeQuery();
				if(resultSet.next()) {
					  doi = resultSet.getDate(1);
				}
				}
					removeRecord(book.getbTitle(), stdid);
					updateReturnedBookStatus(book);
					long res=((subDate.getTime()-doi.getTime())/(1000*60*60*24))%365;
					if(res>15) {
					fine=(float) (res-15)*10;
				}
			
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fine;
	}

	
	public List<IssuedBooks> getBooks(String stdId) {
		List<IssuedBooks> bookList = new ArrayList<IssuedBooks>();
		String sqlQuery="select `bTitle`,`bAuthor`,`bCategory`,`doi` from issued_books where stdid=?";
	  if(connection!=null) {
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			if(pst!=null) {
				pst.setString(1, stdId);
				System.out.println(stdId);
				ResultSet resultSet = pst.executeQuery();
				System.out.println(resultSet);
			  if(resultSet!=null) {
				  while(resultSet.next()) {
					  IssuedBooks book = new IssuedBooks();
					
					  book.setbTitle(resultSet.getString(1));
					  book.setbAuthor(resultSet.getString(2));
					  book.setbCategory(resultSet.getString(3));
					  book.setIssueDate(resultSet.getDate(4));
					  
//					  Calculating Fine
					  long toi = book.getIssueDate().getTime();
					  long today = new java.util.Date().getTime();
					  float dayDiff=((today-toi)/(1000*60*60*24))%365;
					  if(dayDiff>15)
					  book.setFine((dayDiff-15)*10);
					  else {
						  book.setFine(0.0f);
						  
					  }
					  bookList.add(book);
				  }
			  }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	return bookList;
	}
	public void removeRecord(String bTitle, String stdid) {
		String sqlQuery="DELETE FROM issued_books WHERE bTitle=? AND stdid=?";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setString(1, bTitle);
			pst.setString(2, stdid);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<IssuedBooks> getIssuedBookList() {
		List<IssuedBooks> ibookList=new ArrayList<IssuedBooks>();
		String sqlQuery="Select `stdid`,`bTitle`,`bAuthor`,`bCategory`,`doi` from issued_books";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = pst.executeQuery();
			if(resultSet!=null) {
				while(resultSet.next()) {
					IssuedBooks issuedBook = new IssuedBooks();
					issuedBook.setStdid(resultSet.getString(1));
					issuedBook.setbTitle(resultSet.getString(2));
					issuedBook.setbAuthor(resultSet.getString(3));
					issuedBook.setbCategory(resultSet.getString(4));
					issuedBook.setIssueDate(resultSet.getDate(5));
				ibookList.add(issuedBook);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ibookList;
	}
	

	public String validateStdid(String stdid) {
		String sqlQuery2="select `stdname` from stdrecord where stdid=?";
		String sname=null;
		try {
		PreparedStatement pst1 = connection.prepareStatement(sqlQuery2);
		pst1.setString(1, stdid);
		ResultSet rs = pst1.executeQuery();
		if(rs.next()) {
			 sname = rs.getString(1);
		}
		}catch (SQLException se) {
			 se.printStackTrace();
			}
		catch (Exception e) {
		 e.printStackTrace();
		}
		return sname;
	}
	
	public String updateIssuedBookStatus(Book book) {
		String sqlQuery2="update bookrecord set status=? where bTitle=? and bAuthor=?";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery2);
			if(pst!=null) {
				pst.setString(1, "issued");
				pst.setString(2, book.getbTitle());
				pst.setString(3, book.getbAuthor());
				int rowAff = pst.executeUpdate();
				if(rowAff>0) return "value Updated";
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String updateReturnedBookStatus(Book book) {
		String sqlQuery2="update bookrecord set status=? where bTitle=? and bAuthor=?";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery2);
			if(pst!=null) {
				pst.setString(1, "available");
				pst.setString(2, book.getbTitle());
				pst.setString(3, book.getbAuthor());
				int rowAff = pst.executeUpdate();
				if(rowAff>0) return "value Updated";
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
