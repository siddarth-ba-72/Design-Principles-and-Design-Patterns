package design.patterns.creational.singleton;

import design.patterns.creational.singleton.model.RealAirCraftOneLazyInit;

public class SingletonOptimizedMain {
    public static void main(String[] args) {

        Thread th1 = new Thread(RealAirCraftOneLazyInit::getInstance);
        Thread th2 = new Thread(RealAirCraftOneLazyInit::getInstance);

        th1.start();
        th2.start();

        // Constructor called only once

    }
}
