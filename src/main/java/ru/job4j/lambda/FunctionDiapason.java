package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapason {
    public static List<Double> diapason(int start, int stop, Function<Double, Double> fan) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < stop; i++) {
            rsl.add((fan.apply((double) i)));
        }
        return rsl;
    }
}
