package design.patterns.creational.singleton;

import design.patterns.creational.singleton.model.AirCraftOne;

public class RaceSingletonMain {
    public static void main(String[] args) {

        Thread th1 = new Thread(AirCraftOne::getInstance);
        Thread th2 = new Thread(AirCraftOne::getInstance);

        th1.start();
        th2.start();

        // Creates 2 instances of AirCraftOne because of the multithreaded environment

    }
}
