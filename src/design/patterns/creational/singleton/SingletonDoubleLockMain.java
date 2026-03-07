package design.patterns.creational.singleton;

import design.patterns.creational.singleton.model.SingletonDoubleLocking;

public class SingletonDoubleLockMain {
    public static void main(String[] args) {

        Thread th1 = new Thread(SingletonDoubleLocking::getInstance);
        Thread th2 = new Thread(SingletonDoubleLocking::getInstance);

        th1.start();
        th2.start();

        // Constructor called only once

    }
}
