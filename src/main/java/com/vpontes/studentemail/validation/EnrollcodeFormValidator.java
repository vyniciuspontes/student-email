package com.vpontes.studentemail.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vpontes.studentemail.dao.StudentDAO;
import com.vpontes.studentemail.form.EnrollcodeForm;
import com.vpontes.studentemail.model.Student;

public class EnrollcodeFormValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return	EnrollcodeForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object entity, Errors erros) {
		
		ValidationUtils.rejectIfEmpty(erros, "enrollcode", "field.required");
		
		if(erros.hasErrors())
			return;
		
		EnrollcodeForm enrollcode = (EnrollcodeForm) entity;
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.getByEnrollcode(enrollcode.getEnrollcode());
		
		if(student == null)
			erros.rejectValue("enrollcode",	"field.notFound");
		else if(!student.getActive())
			erros.rejectValue("enrollcode",	"field.notActive");
		else if(!student.getUffmail().isEmpty())
			erros.rejectValue("enrollcode",	"field.HasUFFMail");
	}

}
