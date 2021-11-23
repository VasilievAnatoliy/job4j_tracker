package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] numLeft = left.split("\\.");
        String[] numRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(numLeft[0]), Integer.parseInt(numRight[0]));
    }
}