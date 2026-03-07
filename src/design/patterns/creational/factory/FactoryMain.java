package design.patterns.creational.factory;

import design.patterns.creational.factory.model.Scorpio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FactoryMain {
    public static void main(String[] args) {

        Scorpio c1 = ScorpioFactory.createScorpio('N');
        Scorpio c2 = ScorpioFactory.createScorpio('C');

        Collection<Scorpio> list = new ArrayList<>(List.of(c1, c2));

        for (Scorpio car : list)
            car.driveCar();

    }
}
