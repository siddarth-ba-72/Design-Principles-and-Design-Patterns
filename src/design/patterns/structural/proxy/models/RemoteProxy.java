package design.patterns.structural.proxy.models;

public class RemoteProxy implements ICar {

    private final RemoteControlScorpio scorpio = new RemoteControlScorpio();

    @Override
    public void turnLeft() {
        System.out.println("Turning left with Remote Proxy");
        scorpio.turnLeft();
    }

    @Override
    public void turnRight() {
        System.out.println("Turning right with Remote Proxy");
        scorpio.turnRight();
    }

    @Override
    public void turnStraight() {
        System.out.println("Turning straight with Remote Proxy");
        scorpio.turnStraight();
    }
}
