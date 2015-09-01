package checkpoint.andela.main;

import java.util.PriorityQueue;

public class Book {
	
	private String name;
	private String author;
	private int numberOfCopies;
	private String isbn;
	
	// declare queue for members on the waiting list
	private PriorityQueue<Member> waitingQueue = new PriorityQueue<Member>();
	
	// default constructor
	public Book() {
		
	}
	
	// constructor with field parameters
	public Book(String name, String author, int numberOfCopies, String isbn) {
		setName(name);
		setAuthor(author);
		setNumberOfCopies(numberOfCopies);
		setIsbn(isbn);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}
	
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	public int getNumberOfCopies() {
		return this.numberOfCopies;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return this.isbn;
	}
	
	public void addToQueue(Member member) {
		waitingQueue.add(member);
	}

	public int getQueueSize() {
		return waitingQueue.size();
	}
	
	public PriorityQueue<Member> getWaitingList() {
		return this.waitingQueue;
	}
}
