package design.patterns.creational.builder;

import design.patterns.creational.builder.model.ICar;

public interface ICarBuilder {

    ICarBuilder builder();

    ICarBuilder withEngine();

    ICarBuilder withChassis();

    ICarBuilder withBodyShell();

    ICarBuilder withTyre();

    // below method returns the final object
    ICar build();

}
