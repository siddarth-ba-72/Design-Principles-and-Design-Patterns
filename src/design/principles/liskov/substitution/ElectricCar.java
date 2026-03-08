package design.principles.liskov.substitution;

public class ElectricCar extends Vehicle {

    public ElectricCar(String type, int age) {
        super(type, age);
    }

    @Override
    public void fuel() {
        System.out.println("Electric car is being charged...");
    }

    @Override
    protected void speedUp() {
        System.out.println("Electric car is speeding up...");
    }

    @Override
    protected void slowDown() {
        System.out.println("Electric car is slowing down...");
    }

}
