package repository;

import java.util.HashMap;
import java.util.Map;
import model.Book;

public class BooksRepository {

    Map<Integer, Book> books;

    public BooksRepository() {
        books = new HashMap<>();
        booksInit();
    }

    private void booksInit(){
        books.put(1, new Book("Tamil Book", "raghul", 5));
        books.put(2, new Book("English Book", "kannan", 3));
        books.put(3, new Book("Maths Book", "raghul", 2));
    }

    public Iterable<Book> getAllBooks(){
        return books.values();
    }

    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    public Book getBookById(int id){
        return books.get(id);
    }

    
    



}
