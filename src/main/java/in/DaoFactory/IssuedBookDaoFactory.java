package in.DaoFactory;

import in.Dao.IIssueBookAndStatus;
import in.Dao.IssueBookAndStatusImpl;

public class IssuedBookDaoFactory {

	static IIssueBookAndStatus ibook;

	public static IIssueBookAndStatus getIssuedBook() {
		if(ibook== null) {
			ibook=new IssueBookAndStatusImpl();
		}
		return ibook;
	}
}
