package in.ServiceFactory;

import in.Service.IIssueBookAndStatusService;
import in.Service.IssuedBookAndStatusServiceImpl;

public class IssueBookServiceFactory {

	 static IIssueBookAndStatusService ibookService;
	
	public static IIssueBookAndStatusService getIssueBookService() {
		if(ibookService==null) {
			ibookService=new IssuedBookAndStatusServiceImpl();
		}
		return ibookService; 
	}
}
