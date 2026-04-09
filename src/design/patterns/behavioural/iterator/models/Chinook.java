package design.patterns.behavioural.iterator.models;

public class Chinook implements IAirCraft {

    private String name;

    public Chinook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chinook: " + name;
    }

}
