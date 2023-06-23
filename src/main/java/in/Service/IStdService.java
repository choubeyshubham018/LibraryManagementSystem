package in.Service;

import java.util.List;

import in.dto.Student;

public interface IStdService {

String stdLogin(String stdid,String stdpass);
String registerStd(Student std);
String removeStd(Integer stdid);
List<Student>getStudentList();
	
}
