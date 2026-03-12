package design.patterns.structural.decorator;

import design.patterns.structural.decorator.models.ICar;

public class BulletProofScorpio extends ScorpioDecorator {

    public BulletProofScorpio(ICar car) {
        super(car);
    }

    // start and stop functionality remains same
    // as this is a bulletproof scorpio, the weight will increase

    @Override
    public float getWeight() {
        return 300f + this.scorpio.getWeight();
    }
}
