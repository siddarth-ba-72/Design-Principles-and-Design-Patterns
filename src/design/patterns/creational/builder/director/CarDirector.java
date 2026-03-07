package design.patterns.creational.builder.director;

import design.patterns.creational.builder.ICarBuilder;
import design.patterns.creational.builder.model.ICar;

public class CarDirector {

    ICarBuilder carBuilder;

    public CarDirector(ICarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public ICar create() {
        return carBuilder.builder()
                .withEngine()
                .withChassis()
                .withBodyShell()
                .withTyre()
                .build();
    }

}
