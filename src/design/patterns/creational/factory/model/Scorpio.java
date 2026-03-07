package design.patterns.creational.factory.model;

public class Scorpio {

    IEngine engine;
    IBodyShell bodyShell;

    public void makeScorpio() {
        System.out.println("Making Scorpio");
        this.engine = new ScorpioEngine();
        this.bodyShell = new ScorpioBodyShell();
    }

    public void driveCar() {
        makeScorpio();
        System.out.println("Driving a Scorpio");
    }

}
