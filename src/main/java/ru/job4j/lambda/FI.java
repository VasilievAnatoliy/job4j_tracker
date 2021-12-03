package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        /*
        Arrays.sort(strings, cmpText);
        System.out.println(Arrays.toString(strings));

         */

        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();
        /*
        Arrays.sort(strings, cmpDescSize);
        System.out.println(Arrays.toString(strings));

         */
    }

}
