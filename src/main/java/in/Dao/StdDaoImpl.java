package in.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dto.Student;
import in.jdbcUtil.JdbcUtil;

public class StdDaoImpl implements IStdDao{

	private static Connection connection;
	private PreparedStatement pst;

	static {
		connection=JdbcUtil.getConnection();
		}
	public String registerStd(Student std) {
		String res="";
		connection = JdbcUtil.getConnection();
		String preCheck = checkIDAvailability(std.getStdId());
        if(connection!=null) {
        	String sqlQuery="Insert into stdrecord(`stdname`,`stdage`,`stdgen`,`stdmob`,`stdemail`,`stdpass`,`stdid`)values(?,?,?,?,?,?,?)";
			
        	try {
        		System.out.println(preCheck);
        		if(preCheck==null) {
				 pst = connection.prepareStatement(sqlQuery);
				 if(pst!=null) {
					 
					 pst.setString(1, std.getStdName());
					 pst.setInt(2, std.getStdAge());
					 pst.setString(3, std.getStdgen());
					 pst.setString(4, std.getMob());
					 pst.setString(5, std.getEmail());
					 pst.setString(6, std.getPassword());
					 pst.setString(7, std.getStdId());
					 int status = pst.executeUpdate();
					 if(status>0) { 
						 res="success";
					 }else {
						 res="failed";
					 }
					 }
				 }
        		else {
        			res="Id Already Available";
        		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return res;
	}

	public String removeStd(Integer stdId) {
		String res="";
//		connection = JdbcUtil.getConnection();
        if(connection!=null) {
        	 String sqlQuery="delete from stdrecord where stdid=?";
			try {
				pst = connection.prepareStatement(sqlQuery);
				pst.setInt(1, stdId);
				int status = pst.executeUpdate();
				if(status>0) {
					res="success";
				}else {
					res="failed";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return res;
	}

	public List<Student> getStudentList() {
		Student std=null;
		List<Student> students=new ArrayList<Student>();
		if(connection!=null) {
			String sqlQuery="select `stdid`,`stdname`,`stdage`,`stdgen`,`stdmob`,`stdemail` from stdrecord";
			try {
				pst=connection.prepareStatement(sqlQuery);
				if(pst!=null) {
					ResultSet resultSet = pst.executeQuery();
					if(resultSet!=null) {
						while(resultSet.next()) {
						std=new Student();
						std.setStdId(resultSet.getString(1));
						std.setStdName(resultSet.getString(2));
						std.setStdAge(resultSet.getInt(3));
						std.setStdgen(resultSet.getString(4));
				        std.setMob(resultSet.getString(5));
				        std.setEmail(resultSet.getString(6));
						students.add(std);
						
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	public String checkIDAvailability(String stdid) {
		String sqlQuery="Select `stdname` from stdrecord where stdid=?";
		String res=null;
		try {
			PreparedStatement pstm = connection.prepareStatement(sqlQuery);
			pstm.setString(1, stdid);
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet.next()) {
				res=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public String stdLogin(String stdid, String stdpass) {
		String SqlQuery="Select `stdpass` from stdrecord where stdid =?";
		String res=null;
		try {
			PreparedStatement pstm = connection.prepareStatement(SqlQuery);
			pstm.setString(1, stdid);
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet!=null) {
				if(resultSet.next()) {
					String pass = resultSet.getString(1);
					if(pass.equalsIgnoreCase(stdpass)) {
						res="success";
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
