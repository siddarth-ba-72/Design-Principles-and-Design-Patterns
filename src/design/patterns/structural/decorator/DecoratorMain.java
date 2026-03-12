package design.patterns.structural.decorator;

import design.patterns.structural.decorator.models.ICar;
import design.patterns.structural.decorator.models.Scorpio;

public class DecoratorMain {
    public static void main(String[] args) {

        ICar scorpio = new Scorpio();
        ICar bulletProofScorpio = new BulletProofScorpio(scorpio);

        // the decorator takes the essential feature(s) and adds the extra features on top of it

        System.out.println("Bullet proof Scorpio weight: " + bulletProofScorpio.getWeight());

    }
}
