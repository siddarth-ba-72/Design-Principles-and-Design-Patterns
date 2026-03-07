package design.patterns.creational.abstractfactory;

import design.patterns.creational.abstractfactory.models.engine.ScorpioEngine;
import design.patterns.creational.factory.model.IEngine;

public class ScorpioFactory implements ICarFactory {

    @Override
    public IEngine createEngine() {
        System.out.println("Create Scorpio Engine");
        return new ScorpioEngine();
    }

}
