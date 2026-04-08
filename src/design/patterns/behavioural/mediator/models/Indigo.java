package design.patterns.behavioural.mediator.models;

public class Indigo implements IAircraft {

    ATCTower atcTower;

    public Indigo(ATCTower atcTower) {
        this.atcTower = atcTower;
    }

    @Override
    public void land() {
        System.out.println("Indigo is landing.");
    }

    public void requestPermissionForLanding() {
        atcTower.requestToLand(this);
    }

}
