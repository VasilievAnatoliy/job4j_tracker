package ru.job4j.oop;

public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Diagnosis heal(Patient patient) {
        return heal(patient);
    }
}
