package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {

        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("aimage 3", 120),
                new Attachment("aaimage 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Arrays.sort(atts, comparator);
        System.out.println(Arrays.toString(atts));

        Comparator<Attachment> comparator1 = (left, right) -> left.getSize() - right.getSize();
        Arrays.sort(atts, comparator1);
        System.out.println(Arrays.toString(atts));

        Comparator<Attachment> cmpSize = (left, right) -> left.getName().length()
                - right.getName().length();
        Arrays.sort(atts, cmpSize);
        System.out.println(Arrays.toString(atts));

        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());
        Arrays.sort(atts, cmpText);
        System.out.println(Arrays.toString(atts));

        Comparator<Attachment> cmpDescSize = (left, right) -> right.getName().length()
                - left.getName().length();
        Arrays.sort(atts, cmpDescSize);
        System.out.println(Arrays.toString(atts));
    }

}
