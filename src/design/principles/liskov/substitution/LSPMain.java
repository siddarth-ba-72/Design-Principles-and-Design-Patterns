package design.principles.liskov.substitution;

public class LSPMain {
    public static void main(String[] args) {

        Vehicle electricCar = new ElectricCar("Tesla", 12);
        electricCar.speedUp();
        electricCar.slowDown();
        electricCar.fuel();

        Vehicle petrolCar = new PetrolCar("Toyota", 5);
        petrolCar.speedUp();
        petrolCar.slowDown();
        petrolCar.fuel();

    }
}
