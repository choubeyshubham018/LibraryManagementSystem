package in.ServiceFactory;

import in.Service.ILibService;
import in.Service.LibServiceImpl;

public class LibServiceFactory {
private static ILibService libReg;

public static ILibService getLibRegServiceImpl() {
	if(libReg==null) {
		libReg=new LibServiceImpl();
	}
	return libReg;
	
}
}
