package design.patterns.creational.factory;

import design.patterns.creational.factory.model.Scorpio;
import design.patterns.creational.factory.model.ScorpioClassic;
import design.patterns.creational.factory.model.ScorpioN;

public class ScorpioFactory {

    private ScorpioFactory() throws IllegalAccessException {
        throw new IllegalAccessException("Factory utility");
    }

    public static Scorpio createScorpio(char type) {
        switch (type) {
            case 'N' -> {
                return new ScorpioN();
            }
            case 'C' -> {
                return new ScorpioClassic();
            }
            default -> {
                return new Scorpio();
            }
        }
    }

}
