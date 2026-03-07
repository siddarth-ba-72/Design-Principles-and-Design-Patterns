package design.patterns.creational.abstractfactory;

import design.patterns.creational.abstractfactory.models.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AbstractFactoryMain {
    public static void main(String[] args) {

        ICarFactory f1 = new ScorpioFactory();
        ICarFactory f2 = new DefenderFactory();

        Car c1 = new Car(f1);
        Car c2 = new Car(f2);

        Collection<Car> cars = new ArrayList<>(List.of(c1, c2));

        for(Car c : cars) {
            c.driveCar();
        }

    }
}
