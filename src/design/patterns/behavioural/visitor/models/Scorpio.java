package design.patterns.behavioural.visitor.models;

public class Scorpio {

    public String getCarName() {
        return "Scorpio";
    }

    public void applyBrake(StandardBrake normalBrake) {
        System.out.println(getCarName() + " : Applying standard brake to " + normalBrake.playSound());
    }

    public void applyBrake(AdvancedBrake advancedBrake) {
        System.out.println(getCarName() + " : Applying advanced brake to " + advancedBrake.playSound());
    }

}
