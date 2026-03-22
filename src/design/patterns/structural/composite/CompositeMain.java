package design.patterns.structural.composite;

import design.patterns.structural.composite.mdoels.Button;
import design.patterns.structural.composite.mdoels.Menu;
import design.patterns.structural.composite.mdoels.UIComponent;

public class CompositeMain {
    public static void main(String[] args) {

        UIComponent uiComponent = new Menu();

        uiComponent.add(new Button());
        uiComponent.add(new Button());

        Button btn = new Button();
        uiComponent.add(btn);

        uiComponent.draw();

        uiComponent.remove(btn);

        uiComponent.draw();

    }
}
