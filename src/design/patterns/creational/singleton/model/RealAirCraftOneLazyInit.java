package design.patterns.creational.singleton.model;

public class RealAirCraftOneLazyInit {

    private RealAirCraftOneLazyInit() {
        // private constructor
        System.out.println("Creating RealAirCraftOne instance");
    }

    public static RealAirCraftOneLazyInit getInstance() {
        return RealAirCraftOneLazyInitHolder.INSTANCE;
    }

    private static class RealAirCraftOneLazyInitHolder {
        private static final RealAirCraftOneLazyInit INSTANCE = new RealAirCraftOneLazyInit();
    }

}
