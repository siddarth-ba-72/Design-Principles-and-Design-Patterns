package design.patterns.creational.singleton;

import design.patterns.creational.singleton.model.AirCraftOne;

public class SingletonMain {
    public static void main(String[] args) {

        AirCraftOne airCraftOne = AirCraftOne.getInstance();

        AirCraftOne secondAF = AirCraftOne.getInstance();

        System.out.println(airCraftOne == secondAF);

    }
}
