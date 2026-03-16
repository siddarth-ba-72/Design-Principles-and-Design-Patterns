package design.patterns.structural.adapter;

import design.patterns.structural.adapter.models.HotAirBalloon;

public class AdapterMain {
    public static void main(String[] args) {

        HotAirBalloon hotAirBalloon = new HotAirBalloon();
        CarAdapter carAdapter = new CarAdapter(hotAirBalloon);
        carAdapter.start();

    }
}
