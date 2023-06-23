package in.ServiceFactory;

import in.Service.IStdService;
import in.Service.StdServiceImpl;

public class StdServiceFactory {

	private static IStdService iStd;
	
	public static IStdService getStdRegServiceImpl() {
		if(iStd==null) {
			iStd=new StdServiceImpl();
		}
		return iStd;
	}
}
