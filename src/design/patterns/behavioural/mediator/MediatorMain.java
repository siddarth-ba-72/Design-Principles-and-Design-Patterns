package design.patterns.behavioural.mediator;

import design.patterns.behavioural.mediator.models.ATCTower;
import design.patterns.behavioural.mediator.models.AirIndia;
import design.patterns.behavioural.mediator.models.Indigo;

public class MediatorMain {
    public static void main(String[] args) {

        ATCTower atcTower = new ATCTower();

        Indigo indigo = new Indigo(atcTower);
        AirIndia airIndia = new AirIndia(atcTower);

        indigo.requestPermissionForLanding();
        airIndia.requestPermissionForLanding();

    }
}
