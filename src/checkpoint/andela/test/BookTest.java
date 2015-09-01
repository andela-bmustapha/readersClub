package checkpoint.andela.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class BookTest {

	private Book book;
	private String bookName;
	private String author;
	private int copies;
	private String isbn;

	@Before
	public void setUp() throws Exception {
		book = new Book();
		bookName = "Oliver Twist";
		author = "Charles Dickens";
		copies = 25;
		isbn = "12345-454-123";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testBookNotNull() {
		assertNotNull("Book object is not null", book);
	}
	
	@Test
	public void testGetBookName() {
		book.setName(bookName);
		assertEquals("Book name is set: ", bookName, book.getName());
	}
	
	@Test
	public void testGetAuthor() {
		book.setAuthor(author);
		assertEquals("Author is set: ", author, book.getAuthor());
	}
	
	@Test
	public void testGetNumberOfCopies() {
		book.setNumberOfCopies(copies);
		assertEquals("Copies is set: ", copies, book.getNumberOfCopies());
	}
	
	@Test
	public void testGetIsbn() {
		book.setIsbn(isbn);
		assertEquals("ISBN is set: ", isbn, book.getIsbn());
	}
	
	@Test
	public void testGetWaitingList() {
		assertNotNull("Waiting queue not null: ", book.getWaitingList());
	}
	
	@Test
	public void testGetQueueSize() {
		assertEquals("getQueueSize returns an integer value: ", 0, book.getQueueSize());
	}
	
	@Test
	public void testAddToQueue() {
		Member member = new Member();
		int initialQueueSize = book.getQueueSize();
		book.addToQueue(member);
		int finalQueueSize = book.getQueueSize();
		assertEquals("Final to be initial + 1: ", initialQueueSize + 1, finalQueueSize);
	}
}
