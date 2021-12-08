package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsageList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, -5, 4, -1, 7));
        List<Integer> positiveNumbers = list.stream()
                .filter(s -> s > 0)
                .collect(Collectors.toList());
    }
}
