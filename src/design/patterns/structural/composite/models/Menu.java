package design.patterns.structural.composite.models;

import java.util.ArrayList;
import java.util.List;

public class Menu implements UIComponent {

    // Menu can have multiple components
    // All the parts in this -> Children

    List<UIComponent> children = new ArrayList<>();

    @Override
    public void draw() {
        for (UIComponent component : children) {
            component.draw();
        }
    }

    @Override
    public void add(UIComponent component) {
        children.add(component);
    }

    @Override
    public void remove(UIComponent component) {
        children.remove(component);
    }

}
