package design.patterns.creational.abstractfactory;

import design.patterns.creational.abstractfactory.models.engine.DefenderEngine;
import design.patterns.creational.factory.model.IEngine;

public class DefenderFactory implements ICarFactory {

    @Override
    public IEngine createEngine() {
        System.out.println("Create Defender Engine");
        return new DefenderEngine();
    }

}
