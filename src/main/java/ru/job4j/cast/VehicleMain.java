package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle smallAirplane = new Airplane();
        Vehicle bigAirplane = new Airplane();
        Vehicle smallTrain = new Train();
        Vehicle bigTrain = new Train();
        Vehicle smallBus = new Bus();
        Vehicle bigBus = new Bus();

        Vehicle[] transport = new Vehicle[]{smallAirplane, bigAirplane,
                smallTrain, bigTrain, smallBus, bigBus};
        for (Vehicle t: transport) {
            t.move();
            t.stop();
        }
    }
}
