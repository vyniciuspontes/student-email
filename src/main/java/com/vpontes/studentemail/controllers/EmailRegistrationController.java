package com.vpontes.studentemail.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vpontes.studentemail.dao.StudentDAO;
import com.vpontes.studentemail.form.EmailRegistrationForm;
import com.vpontes.studentemail.model.Student;
import com.vpontes.studentemail.services.StudentService;

@Controller
public class EmailRegistrationController {

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.setValidator(new EmailRegistrationFormValidator()); }
	 */

	@RequestMapping(value = "/emailRegistration", method = RequestMethod.GET)
	public String index(Map<String, Object> model, RedirectAttributes redirectattributes) {

		EmailRegistrationForm form = new EmailRegistrationForm();

		String enrollCode = (String) model.get("enrollcode");

		StudentService service = new StudentService();
		List<String> emailSuggestions = service.getStudentUFFMailSuggestions(enrollCode);

		form.setEnrollcode(enrollCode);
		form.setEmailSuggestions(emailSuggestions);

		model.put("emailRegistrationForm", form);

		return "email-registration";
	}

	@RequestMapping(value = "/registerUFFMail", method = RequestMethod.POST)
	public ModelAndView addNewPost(@ModelAttribute("emailRegistrationForm") EmailRegistrationForm emailRegistrationForm,
			Model model) {

		StudentDAO dao = new StudentDAO();
		Student student = dao.getByEnrollcode(emailRegistrationForm.getEnrollcode());
		student.setUffmail(emailRegistrationForm.getSelectedEmail());
		
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("user",student);

		return mv;
	}
}
