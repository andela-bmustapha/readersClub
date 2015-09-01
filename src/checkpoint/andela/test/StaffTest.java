package checkpoint.andela.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.members.Staff;

public class StaffTest {

	private Staff staff;
	private String number;
	private int netPay;
	private String studentNumber;

	@Before
	public void setUp() throws Exception {
		staff = new Staff();
		number = "09451";
		netPay = 25000;
		studentNumber = "013456";
		staff.assignToStudent(studentNumber);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testStaffNotNull() {
		assertNotNull("Staff object is not null", staff);
	}

	@Test
	public void testGetNumber() {
		staff.setNumber(number);
		assertEquals("Staff number is set: ", number, staff.getNumber());
	}

	@Test
	public void testGetNetPay() {
		staff.setNetPay(netPay);
		assertEquals("Staff net pay is set: ", netPay, staff.getNetPay());
	}
	
	
	@Test
	public void testNotNullStudentsList() {
		// check for null
		assertNotNull("Students list is null: ", staff.getStudentsList());
	}
	
	@Test
	public void testAssignToStudent() {
		ArrayList<String> studentsList = staff.getStudentsList();
		assertEquals("Student number is in list: ", studentNumber, studentsList.get(0));
	}
	
	@Test
	public void testIsAssignedTo() {
		assertTrue("Student is assigned: ", staff.isAssignedTo(studentNumber));
	}

}
