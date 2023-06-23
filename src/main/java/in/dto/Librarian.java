package in.dto;

import java.io.Serializable;

public class Librarian  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
   private String name;
   private String userid;
   private String password;
   private String gender;
   private Integer age;
   
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}

}
