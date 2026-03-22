package design.patterns.structural.flyweight;

import design.patterns.structural.flyweight.models.Tejas;

public class FlyWeightMain {
    public static void main(String[] args) {

        Tejas plane = new Tejas();

        for (int i = 0; i < 5; i++) {
            // variables that can change for each plane
            int srcX = 5;
            int srcY = 10;
            int destX = 100;
            int destY = 515;
            int speed = 1500;
            System.out.println("Time to reach destination: " + plane.getTotalTimeToReachDestination(srcX, srcY, destX, destY, speed));
        }

    }
}
