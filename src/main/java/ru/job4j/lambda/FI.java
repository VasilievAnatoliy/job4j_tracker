package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);

        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(),
                left.length());
    }

}
