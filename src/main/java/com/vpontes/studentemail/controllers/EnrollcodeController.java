package com.vpontes.studentemail.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vpontes.studentemail.form.EnrollcodeForm;
import com.vpontes.studentemail.services.StudentService;
import com.vpontes.studentemail.validation.EnrollcodeFormValidator;

@Controller
public class EnrollcodeController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new EnrollcodeFormValidator());
	}

	@RequestMapping(value = "/createUFFMail", method = RequestMethod.GET)
	public String index(@ModelAttribute("enrollcodeForm") EnrollcodeForm enrollcodeForm) {
		return "home";
	}

	@RequestMapping(value = "/createUFFMail", method = RequestMethod.POST)
	public String addNewPost(@Valid @ModelAttribute("enrollcodeForm") EnrollcodeForm enrollcodeForm,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "home";
		}
		
		redirectAttributes.addFlashAttribute("enrollcode", enrollcodeForm.getEnrollcode());
		
		return "redirect:/selectUFFMail";
	}
}
