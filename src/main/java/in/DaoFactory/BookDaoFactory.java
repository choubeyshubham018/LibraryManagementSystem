package in.DaoFactory;

import in.Dao.IBookDao;
import in.Dao.BookDaoImpl;

public class BookDaoFactory {

	static IBookDao ibook;
	 
	public static IBookDao getBook() {
		if(ibook==null) {
			ibook=new BookDaoImpl();
		}
		return ibook;
	}
}
