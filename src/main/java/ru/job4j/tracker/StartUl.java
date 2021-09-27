package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUl {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdDateTimeFormat = item.getCreated().format(formatter);
        System.out.println(createdDateTimeFormat);
        Item format = new Item();
        System.out.println(format.toString());
    }
}
