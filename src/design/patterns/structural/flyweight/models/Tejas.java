package design.patterns.structural.flyweight.models;

public class Tejas {

    // Intrinsic state
    private final String name = "Tejas";
    private final int seater = 2;
    private final String dimensions = "15m long 4m wide";
    private final String wingSpan = "40 feet";

    // extrinsic state
    public double getTotalTimeToReachDestination(
            int srcX, int srcY,
            int destX, int destY,
            int speed
    ) {
        return 5;
    }

}
