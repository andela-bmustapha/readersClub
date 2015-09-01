package checkpoint.andela.main;

import java.util.Date;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;


public class Member implements Comparable<Member> {
	
	private String fullName;
	private char gender;
	private String dateOfBirth;
	private String emailAddress;
	private String phoneNumber;
	private Date regDate;
	
	// default constructor
	public Member() {
		setFullName("Jimi Davies");
		setDateOfBirth("26/5/1974");
		setPhoneNumber("08163134946");
		setEmailAddress("jimi@disgui.se");
		setRegDate(new Date());
	}
	
	// constructor with field parameters
	public Member(String fullName, char gender, String dateOfBirth, String phoneNumber, String emailAddress) {
		setFullName(fullName);
		setGender(gender);
		setDateOfBirth(dateOfBirth);
		setPhoneNumber(phoneNumber);
		setEmailAddress(emailAddress);
		setRegDate(new Date());
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return this.fullName;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return this.gender;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRegDate() {
		return this.regDate;
	}

	public Date getcurrentDate() {
		return new Date();
	}
	
	public void borrowBook(Book book) {
		// check the number of copies left
		if (book.getNumberOfCopies() > 0) {
			book.setNumberOfCopies(book.getNumberOfCopies() - 1);
		} else {
			// no book available, add member to waiting list
			book.addToQueue(this);
		}
	}
	
	public void returnBook(Book book) {
		// increment the copies of the book by 1
		book.setNumberOfCopies(book.getNumberOfCopies() + 1);
		// check if there is there is a waiting list and proceed as necessary
		if (book.getQueueSize() > 0) {
			// there is a waiting list, assign book to the member with highest priority
			// call the borrow method again passing in the member removed from the queue
			book.getWaitingList().remove().borrowBook(book);
		}
	}
	
	@Override
	public int compareTo(Member member) {
		if (this instanceof Staff && member instanceof Student) {
			return -1;
		} else if (this instanceof Student && member instanceof Staff) {
			return 1;
		} else {
			// both are the same type, then order by registration date
			this.getRegDate().compareTo(member.getRegDate());
		}
		return 0;
	}
	
}