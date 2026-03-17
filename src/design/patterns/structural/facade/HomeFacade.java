package design.patterns.structural.facade;

import design.patterns.structural.facade.models.ElectricSystem;
import design.patterns.structural.facade.models.GasSystem;
import design.patterns.structural.facade.models.PlumberSystem;
import design.patterns.structural.facade.models.WaterSystem;

public class HomeFacade {

    PlumberSystem plumberSystem;
    ElectricSystem electricSystem;
    WaterSystem waterSystem;
    GasSystem gasSystem;

    public HomeFacade() {
        plumberSystem = new PlumberSystem();
        electricSystem = new ElectricSystem();
        waterSystem = new WaterSystem();
        gasSystem = new GasSystem();
    }

    void geyserOn() {
        electricSystem.turnOn();
        waterSystem.turnOn();
    }

    void geyserOff() {
        electricSystem.turnOff();
        waterSystem.turnOff();
    }

    void stoveOn() {
        electricSystem.turnOn();
        gasSystem.turnOn();
    }

    void stoveOff() {
        electricSystem.turnOff();
        gasSystem.turnOff();
    }

}
