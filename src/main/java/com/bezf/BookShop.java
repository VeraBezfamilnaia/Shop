package com.bezf;

import java.util.List;

public class BookShop {
    private final List<Book> availableBooks;

    public BookShop(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }
}
