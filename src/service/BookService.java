package service;

import model.Book;
import repository.BooksRepository;

public class BookService {
    
    private BooksRepository booksRepository;

    public BookService() {
        booksRepository = new BooksRepository();
    }

    public Iterable<Book> listBooks(){
        return booksRepository.getAllBooks();
    }

    public void addBook(Book book){
        booksRepository.addBook(book);
    }

    public Book getBookById(int id){
        return booksRepository.getBookById(id);
    }

    public void increaseQuantity(int id,int quantity){
        Book book = booksRepository.getBookById(id);
        if( book == null ) return;
        book.setQuantity(book.getQuantity() + quantity);
    }

    public void decreaseQuantity(int id,int quantity){
        Book book = booksRepository.getBookById(id);
        if( book == null ) return;
        book.setQuantity(book.getQuantity() - quantity);
    }

}
