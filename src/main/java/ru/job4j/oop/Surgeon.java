package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String operation;
    private String anesthesia;

    public Surgeon(String name, String surname, String education, String birthday, String operation, String anesthesia) {
        super(name, surname, education, birthday);
        this.operation = operation;
        this.anesthesia = anesthesia;
    }

    public String getOperation() {
        return operation;
    }

    public String getAnesthesia() {
        return anesthesia;
    }
}
