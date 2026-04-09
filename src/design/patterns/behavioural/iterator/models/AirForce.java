package design.patterns.behavioural.iterator.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AirForce {

    List<IAirCraft> jets = new ArrayList<>();
    IAirCraft[] helis = new IAirCraft[1];
    LinkedList<Boeing> cargo = new LinkedList<>();

    public AirForce() {
        jets.add(new Tejas("Tejas 1"));
        helis[0] = new Chinook("Chinook 1");
        cargo.add(new Boeing("Boeing 747"));
    }

    public List<IAirCraft> getJets() {
        return jets;
    }

    public IAirCraft[] getHelis() {
        return helis;
    }

    public LinkedList<Boeing> getCargo() {
        return cargo;
    }

    public CustomIterator createJetsIterator() {
        return new AirForceIterator(this);
    }

}
