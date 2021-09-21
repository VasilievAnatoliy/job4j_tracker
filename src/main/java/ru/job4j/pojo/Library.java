package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book bun = new Book("Bun ", 15);
        Book java = new Book("Java 8. The Complete Reference, 9th Edition.", 1376);
        Book viking = new Book("Viking", 318);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = bun;
        books[2] = java;
        books[3] = viking;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getBook() + " - " + bo.getCount());
        }
        System.out.println();
        System.out.println("change index 0 to index 3");
        Book rst = books[0];
        books[0] = books[3];
        books[3] = rst;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getBook() + " - " + bo.getCount());
        }
        System.out.println();
        System.out.println("all books with a name \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            if ("Clean code".equals(bo.getBook())) {
                System.out.println(bo.getBook());
            }
        }
    }
}
