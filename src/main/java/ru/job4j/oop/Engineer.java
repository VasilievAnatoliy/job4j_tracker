package ru.job4j.oop;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Task execute(Project project) {
        return execute(project);
    }
}
