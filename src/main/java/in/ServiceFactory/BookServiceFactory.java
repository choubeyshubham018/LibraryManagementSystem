package in.ServiceFactory;

import in.Service.BookServiceImpl;
import in.Service.IBookService;

public class BookServiceFactory {

	static IBookService ibook;
	
	public static IBookService getBookServiceImpl() {
		if(ibook==null) {
			ibook=new BookServiceImpl();
		}
		return ibook;
	}
	
}
