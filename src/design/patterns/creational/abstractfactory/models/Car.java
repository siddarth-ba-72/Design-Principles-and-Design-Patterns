package design.patterns.creational.abstractfactory.models;

import design.patterns.creational.abstractfactory.ICarFactory;
import design.patterns.creational.factory.model.IEngine;

public class Car {

    IEngine engine;

    ICarFactory vehicleFactory;

    public Car(ICarFactory vehicleFactory) {
        this.vehicleFactory = vehicleFactory;
    }

    public void driveCar() {
        this.engine = vehicleFactory.createEngine();
        System.out.println("Engine assembled");
    }

}
