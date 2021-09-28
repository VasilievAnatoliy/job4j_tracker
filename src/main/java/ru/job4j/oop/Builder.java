package ru.job4j.oop;

public class Builder extends Engineer {
    private String specialization;

    public Builder(String name, String surname, String education, String birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
