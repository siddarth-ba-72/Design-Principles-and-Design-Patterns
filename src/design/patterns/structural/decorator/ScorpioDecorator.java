package design.patterns.structural.decorator;

import design.patterns.structural.decorator.models.ICar;

public abstract class ScorpioDecorator implements ICar {

    ICar scorpio;

    protected ScorpioDecorator(ICar car) {
        this.scorpio = car;
    }

    @Override
    public void start() {
        this.scorpio.start();
    }

    @Override
    public void stop() {
        this.scorpio.stop();
    }

}
