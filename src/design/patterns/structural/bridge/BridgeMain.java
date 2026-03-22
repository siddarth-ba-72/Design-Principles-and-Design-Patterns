package design.patterns.structural.bridge;

import design.patterns.structural.bridge.models.AbstractScorpio;
import design.patterns.structural.bridge.models.ScorpioN;
import design.patterns.structural.bridge.models.ScorpioNImplIndia;

public class BridgeMain {
    public static void main(String[] args) {

        AbstractScorpio scorpio = new ScorpioN(new ScorpioNImplIndia());
        System.out.println(scorpio.isRightHanded());
        scorpio.printSafetyReq();

    }
}
