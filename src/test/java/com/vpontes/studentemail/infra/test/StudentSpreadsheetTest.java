package com.vpontes.studentemail.infra.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vpontes.studentemail.infra.StudentSpreadsheet;

public class StudentSpreadsheetTest {

	private StudentSpreadsheet entity;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetEntityList() {
		entity = new StudentSpreadsheet("src/main/resources/spreadsheets/alunos.csv");
		assertFalse(entity.getEntityList().isEmpty());
	}
	
	@Test
	public void testWrongFile() {
		entity = new StudentSpreadsheet("src/main/resources/spreadsheets/alunos-not-exists.csv");
		assertNull(entity.getEntityList());
	}

}
