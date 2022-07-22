import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Car> carsNS = new ArrayList<>();
        ArrayList<Car> carsWE = new ArrayList<>();
        Semaphore SNS = new Semaphore(1);
        Semaphore SWE = new Semaphore(1);

        carsNS.add(new Car("car1"));
        carsNS.add(new Car("car2"));
        carsNS.add(new Car("car3"));
        carsNS.add(new Car("car4"));
        carsNS.add(new Car("car5"));
        carsWE.add(new Car("car6"));
        carsWE.add(new Car("car7"));
        carsWE.add(new Car("car8"));
        carsWE.add(new Car("car9"));
        carsWE.add(new Car("car10"));

        Direction NS = new Direction(SNS, "Nord-South", carsNS);
        Direction WE = new Direction(SWE, "West-East", carsWE);

        NS.start();
        WE.start();

        NS.join();
        WE.join();
    }
}
