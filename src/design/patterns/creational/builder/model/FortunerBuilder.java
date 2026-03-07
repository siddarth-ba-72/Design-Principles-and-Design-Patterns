package design.patterns.creational.builder.model;

import design.patterns.creational.builder.ICarBuilder;

public class FortunerBuilder implements ICarBuilder {

    Fortuner fortuner;

    @Override
    public ICarBuilder builder() {
        this.fortuner = new Fortuner();
        return this;
    }

    @Override
    public FortunerBuilder withEngine() {
        this.fortuner.setEngine("Fortuner:Engine");
        System.out.println("Fortuner:Engine");
        return this;
    }

    @Override
    public FortunerBuilder withChassis() {
        this.fortuner.setChassis("Fortuner:Chassis");
        System.out.println("Fortuner:Chassis");
        return this;
    }

    @Override
    public FortunerBuilder withBodyShell() {
        this.fortuner.setBodyShell("Fortuner:BodyShell");
        System.out.println("Fortuner:BodyShell");
        return this;
    }

    @Override
    public FortunerBuilder withTyre() {
        this.fortuner.setTyre("Fortuner:Tyre");
        System.out.println("Fortuner:Tyre");
        return this;
    }

    @Override
    public ICar build() {
        return this.fortuner;
    }
}
