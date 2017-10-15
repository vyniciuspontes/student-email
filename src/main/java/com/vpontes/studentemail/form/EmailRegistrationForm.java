package com.vpontes.studentemail.form;

import java.util.List;

public class EmailRegistrationForm {

	private String selectedEmail;
	private String enrollcode;
	private List<String> emailSuggestions;

	public List<String> getEmailSuggestions() {
		return emailSuggestions;
	}

	public void setEmailSuggestions(List<String> emailSuggestions) {
		this.emailSuggestions = emailSuggestions;
	}

	public String getSelectedEmail() {
		return selectedEmail;
	}

	public void setSelectedEmail(String selectedEmail) {
		this.selectedEmail = selectedEmail;
	}

	public String getEnrollcode() {
		return enrollcode;
	}

	public void setEnrollcode(String enrollcode) {
		this.enrollcode = enrollcode;
	}

}
