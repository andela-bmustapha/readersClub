package checkpoint.andela.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.members.Student;

public class StudentTest {

	private Student student;
	private String number;
	private String sClass;

	@Before
	public void setUp() throws Exception {
		student = new Student();
		number = "0187123";
		sClass = "JSS 3";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testStudentNotNull() {
		assertNotNull("Student object is not null", student);
	}

	@Test
	public void testGetNumber() {
		student.setNumber(number);
		assertEquals("Student number is set: ", number, student.getNumber());
	}

	@Test
	public void testGetStudClass() {
		student.setClass(sClass);
		assertEquals("Student class is set: ", sClass, student.getStudClass());
	}

}
