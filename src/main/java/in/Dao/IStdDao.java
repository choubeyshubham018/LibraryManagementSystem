package in.Dao;

import java.util.List;

import in.dto.Student;

public interface IStdDao {
    String stdLogin(String stdid,String stdpass);
	String registerStd(Student std) ;
	String removeStd(Integer stdId);
	List<Student> getStudentList();
}
