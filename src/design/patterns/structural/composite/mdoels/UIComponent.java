package design.patterns.structural.composite.mdoels;

public interface UIComponent {

    void draw();

    void add(UIComponent component);

    void remove(UIComponent component);

}
