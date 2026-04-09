package design.patterns.behavioural.iterator.models;

public class Boeing implements IAirCraft {

    private String name;

    public Boeing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boeing: " + name;
    }

}
