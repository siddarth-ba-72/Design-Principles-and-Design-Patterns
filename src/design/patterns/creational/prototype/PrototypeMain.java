package design.patterns.creational.prototype;

import design.patterns.creational.prototype.models.IScorpioPrototype;
import design.patterns.creational.prototype.models.Scorpio;
import design.patterns.creational.prototype.models.ScorpioClassicEngine;
import design.patterns.creational.prototype.models.ScorpioNEngine;

public class PrototypeMain {
    public static void main(String[] args) {

        // create a prototype
        IScorpioPrototype scorpioPrototype = new Scorpio();

        // create ScorpioN
        IScorpioPrototype scorpioN = scorpioPrototype.clone();
        scorpioN.setEngine(new ScorpioNEngine());
        scorpioN.start();

        // create ScorpioClassic
        IScorpioPrototype scorpioClassic = scorpioPrototype.clone();
        scorpioClassic.setEngine(new ScorpioClassicEngine());
        scorpioClassic.start();

    }
}
