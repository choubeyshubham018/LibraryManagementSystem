package in.jdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			HikariConfig config=new HikariConfig("C:\\Users\\schou\\eclipse-workspace\\JSP_Bean\\LibraryManagementProject\\LibraryManagement\\src\\main\\java\\properties\\application.properties");
		    HikariDataSource dataSource=new HikariDataSource(config);
		   if(dataSource!=null) {
			return dataSource.getConnection();
		   }}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
