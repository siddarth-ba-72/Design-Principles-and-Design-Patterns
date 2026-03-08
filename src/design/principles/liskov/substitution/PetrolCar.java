package design.principles.liskov.substitution;

public class PetrolCar extends Vehicle {

    public PetrolCar(String type, int age) {
        super(type, age);
    }

    @Override
    public void fuel() {
        System.out.println("Petrol car fuel method...");
    }

    @Override
    protected void speedUp() {
        System.out.println("Petrol car is speeding up...");
    }

    @Override
    protected void slowDown() {
        System.out.println("Petrol car is slowing down...");
    }
}
