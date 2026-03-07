package design.patterns.creational.builder.model;

public class Fortuner implements ICar {

    String engine;

    String chassis;

    String bodyShell;

    String tyre;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getBodyShell() {
        return bodyShell;
    }

    public void setBodyShell(String bodyShell) {
        this.bodyShell = bodyShell;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

}
