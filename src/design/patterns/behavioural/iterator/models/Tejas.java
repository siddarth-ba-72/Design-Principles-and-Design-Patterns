package design.patterns.behavioural.iterator.models;

public class Tejas implements IAirCraft {

    private String name;

    public Tejas(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tejas: " + name;
    }

}
