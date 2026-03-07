package design.patterns.creational.singleton.model;

public class AirCraftOne {

    private static AirCraftOne airCraftInstance;

    private AirCraftOne() {
        // private constructor
        System.out.println("Creating AirCraftOne instance");
    }

    public static AirCraftOne getInstance() {
        if (airCraftInstance == null) {
            airCraftInstance = new AirCraftOne();
        }
        return airCraftInstance;
    }

}
