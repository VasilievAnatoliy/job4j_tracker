package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов Иван Иванович");
        student.setGroup(205);
        student.setEnrollment(new Date());

        System.out.println("Студент: " + student.getName() + ".  "
                         + "Группа № " + student.getGroup() + ".  "
                         + "Дата поступления: " + student.getEnrollment());
    }
}
