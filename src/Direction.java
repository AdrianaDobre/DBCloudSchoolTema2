import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Direction extends Thread {
    private Semaphore semaphore;
    private String direction;
    private ArrayList<Car> cars;

    public Direction(Semaphore semaphore, String direction, ArrayList<Car> cars) {
        this.semaphore = semaphore;
        this.direction = direction;
        this.cars = cars;
    }

    public String getCar(ArrayList<Car> cars, int index) {
        int i = 0;
        for (Car car : cars) {
            if (i == index)
                return car.getName();
            i++;
        }
        return null;
    }

    public void run() {
        if (Objects.equals(direction, "Nord-South"))
            while (!cars.isEmpty()) {
                try {
                    semaphore.acquire();
                    System.out.println("One more car crosses the intersection -> direction " + direction);
                    System.out.println(getCar(cars, 0));
                    cars.remove(0);
                    Thread.sleep(4000);
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        else if (Objects.equals(direction, "West-East"))
            while (!cars.isEmpty()) {
                try {
                    semaphore.acquire();
                    System.out.println("One more car crosses the intersection -> direction " + direction);
                    System.out.println(getCar(cars, 0));
                    cars.remove(0);
                    Thread.sleep(4000);
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
