package design.patterns.creational.abstractfactory;

import design.patterns.creational.factory.model.IEngine;

public interface ICarFactory {

    IEngine createEngine();

}
