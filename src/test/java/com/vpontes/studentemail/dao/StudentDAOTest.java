package com.vpontes.studentemail.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vpontes.studentemail.model.Student;

public class StudentDAOTest {

	private StudentDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new StudentDAO();
	}

	@Test
	public void testGetByEnrollcode() {
		Student student = dao.getByEnrollcode("100460");
		
		assertEquals("Aline Ferreira Barros", student.getName());
		assertEquals("100460", student.getEnrollcode());
		assertEquals("email@gmail.com", student.getEmail());
		assertEquals("99999-9970", student.getPhone());
		assertEquals("uffmail@id.uff.br", student.getUffmail());
		assertEquals(false, student.getActive());
	}

}
