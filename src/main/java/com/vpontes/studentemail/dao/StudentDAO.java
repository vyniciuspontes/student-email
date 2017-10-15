package com.vpontes.studentemail.dao;

import java.util.List;

import com.vpontes.studentemail.infra.SpreadsheetFactory;
import com.vpontes.studentemail.infra.StudentSpreadsheet;
import com.vpontes.studentemail.model.Student;

public class StudentDAO {
	
	private final String SPREADSHEET_PATH = "src/main/resources/spreadsheets/alunos.csv";
	
	private StudentSpreadsheet retrieveSpreadsheet() {
		
		return (StudentSpreadsheet) SpreadsheetFactory.getSpreadsheet(Student.class, SPREADSHEET_PATH);
	}
	
	public Student getByEnrollcode(String enrollcode) {
		
		List<Student> studentList = retrieveSpreadsheet().getEntityList();
		
		return studentList.stream().filter(a -> a.getEnrollcode().equals(enrollcode)).findAny().orElse(null);
	}
	
	public List<Student> getAll() {
		
		return retrieveSpreadsheet().getEntityList();
	}
}
