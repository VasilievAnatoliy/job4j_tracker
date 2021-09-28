package ru.job4j.oop;

public class Diagnosis extends Doctor {
    private String heal;

    public Diagnosis(String name, String surname, String education, String birthday, String heal) {
        super(name, surname, education, birthday);
        this.heal = heal;
    }

    public String getHeal() {
        return heal;
    }
}
