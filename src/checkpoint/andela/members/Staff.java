package checkpoint.andela.members;

import java.util.ArrayList;

import checkpoint.andela.main.Member;

public class Staff extends Member {
	
	private String number;
	private int netPay;
	private ArrayList<String> studentsAssignedTo = new ArrayList<String>();
	
	// default constructor
	public Staff() {
		super();
	}
	
	// constructor with field parameters
	public Staff(String fullName, char gender, String dateOfBirth, String phoneNumber, String emailAddress, String staffNumber, int netPay) {
		super(fullName, gender, dateOfBirth, phoneNumber, emailAddress);
		setNumber(staffNumber);
		setNetPay(netPay);
	}

	public void setNumber(String staffNumber) {
		this.number = staffNumber;
	}
	public String getNumber() {
		return this.number;
	}
	
	
	public void setNetPay(int netPay) {
		this.netPay = netPay;
	}
	public int getNetPay() {
		return this.netPay;
	}
	
	public void assignToStudent(String studentNumber) {
		studentsAssignedTo.add(studentNumber);
	}
	
	public ArrayList<String> getStudentsList() {
		return this.studentsAssignedTo;
	}
	
	public boolean isAssignedTo(String studentNumber) {
		if (studentsAssignedTo.contains(studentNumber)) {
			return true;
		}
		return false;
	}
}






