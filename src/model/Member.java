package model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private static int currentUsers = 0;

    private int id;
    private String username;
    private String password;
    private List<Book> borrowedBooks;

    
    public Member(String username, String password) {
        this.id = ++currentUsers;
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

}
