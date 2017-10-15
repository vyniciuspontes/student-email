package com.vpontes.studentemail.infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vpontes.studentemail.model.Student;

public class StudentSpreadsheet extends EntitySpreadsheet{

	public StudentSpreadsheet(String filePath) {
		super(filePath);
	}

	@Override
	public List<Student> getEntityList() {
		
		List<Student> studentList = new ArrayList<>();
		
		File spreadsheetFile = new File(filePath);
		
		if(!spreadsheetFile.exists()) {
			System.out.println("Can't find the file: " + filePath);
			return null;
		}
		
		Scanner scanner;
		try {
			scanner = new Scanner(spreadsheetFile);			
			
			//pula a primeira linha
			if(scanner.hasNextLine())
				scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				
				String[] line = scanner.nextLine().split(",");
				Student student = this.getEntityFromLine(line);
				studentList.add(student);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can't read the file:" + filePath);
			return null;
		}
		
		//studentList.add(new Student("Vynicius", "123", "123", "pontes.vynicius@gmail.com", "vyniciusmorais@id.uff.br", true));
		
		return studentList;
	}
	
	private Student getEntityFromLine(String[] line) {
		
		String name = line[0];
		String enrollcode = line[1];
		String phone = line[2];
		String email = line[3]; 
		String uffmail = line[4];
		Boolean status = line[5].toLowerCase().equals("ativo"); 
		
		return new Student(name, enrollcode, phone, email, uffmail, status);
		
	}
	
}
