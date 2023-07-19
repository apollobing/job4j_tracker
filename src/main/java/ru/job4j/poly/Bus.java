package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus drives");
    }

    @Override
    public void passengers(int people) {
        System.out.println("Number of passengers: " + people);
    }

    @Override
    public double refill(double gasoline) {
        double price = 2.87;
        System.out.println("Refill price: " + price * gasoline);
        return price * gasoline;
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.drive();
        bus.passengers(45);
        bus.refill(87.2);
    }
}
