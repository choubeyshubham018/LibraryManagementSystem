package in.dto;

import java.io.Serializable;

public class Book implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private String bTitle;
     private String bAuthor;
     private String bCategory;
     private String status;
     private Integer copy;


public Integer getCopy() {
	return copy;
}

public void setCopy(Integer copy) {
	this.copy = copy;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getbAuthor() {
	return bAuthor;
}

public void setbAuthor(String bAuthor) {
	this.bAuthor = bAuthor;
}

public String getbTitle() {
	return bTitle;
}

public void setbTitle(String bTitle) {
	this.bTitle = bTitle;
}

public String getbCategory() {
	return bCategory;
}

public void setbCategory(String bCategory) {
	this.bCategory = bCategory;
}

@Override
public String toString() {
	return "Book [bTitle=" + bTitle + ", bAuthor=" + bAuthor + ", bCategory=" + bCategory + "]";
}
 
}
