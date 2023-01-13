package com.bezf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private final static int BOOK_TO_BUY_INDEX = 1; //TODO Magic numbers
    private final static String MESSAGE_FOR_ADDING_BOOK = "Customer %s added the book %s %s in his cart";
    private final static String MESSAGE_FOR_BUYING_BOOK = "Customer %s bought the book %s %s";
    private final static String MESSAGE_FOR_SELLING_BOOK = "Seller %s sold the book %s %s to the customer %s";

    public static void main(String[] args) {
        List<Book> booksForShop = create();
        BookShop shop = new BookShop(booksForShop);

        var seller = new Seller(1L, "Vasya", 30, shop);
        var customer = new Customer(1L, "Ivan", 19);

        var availableBooks = customer.getAvailableBooks(shop);
        var bookToBuy = availableBooks.get(BOOK_TO_BUY_INDEX);
        customer.addToCart(bookToBuy);
        print(MESSAGE_FOR_ADDING_BOOK, customer.getName(), bookToBuy.getTitle(), bookToBuy.getAuthor());
        customer.buy();
        print(MESSAGE_FOR_BUYING_BOOK, customer.getName(), bookToBuy.getTitle(), bookToBuy.getAuthor());

        seller.sellBook(bookToBuy);
        print(MESSAGE_FOR_SELLING_BOOK, seller.getName(), bookToBuy.getTitle(), bookToBuy.getAuthor(), customer.getName());
    }

    private static void print(String format, String...args) { //TODO DRY
        System.out.printf(format, args);
        System.out.println();
    }

    private static List<Book> create() {
        return new LinkedList<>(Arrays.asList(
                new Book(1L, "Title1", "Author1", 10, Genre.PROGRAMMING),
                new Book(2L, "Title2", "Author1", 10.5, Genre.PROGRAMMING),
                new Book(3L, "Title3", "Author3", 8, Genre.ART),
                new Book(4L, "Title4", "Author4", 10, Genre.PSYCHOLOGY)
        ));
    }
}
