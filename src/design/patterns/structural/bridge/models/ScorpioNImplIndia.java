package design.patterns.structural.bridge.models;

public class ScorpioNImplIndia extends AbstractScorpioImpl {

    @Override
    public boolean isRightHanded() {
        return true;
    }

    @Override
    public void printSafetyReq() {
        System.out.println("Airbags, ABS, EBD, ESC");
    }

}
