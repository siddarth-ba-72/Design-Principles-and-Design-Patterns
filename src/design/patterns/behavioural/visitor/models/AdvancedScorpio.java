package design.patterns.behavioural.visitor.models;

public class AdvancedScorpio extends Scorpio {

    @Override
    public String getCarName() {
        return "Advanced Scorpio";
    }

//    public void applyBrake(StandardBrake normalBrake) {
//        System.out.println(getCarName() + " : Applying standard brake to " + normalBrake.playSound());
//    }
//
//    public void applyBrake(AdvancedBrake advancedBrake) {
//        System.out.println(getCarName() + " : Applying advanced brake to " + advancedBrake.playSound());
//    }

}
