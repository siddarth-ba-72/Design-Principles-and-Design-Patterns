package design.patterns.creational.prototype.models;

public interface IScorpioPrototype {

    public IScorpioPrototype clone();

    void setEngine(ScorpioEngine engine);

    void start();

}
