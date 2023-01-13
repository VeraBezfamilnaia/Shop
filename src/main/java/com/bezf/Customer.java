package com.bezf;

import java.util.ArrayList;
import java.util.List;

//TODO Single responsibility principle
public class Customer extends Person { //TODO Liskov substitution principle
    private final List<Book> cart = new ArrayList<>();

    public Customer(long id, String name, int age) {
        super(id, name, age);
    }

    public List<Book> getCart() {
        return cart;
    }

    public void addToCart(Book book) {
        cart.add(book);
    }

    public void removeFromCart(Book book) {
        cart.remove(book);
    }

    public void buy() {
        cart.clear();
    }

    public List<Book> getAvailableBooks(BookShop shop) {
        return shop.getAvailableBooks();
    }
}
