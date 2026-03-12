package design.patterns.creational.prototype.models;

public class Scorpio implements IScorpioPrototype, Cloneable {

    // default engine

    ScorpioEngine engine;

    public Scorpio() {
        // default engine
        this.engine = new ScorpioEngine();
    }

    private Scorpio(ScorpioEngine scorpioEngine) {
        // deep copy of the default engine using copy constructor
        this.engine = new ScorpioEngine(scorpioEngine);
    }

    @Override
    public IScorpioPrototype clone() {
//        IScorpioPrototype clonedScorpio = new Scorpio();
//        clonedScorpio.setEngine(new ScorpioEngine());
//        return clonedScorpio;

        // Deep copy
        return new Scorpio(this.engine);
    }

    @Override
    public void setEngine(ScorpioEngine engine) {
        this.engine = engine;
    }

    @Override
    public void start() {
        System.out.println("Scorpio started");
    }
}
