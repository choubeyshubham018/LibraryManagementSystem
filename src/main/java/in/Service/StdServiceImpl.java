package in.Service;

import java.util.List;

import in.Dao.IStdDao;
import in.DaoFactory.StdDaoFactory;
import in.dto.Student;

public class StdServiceImpl implements IStdService {

	private IStdDao iStd;

	public String registerStd(Student std) {
		iStd = StdDaoFactory.getStdRegistrationImpl();
		
		return iStd.registerStd(std);
	}

	public String removeStd(Integer stdid) {
		
		iStd = StdDaoFactory.getStdRegistrationImpl();
		return iStd.removeStd(stdid);
	}

	public List<Student> getStudentList() {
		iStd = StdDaoFactory.getStdRegistrationImpl();
		return iStd.getStudentList();
		
	}

	public String stdLogin(String stdid, String stdpass) {
		iStd = StdDaoFactory.getStdRegistrationImpl();
		
		return iStd.stdLogin(stdid, stdpass);
	}

}
