package design.patterns.structural.proxy;

import design.patterns.structural.proxy.models.RemoteProxy;

import java.util.Scanner;

public class ProxyMain {
    public static void main(String[] args) {

        RemoteProxy remoteProxy = new RemoteProxy();

        while (true) {

            Scanner sc = new Scanner(System.in);
            String action = sc.nextLine().trim().toLowerCase();

            switch (action) {
                case "left" -> remoteProxy.turnLeft();
                case "right" -> remoteProxy.turnRight();
                case "straight" -> remoteProxy.turnStraight();
                default -> System.out.println("Invalid action. Please enter 'left', 'right', or 'straight'.");
            }

            sc.close();
        }

    }
}
