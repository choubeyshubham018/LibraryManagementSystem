package in.dto;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stdId;
	private String stdName;
	private Integer stdAge;
	private String stdgen;
    private String mob;
    private String email;
    private String password;
	
	public String getPassword() {
		return password;
	}


	public String getStdId() {
		return stdId;
	}


	public void setStdId(String stdId) {
		this.stdId = stdId;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMob() {
		return mob;
	}


	public void setMob(String mob) {
		this.mob = mob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public String getStdName() {
		return stdName;
	}


	public void setStdName(String stdName) {
		this.stdName = stdName;
	}


	public Integer getStdAge() {
		return stdAge;
	}


	public void setStdAge(Integer stdAge) {
		this.stdAge = stdAge;
	}


	public String getStdgen() {
		return stdgen;
	}


	public void setStdgen(String stdgen) {
		this.stdgen = stdgen;
	}


	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdAge=" + stdAge + ", stdgen=" + stdgen + "]";
	}
	
}
