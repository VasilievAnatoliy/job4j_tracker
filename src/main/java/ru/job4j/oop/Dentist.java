package ru.job4j.oop;

public class Dentist extends Doctor {
    private String treat;
    private String delete;

    public Dentist(String name, String surname, String education, String birthday, String treat, String delete) {
        super(name, surname, education, birthday);
        this.treat = treat;
        this.delete = delete;
    }

    public String getTreat() {
        return treat;
    }

    public String getDelete() {
        return delete;
    }
}
