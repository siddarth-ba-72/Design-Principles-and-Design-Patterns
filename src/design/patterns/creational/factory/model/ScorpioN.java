package design.patterns.creational.factory.model;

public class ScorpioN extends Scorpio{

    @Override
    public void makeScorpio() {
        System.out.println("Making ScorpioN");
        this.engine = new ScorpioNEngine();
        this.bodyShell = new ScorpioNBodyShell();
    }

    @Override
    public void driveCar() {
        makeScorpio();
        System.out.println("Driving a Scorpio N");
    }
}
