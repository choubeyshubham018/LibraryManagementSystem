package in.Service;

import in.Dao.IDao;
import in.Dao.ILibDao;
import in.DaoFactory.LibDaoFactory;
import in.dto.Librarian;

public class LibServiceImpl implements ILibService {
    private IDao lib;
	public String getRegistered(Librarian lib1) {
		lib=LibDaoFactory.getLibRegDao();
		String status = ((ILibDao) lib).getRegistered(lib1);
		return status;
	}

	public boolean checkLibrarian(String userid, String pass) {
		          IDao lib = LibDaoFactory.getLibRegDao();
	              boolean status = ((ILibDao)lib).checkLibrarian(userid, pass); 
		         return status;
	}

}
