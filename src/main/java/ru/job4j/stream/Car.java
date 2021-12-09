package ru.job4j.stream;

public class Car {
    private int year;
    private String brand;
    private String model;
    private int numberOfDoors;
    private String color;

    static class Builder {
        private int year;
        private String brand;
        private String model;
        private int numberOfDoors;
        private String color;

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.year = year;
            car.brand = brand;
            car.model = model;
            car.numberOfDoors = numberOfDoors;
            car.color = color;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildYear(2005)
                .buildBrand("Lada")
                .buildModel("Niva")
                .buildNumberOfDoors(3)
                        .build();
        System.out.println(car);
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", numberOfDoors=" + numberOfDoors
                + ", color='" + color + '\''
                + '}';
    }
}

