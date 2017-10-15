package com.vpontes.studentemail.form;

import javax.validation.constraints.Size;

public class EnrollcodeForm {

	@Size(min=4, max=35)	
	private String enrollcode;

	public String getEnrollcode() {
		return enrollcode;
	}

	public void setEnrollcode(String enrollcode) {
		this.enrollcode = enrollcode;
	}

}
