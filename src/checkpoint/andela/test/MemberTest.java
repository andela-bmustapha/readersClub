package checkpoint.andela.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class MemberTest {

	private String fullName;
	private Member member;
	private String dateOfBirth;
	private char gender;
	private String emailAddress;
	private String phoneNumber;
	private Date regDate;
	private Book book;
	private int queueSize;
	
	private Book compareToBook;
	Staff staff;
	Staff staff1;;
	Staff staff2;
	Student student1;
	Student student2;

	@Before
	public void setUp() throws Exception {
		fullName = "Babatunde Mustapha";
		dateOfBirth = "26/11/1990";
		gender = 'm';
		emailAddress = "toystars@disgui.se";
		phoneNumber = "07086832244";
		regDate = new Date();
		member = new Member();
		book = new Book("Oliver Twist", "Charles Dickens", 0, "2314-873");
		
		
		compareToBook = new Book("Oliver Twist", "Charles Dickens", 1, "2314-873");
		staff = new Staff();
		staff1 = new Staff();
		student1 = new Student();
		student2 = new Student();
		staff2 = new Staff();
		
		// borrow book
		staff.borrowBook(compareToBook);
		student1.borrowBook(compareToBook);
		staff1.borrowBook(compareToBook);
		student2.borrowBook(compareToBook);
		staff2.borrowBook(compareToBook);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMemberNotNull() {
		assertNotNull("Member object is not null", member);
	}

	@Test
	public void testGetFullName() {
		member.setFullName(fullName);
		assertEquals("Full name is equal: ", fullName, member.getFullName());
	}
	
	@Test
	public void testGetDateOfBirth() {
		member.setDateOfBirth(dateOfBirth);
		assertEquals("Date of birth must be equal: ", dateOfBirth, member.getDateOfBirth());
	}
	
	@Test
	public void testGetGender() {
		member.setGender(gender);
		assertEquals("Gender must be equal: ", gender, member.getGender());
	}
	
	@Test
	public void testGetEmailAddress() {
		member.setEmailAddress(emailAddress);
		assertEquals("Email Address must be the same: ", emailAddress, member.getEmailAddress());
	}
	
	@Test
	public void testGetPhoneNumber() {
		member.setPhoneNumber(phoneNumber);
		assertEquals("Phone number must be the same: ", phoneNumber, member.getPhoneNumber());
	}
	
	@Test
	public void testGetRegDate() {
		member.setRegDate(regDate);
		assertSame("Registration date is the same: ", regDate, member.getRegDate());
	}
	
	@Test
	public void testGetCurrentDate() {
		assertEquals("Date is equal: ", new Date(), member.getcurrentDate());
	}
	
	@Test
	public void testBorrowBookWaitingQueue() {
		queueSize = book.getQueueSize();
		member.borrowBook(book);
		assertEquals("Waiting queue to increase by 1: ", queueSize + 1, book.getQueueSize());
	}
	
	@Test
	public void testReturnBook() {
		member.borrowBook(book);
		assertEquals("Waiting queue size to be 1: ", 1, book.getQueueSize());
		member.returnBook(book);
		assertEquals("Copies of books to be 0: ", 0, book.getNumberOfCopies());
		assertEquals("Waiting queue size to be 0: ", 0, book.getQueueSize());
	}
	
	@Test
	public void testBorrowBook() {
		book = new Book("Oliver Twist", "Charles Dickens", 7, "2314-873");
		member.borrowBook(book);
		assertEquals("Number of copies to be 6: ", 6, book.getNumberOfCopies());
	}
	
	@Test
	public void testCompareTo() {
		// check the object at head of the queue
		Member queueLeader = compareToBook.getWaitingList().peek();
		assertSame("Staff1 is in the head of queue: ", staff1, queueLeader);
	}
	
	@Test
	public void testCompareToAfterBookReturned() {
		// return borrowed book
		staff.returnBook(compareToBook);
		Member queueLeader = compareToBook.getWaitingList().peek();
		assertSame("Staff2 is in the head of queue: ", staff2, queueLeader);
	}

}
