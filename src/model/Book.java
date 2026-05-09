package model;

public class Book {
    
    private static int currentBooks = 0;

    private int id;
    private String name;
    private String author;
    private int quantity;

    public Book(String name, String author, int quantity) {
        this.id = ++currentBooks;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

}
