package view;

import java.util.Scanner;
import model.Book;
import service.BookService;

public class BookView {
    
    Scanner sc;
    BookService bookService;

    public BookView(Scanner sc, BookService bookService) {
        this.sc = sc;
        this.bookService = bookService;
    }

    public void listBooks() {
        Iterable<Book> books = bookService.listBooks();
        System.out.println("    List of Books :");
        for (Book book : books) {
            System.out.println(book.getId() + ". " + book.getName());
        }
        System.out.println("=====================");

    }

    public void addBook() {
        System.out.println("    Add a Book :");
        sc.nextLine();
        System.out.print("Enter Book Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Author Name : ");
        String author = sc.nextLine();
        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();
        bookService.addBook(new Book(name, author, quantity));
        System.out.println("Book Added Successfully!");
    }

    public void increaseBookQuantity() {

        listBooks();

        System.out.println("=====================");
        System.out.print("Enter Book ID to Increase Quantity : ");
        int id = sc.nextInt();

        Book book = bookService.getBookById(id);
        if (book == null) {
            System.err.println("Book Not Found!");
            return;
        }

        System.out.print("Enter Quantity to Add : ");
        int quantity = sc.nextInt();
        bookService.increaseQuantity(id, quantity);
        System.out.println("Book Updated Successfully!");
    }

    public Book borrowBook() {
        listBooks();

        System.out.println("=====================");
        System.out.print("Enter Book ID to Borrow : ");
        int id = sc.nextInt();

        Book book = bookService.getBookById(id);
        if (book == null) {
            System.err.println("Book Not Found!");
            return null;
        }

        if (book.getQuantity() <= 0) {
            System.err.println("Book is not available!");
            return null;
        }

        bookService.decreaseQuantity(id, 1);
        System.out.println("Book Borrowed Successfully!");
        return book;
    }

    public Book returnBook() {
        listBooks();

        System.out.println("=====================");
        System.out.print("Enter Book ID to Return : ");
        int id = sc.nextInt();

        Book book = bookService.getBookById(id);
        if (book == null) {
            System.err.println("Book Not Found!");
            return null;
        }

        return book;    
    }

}
