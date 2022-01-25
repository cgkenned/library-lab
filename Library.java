import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class

	private String address;
	public Library(String libraryAddress) {
		address = libraryAddress;
	}
	
	ArrayList<Book> bookObjects = new ArrayList<>();
	
	public void addBook(Book newBook) {
		this.bookObjects.add(newBook);
	}
	
	public String printAddress() {
		return address;
	}
	
	public static String printOpeningHours() {
		return "9am to 5pm";
	}
	
	public void borrowBook(String bookTitle){
		boolean found = false;
		boolean success = false;
		for (Book newBook : this.bookObjects){
		    if (newBook.title.equals(bookTitle)){
			found = true;
			if (!newBook.isBorrowed()){
			    newBook.borrowed();
			    System.out.println("You successfully borrowed " + bookTitle);
			    success = true;
			    break;
			}
		  }
		}
		if (!found){
		    System.out.println("Sorry, this book is not in our catalog");
		}
		else if (!success){
		    System.out.println("Sorry, this book is already borrowed");
		}
	}
	
	public void printAvailableBooks() {
		boolean available = false;
		for (Book newBook : this.bookObjects){
		    if (!newBook.isBorrowed()){
			available = true;
			System.out.println(newBook.title);
		    }
		}
		if (!available)
		    System.out.println("No available book in catalog");
	    }
	
	public void returnBook(String bookTitle) {
		boolean found = false;
		boolean success = false;
		for (Book newBook : this.bookObjects){
		    if (newBook.title.equals(bookTitle)){
			found = true;
			if (newBook.isBorrowed()){
			    newBook.returned();
			    System.out.println("You successfully returned " + bookTitle);
			    success = true;
			    break;
			}
		    }
		}
		if (!found){
		    System.out.println("Sorry, this book is not in our catalog");
		}
		else if (!success){
		    System.out.println("Please check whether this book is borrowed from our library");
		}
	  }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        System.out.println("Libraries are open daily from " + printOpeningHours());

        System.out.println("Library addresses:");
        System.out.println(firstLibrary.printAddress());
        System.out.println(secondLibrary.printAddress());
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

}