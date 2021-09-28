package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, String birthday, String language) {
        super(name, surname, education, birthday);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}

