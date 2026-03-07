package design.patterns.creational.builder.model;

import design.patterns.creational.builder.ICarBuilder;

public class ScorpioBuilder implements ICarBuilder {

    Scorpio scorpio;

    @Override
    public ScorpioBuilder builder() {
        this.scorpio = new Scorpio();
        return this;
    }

    @Override
    public ScorpioBuilder withEngine() {
        this.scorpio.setEngine("Scorpio:Engine");
        System.out.println("Scorpio:Engine");
        return this;
    }

    @Override
    public ScorpioBuilder withChassis() {
        this.scorpio.setChassis("Scorpio:Chassis");
        System.out.println("Scorpio:Chassis");
        return this;
    }

    @Override
    public ScorpioBuilder withBodyShell() {
        this.scorpio.setBodyShell("Scorpio:BodyShell");
        System.out.println("Scorpio:BodyShell");
        return this;
    }

    @Override
    public ScorpioBuilder withTyre() {
        this.scorpio.setTyre("Scorpio:Tyre");
        System.out.println("Scorpio:Tyre");
        return this;
    }

    @Override
    public ICar build() {
        return this.scorpio;
    }
}
