package com.vpontes.studentemail.infra;

import com.vpontes.studentemail.model.Student;

public class SpreadsheetFactory {
	
	public static EntitySpreadsheet getSpreadsheet(Class<?> entity, String filePath) {
		
		if(entity == Student.class){
			return new StudentSpreadsheet(filePath);
		}
		
		return null;
	}
}
