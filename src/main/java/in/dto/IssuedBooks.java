package in.dto;
import java.util.*;
import java.io.Serializable;

public class IssuedBooks implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String stdid;
    private String bTitle;
    private String bAuthor;
    private String bCategory;
    private Float fine;
    private Date issueDate;
    private Date submitDate;

    
    
    
    
public Float getFine() {
		return fine;
	}
	public void setFine(Float fine) {
		this.fine = fine;
	}
public String getbAuthor() {
	return bAuthor;
}
public void setbAuthor(String bAuthor) {
	this.bAuthor = bAuthor;
}




public String getStdid() {
	return stdid;
}
public void setStdid(String stdid) {
	this.stdid = stdid;
}
public String getbCategory() {
	return bCategory;
}

public void setbCategory(String bCategory) {
	this.bCategory = bCategory;
}

public String getbTitle() {
	return bTitle;
}

public void setbTitle(String bTitle) {
	this.bTitle = bTitle;
}

public Date getIssueDate() {
	return issueDate;
}

public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
}

public Date getSubmitDate() {
	return submitDate;
}

public void setSubmitDate(Date submitDate) {
	this.submitDate = submitDate;
}


@Override
public String toString() {
	return "StdBooks [bTitle=" + bTitle + ", bAuthor=" + bAuthor + ", bCategory=" + bCategory + ", issueDate="
			+ issueDate + ", submitDate=" + submitDate + "]";
}
}
