package in.DaoFactory;

import in.Dao.IDao;
import in.Dao.ILibDao;
import in.Dao.LibDaoImpl;

public class LibDaoFactory {
private static IDao lib1;
  
public static IDao getLibRegDao() {
	if(lib1 == null) {
		lib1=new LibDaoImpl();
	}
	return lib1;
}


	
}
