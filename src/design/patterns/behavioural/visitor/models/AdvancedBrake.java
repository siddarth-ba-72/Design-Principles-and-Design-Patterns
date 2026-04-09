package design.patterns.behavioural.visitor.models;

public class AdvancedBrake extends StandardBrake {

    @Override
    public String playSound() {
        return "Playing advanced brake sound...";
    }

}
