package design.patterns.structural.decorator.models;

public class Scorpio implements ICar {

    @Override
    public void start() {
        System.out.println("Scorpio started");
    }

    @Override
    public void stop() {
        System.out.println("Scorpio stopped");
    }

    @Override
    public float getWeight() {
        return baseWeight;
    }
}
