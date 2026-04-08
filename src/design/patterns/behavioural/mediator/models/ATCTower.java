package design.patterns.behavioural.mediator.models;

import java.util.ArrayList;
import java.util.List;

public class ATCTower {

    // Has the data of all the planes in the air and on the ground.

    List<IAircraft> queueForLanding = new ArrayList<>();

    public synchronized void requestToLand(IAircraft aircraft) {
        if (queueForLanding.isEmpty()) {
            aircraft.land();
        } else {
            queueForLanding.add(aircraft);
        }
    }

}
