package com.vpontes.studentemail.model;

public class Student {

	private String name;
	private String enrollcode;
	private String phone;
	private String email;
	private String uffmail;
	private Boolean active;

	public Student(String name, String enrollcode, String phone, String email, String uffmail, Boolean active) {
		super();
		this.name = name;
		this.enrollcode = enrollcode;
		this.phone = phone;
		this.email = email;
		this.uffmail = uffmail;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public String getEnrollcode() {
		return enrollcode;
	}

	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}

	public String getUffmail() {
		return uffmail;
	}

	public void setUffmail(String uffmail) {
		this.uffmail = uffmail;
	}

	public Boolean getActive() {
		return active;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", enrollcode=" + enrollcode + ", phone=" + phone + ", email=" + email
				+ ", uffmail=" + uffmail + ", active=" + active + "]";
	}
}
