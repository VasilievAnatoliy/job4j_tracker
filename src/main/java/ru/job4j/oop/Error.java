package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Почта активна - " + active);
        System.out.println("Сообщенний - " + status + " шт.");
        System.out.println("Сообщенния - " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error letter  = new Error(true, 1, "Привет");
        letter .printInfo();
        Error messages = new Error(true, 2, "Привет. " + "Как дела?");
        messages.printInfo();
    }
}
