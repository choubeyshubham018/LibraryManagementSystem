package in.DaoFactory;

import in.Dao.IStdDao;
import in.Dao.StdDaoImpl;

public class StdDaoFactory {
 static IStdDao iStd=null;

public static IStdDao getStdRegistrationImpl() {
 
	if(iStd==null) {
		iStd=new StdDaoImpl();
	}
	
	return iStd;
}
}
