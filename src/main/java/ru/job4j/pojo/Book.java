package ru.job4j.pojo;

public class Book {
    private String book;
    private int count;

    public Book(String book, int count) {
        this.book = book;
        this.count = count;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
