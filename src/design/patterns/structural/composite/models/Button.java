package design.patterns.structural.composite.models;

public class Button implements UIComponent {

    @Override
    public void draw() {
        System.out.println("Drawing button");
    }

    @Override
    public void add(UIComponent component) {
        System.out.println("Adding button");
    }

    @Override
    public void remove(UIComponent component) {
        System.out.println("Removing button");
    }

}
