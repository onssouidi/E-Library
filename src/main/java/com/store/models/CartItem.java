package com.store.models;

import lombok.Setter;

public class CartItem {
    private final BookModel book;
    @Setter
    private  int quantity;

    public CartItem(BookModel book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public BookModel getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }


    public double getTotalPrice() {
        return book.getPrice() * quantity;
    }
}
