package design.patterns.structural.adapter;

import design.patterns.structural.adapter.models.HotAirBalloon;
import design.patterns.structural.adapter.models.ICar;

public class CarAdapter implements ICar {

    HotAirBalloon hotAirBalloon;

    public CarAdapter(HotAirBalloon hotAirBalloon) {
        this.hotAirBalloon = hotAirBalloon;
    }

    @Override
    public void start() {
        String gasToBeUsed = hotAirBalloon.gasUsed;
        hotAirBalloon.start(gasToBeUsed);
    }
}
