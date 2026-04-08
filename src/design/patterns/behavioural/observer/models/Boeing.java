package design.patterns.behavioural.observer.models;

public class Boeing implements IAirCraft, IObserver {

    ISubject tower;

    public Boeing(ISubject tower) {
        this.tower = tower;
    }

    @Override
    public void fly() {
        tower.addObserver(this);
        System.out.println("Boeing is flying");
    }

    @Override
    public void land() {
        tower.removeObserver(this);
    }

    @Override
    public void proceed(Object newstate) {
        System.out.println("Boeing received update: " + newstate);
    }
}
