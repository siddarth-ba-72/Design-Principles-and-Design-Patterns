package design.patterns.creational.builder;

import design.patterns.creational.builder.director.CarDirector;
import design.patterns.creational.builder.model.FortunerBuilder;
import design.patterns.creational.builder.model.ICar;
import design.patterns.creational.builder.model.ScorpioBuilder;

public class BuilderMain {
    public static void main(String[] args) {

        ICarBuilder scorpioBuilder = new ScorpioBuilder();
        CarDirector scorpioCarDirector = new CarDirector(scorpioBuilder);

        ICarBuilder fortunerBuilder = new FortunerBuilder();
        CarDirector fortunerCarDirector = new CarDirector(fortunerBuilder);

        ICar car1 = scorpioCarDirector.create();
        ICar car2 = fortunerCarDirector.create();

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}
