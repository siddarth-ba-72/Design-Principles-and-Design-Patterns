package design.patterns.behavioural.iterator.models;

import java.util.LinkedList;
import java.util.List;

public class AirForceIterator implements CustomIterator {

    List<IAirCraft> jets;
    IAirCraft[] helis;
    LinkedList<Boeing> cargo;

    int jetsIndex = 0;
    int helisIndex = 0;
    int cargoIndex = 0;

    public AirForceIterator(AirForce airForce) {
        jets = airForce.getJets();
        helis = airForce.getHelis();
        cargo = airForce.getCargo();
    }

    @Override
    public IAirCraft next() {
        if (helisIndex < helis.length) {
            return helis[helisIndex++];
        }
        if (jetsIndex < jets.size()) {
            return jets.get(jetsIndex++);
        }
        if (cargoIndex < cargo.size()) {
            return cargo.get(cargoIndex++);
        }
        throw new RuntimeException("No more elements to iterate");
    }

    @Override
    public boolean hasNext() {
        return helis.length > helisIndex ||
                jets.size() > jetsIndex ||
                cargo.size() > cargoIndex;
    }
}
