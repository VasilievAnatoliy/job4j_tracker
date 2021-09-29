package ru.job4j.poly;

public class Bus implements Transpor {
    private double liter;

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }

    @Override
    public void go() {
        System.out.println("Начать движение.");
    }

    @Override
    public void passengers(int numbers) {
        System.out.println("Количество пассажиров: " + numbers);
    }

    @Override
    public double refuelPrice(double liters) {
        return liters * getLiter();
    }
}

