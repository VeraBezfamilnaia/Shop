package com.bezf;

//TODO Single responsibility principle
public class Seller extends Person { //TODO Liskov substitution principle
    private final BookShop shop;

    public Seller(long id, String name, int age, BookShop shop) {
        super(id, name, age);
        this.shop = shop;
    }

    public void addBook(Book book) {
        shop.addBook(book);
    }

    public void sellBook(Book book) {
        shop.removeBook(book);
    }
}
