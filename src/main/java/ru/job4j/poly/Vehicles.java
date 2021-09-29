package ru.job4j.poly;

public class Vehicles {
    public static void main(String[] args) {
        Vehicle airplane1 = new Airplane();
        Vehicle train1 = new Train();
        Vehicle redBus1 = new RedBus();
        Vehicle airplane2 = new Airplane();
        Vehicle train2 = new Train();
        Vehicle redBus2 = new RedBus();

        Vehicle[] vehicles = new Vehicle[] {airplane1, train1, redBus1, airplane2, train2, redBus2};
        for (Vehicle v : vehicles) {
            v.move();
            v.color();
        }
    }
}
