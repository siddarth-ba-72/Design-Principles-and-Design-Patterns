package design.patterns.behavioural.iterator;

import design.patterns.behavioural.iterator.models.AirForce;
import design.patterns.behavioural.iterator.models.CustomIterator;

public class IteratorMain {
    public static void main(String[] args) {

        AirForce airForce = new AirForce();
        CustomIterator allPlanes = airForce.createJetsIterator();

        while (allPlanes.hasNext()) {
            System.out.println(allPlanes.next());
        }

    }
}
