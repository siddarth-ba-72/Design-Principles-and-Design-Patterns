package design.patterns.structural.proxy.models;

public class RemoteControlScorpio implements ICar {

    @Override
    public void turnLeft() {
        System.out.println("Turning left with Scorpio");
    }

    @Override
    public void turnRight() {
        System.out.println("Turning right with Scorpio");
    }

    @Override
    public void turnStraight() {
        System.out.println("Turning straight with Scorpio");
    }
}
