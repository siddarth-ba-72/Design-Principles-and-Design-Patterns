package design.patterns.structural.bridge.models;

public abstract class AbstractScorpio {

    // Bridge
    AbstractScorpioImpl scorpioImpl; // Composition

    protected AbstractScorpio(AbstractScorpioImpl scorpioImpl) {
        this.scorpioImpl = scorpioImpl;
    }

    public abstract boolean isRightHanded();

    public abstract void printSafetyReq();

}
