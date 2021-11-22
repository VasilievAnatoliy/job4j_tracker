package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int findNumLeft = left.indexOf(".");
        int findNumRight = right.indexOf(".");
        String numLeft = left.substring(0, findNumLeft);
        String numRight = right.substring(0, findNumRight);
        return Integer.compare(Integer.parseInt(numLeft), Integer.parseInt(numRight));
    }
}