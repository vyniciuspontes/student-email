package com.vpontes.studentemail.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vpontes.studentemail.dao.StudentDAO;
import com.vpontes.studentemail.model.Student;

public class StudentService {
	
	public List<String> getStudentUFFMailSuggestions(String enrollcode){
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.getByEnrollcode(enrollcode);
		
		List<String> suggestions = new ArrayList<>();
		
		String[] splitedName = student.getName().toLowerCase().split(" ");
		
		suggestions.add(student.getName().toLowerCase().replaceAll(" ", ".") + "@id.uff.br");
		suggestions.add(student.getName().toLowerCase().replaceAll(" ", "_") + "@id.uff.br");

		if(splitedName.length > 1) {
			suggestions.add(splitedName[0] + "_" + splitedName[1] + "@id.uff.br");
			suggestions.add(splitedName[0] + "." + splitedName[1] + "@id.uff.br");
			suggestions.add(splitedName[0].charAt(0)+  splitedName[1] + "@id.uff.br");
			suggestions.add(splitedName[0] + splitedName[1].charAt(0) + "@id.uff.br");
		}
		
		if(splitedName.length > 2) {
			suggestions.add(splitedName[0].charAt(0)+  splitedName[2] + "@id.uff.br");
			suggestions.add(splitedName[0] + splitedName[2].charAt(0) + "@id.uff.br");
			suggestions.add(splitedName[0] + "_" + splitedName[2] + "@id.uff.br");
			suggestions.add(splitedName[0] + "." + splitedName[2] + "@id.uff.br");
		}
		
		//removendo emails existentes da sugestao
		List<String> allEmails = studentDAO.getAll().stream().map(x -> x.getUffmail()).collect(Collectors.toList());
		suggestions.removeAll(allEmails);
		
		return suggestions;
	}
}
