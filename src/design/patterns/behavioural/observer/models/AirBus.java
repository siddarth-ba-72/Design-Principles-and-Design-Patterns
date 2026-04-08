package design.patterns.behavioural.observer.models;

public class AirBus implements IAirCraft, IObserver {

    ISubject tower;

    public AirBus(ISubject tower) {
        this.tower = tower;
    }

    @Override
    public void fly() {
        tower.addObserver(this);
        System.out.println("AirBus is flying");
    }

    @Override
    public void land() {
        tower.removeObserver(this);
    }

    @Override
    public void proceed(Object newstate) {
        System.out.println("AirBus received update: " + newstate);
    }
}
