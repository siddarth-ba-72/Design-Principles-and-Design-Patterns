package design.patterns.behavioural.mediator.models;

public class AirIndia implements IAircraft {

    ATCTower atcTower;

    public AirIndia(ATCTower atcTower) {
        this.atcTower = atcTower;
    }

    @Override
    public void land() {
        System.out.println("Air India is landing.");
    }

    public void requestPermissionForLanding() {
        atcTower.requestToLand(this);
    }

}
