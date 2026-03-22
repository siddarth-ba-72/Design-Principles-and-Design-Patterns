package design.patterns.structural.bridge.models;

public class ScorpioNImplUSA extends AbstractScorpioImpl {

    @Override
    public boolean isRightHanded() {
        return false;
    }

    @Override
    public void printSafetyReq() {
        System.out.println("USA safety requirements: ...");
    }

}
