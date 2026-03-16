package design.patterns.structural.adapter.models;

public class HotAirBalloon {

    public String gasUsed = "Helium";

    public void start(String gas) {
        System.out.println("Hot Air Balloon is starting with " + gas);
    }

    String getGasused() {
        return gasUsed;
    }

}
