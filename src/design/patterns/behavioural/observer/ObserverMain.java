package design.patterns.behavioural.observer;

import design.patterns.behavioural.observer.models.ATCTower;
import design.patterns.behavioural.observer.models.AirBus;
import design.patterns.behavioural.observer.models.Boeing;

public class ObserverMain {
    public static void main(String[] args) {

        ATCTower atcTower = new ATCTower();

        Boeing boeing = new Boeing(atcTower);
        AirBus airBus = new AirBus(atcTower);

        boeing.fly();
        airBus.fly();

        boeing.land();
        airBus.land();

    }
}
