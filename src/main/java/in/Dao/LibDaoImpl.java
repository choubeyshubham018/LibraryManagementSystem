package in.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.dto.Librarian;
import in.jdbcUtil.JdbcUtil;

public class LibDaoImpl implements ILibDao {

	private Connection connection;

	public String getRegistered(Librarian lib1) {
		connection = JdbcUtil.getConnection();
		String sqlQuery="Insert into librarianRecord(`name`,`userid`,`pass`,`age`,`gender`) values(?,?,?,?,?)";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setString(1, lib1.getName());
			pst.setString(2, lib1.getUserid());
			pst.setString(3, lib1.getPassword());
			pst.setInt(4, lib1.getAge());
			pst.setString(5, lib1.getGender());
		    int status = pst.executeUpdate();
		    if(status>0) {
		    	return "success";
		    }
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "failed";
	}

	public boolean checkLibrarian(String userid,String pass) {
		connection=JdbcUtil.getConnection();
		String sqlQuery="select `pass` from librarianRecord where userid=?";
		try {
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			if(pst!=null) {
				pst.setString(1, userid);
			ResultSet resultSet = pst.executeQuery();
			if(resultSet!=null) {
				if(resultSet.next()) {
					String pass1 = resultSet.getString(1);
					if(pass1.equals(pass)) {
						return true;
					}
				}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
