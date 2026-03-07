package design.patterns.creational.factory.model;

public class ScorpioClassic extends Scorpio {

    @Override
    public void makeScorpio() {
        System.out.println("Making ScorpioClassic");
        this.engine = new ScorpioClassicEngine();
        this.bodyShell = new ScorpioClassicBodyShell();
    }

    @Override
    public void driveCar() {
        makeScorpio();
        System.out.println("Driving a Scorpio Classic");
    }

}
