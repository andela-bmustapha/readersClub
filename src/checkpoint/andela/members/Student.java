package checkpoint.andela.members;

import checkpoint.andela.main.Member;

public class Student extends Member {
	
	private String number;
	private String sClass;
	
	// default constructor
	public Student() {
		super();
	}
	
	// constructor with field parameters
	public Student(String fullName, char gender, String dateOfBirth, String phoneNumber, String emailAddress, String studentNumber, String studentClass) {
		super(fullName, gender, dateOfBirth, phoneNumber, emailAddress);
		setNumber(studentNumber);
		setClass(studentClass);
	}

	public void setNumber(String studentNumber) {
		this.number = studentNumber;
	}
	public String getNumber() {
		return this.number;
	}
	
	
	public void setClass(String studentClass) {
		this.sClass = studentClass;
	}
	public String getStudClass() {
		return this.sClass;
	}
	
}
