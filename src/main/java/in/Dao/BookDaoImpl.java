package in.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dto.Book;
import in.jdbcUtil.JdbcUtil;

public class BookDaoImpl implements IBookDao {

	private Connection connection;
	private PreparedStatement prepareStatement;


	public String addBook(Book book) {
		connection = JdbcUtil.getConnection();
		String sqlAddQuery="Insert into bookRecord(`bTitle`,`bAuthor`,`bCategory`,`status`) values(?,?,?,?)";
		int status=1;
		try {
			prepareStatement = connection.prepareStatement(sqlAddQuery);
			if(prepareStatement!=null) {
				
				for(int i=0;i<book.getCopy();i++) {
					if(status>0) {
				prepareStatement.setString(1, book.getbTitle());
				prepareStatement.setString(2, book.getbAuthor());
				prepareStatement.setString(3, book.getbCategory());
				prepareStatement.setString(4, "available");
				
				status = prepareStatement.executeUpdate();
				}else {
					break;
				}
					}
				System.out.println(status);
				if(status>0) {
					return "Success";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Failed";
	}

	public String deleteBook(String bTitle) {
		connection = JdbcUtil.getConnection();
		String sqlDelete="delete from bookRecord where bTitle = ?";
		try {
			prepareStatement=connection.prepareStatement(sqlDelete);
			prepareStatement.setString(1, bTitle);
			int status = prepareStatement.executeUpdate();
			if(status>0) {
				return "Success";
			}
			else {
				return "Failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public List<Book> searchBook(Book book) {
		connection = JdbcUtil.getConnection();
		String sqlSearch=null;
		List<Book> list=new ArrayList<Book>();
		try {
			 sqlSearch="Select `bTitle`,`bAuthor`,`bCategory`,`status` from bookRecord where bTitle=?";
			if(book.getbTitle()!=null) {
			PreparedStatement pst = connection.prepareStatement(sqlSearch);
			pst.setString(1, book.getbTitle());
			
			ResultSet resultSet = pst.executeQuery();
			if(resultSet!=null) {
				while(resultSet.next()) {
					Book bk=new Book();
					bk.setbTitle(resultSet.getString(1));
					bk.setbAuthor(resultSet.getString(2));
					bk.setbCategory(resultSet.getString(3));
					bk.setStatus(resultSet.getString(4));
					list.add(bk);
				}
			}
			}else if(book.getbAuthor()!=null) {
				 sqlSearch="Select `bTitle`,`bAuthor`,`bCategory`,`status` from bookRecord where bAuthor=?";
					PreparedStatement pst = connection.prepareStatement(sqlSearch);
				
					pst.setString(1, book.getbAuthor());
					
					ResultSet resultSet = pst.executeQuery();
					if(resultSet!=null) {
						while(resultSet.next()) {
							Book bk=new Book();
							bk.setbTitle(resultSet.getString(1));
							bk.setbAuthor(resultSet.getString(2));
							bk.setbCategory(resultSet.getString(3));
							bk.setStatus(resultSet.getString(4));
							list.add(bk);
						
			}
					}
					}
			else {
				sqlSearch="Select `bTitle`,`bAuthor`,`bCategory`,`status` from bookRecord where bCategory=?";
				PreparedStatement pst = connection.prepareStatement(sqlSearch);
			
				pst.setString(1, book.getbCategory());
				
				ResultSet resultSet = pst.executeQuery();
				if(resultSet!=null) {
					while(resultSet.next()) {
						Book bk=new Book();
						bk.setbTitle(resultSet.getString(1));
						bk.setbAuthor(resultSet.getString(2));
						bk.setbCategory(resultSet.getString(3));
						bk.setStatus(resultSet.getString(4));
						list.add(bk);
					
		}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Book> getBookList() {
		List<Book> list=new ArrayList<Book>();
		connection=JdbcUtil.getConnection();
		String sqlQuery="Select `bTitle`,`bAuthor`,`bCategory`,`status` from bookrecord ";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			if(pst!=null) {
				ResultSet resultSet = pst.executeQuery();
				if(resultSet!=null) {
					while (resultSet.next()){
						Book book = new Book();
						book.setbTitle(resultSet.getString(1));
						book.setbAuthor(resultSet.getString(2));
						book.setbCategory(resultSet.getString(3));
						book.setStatus(resultSet.getString(4));
						list.add(book);
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

	

}
