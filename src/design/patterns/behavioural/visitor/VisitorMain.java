package design.patterns.behavioural.visitor;

import design.patterns.behavioural.visitor.models.AdvancedBrake;
import design.patterns.behavioural.visitor.models.AdvancedScorpio;
import design.patterns.behavioural.visitor.models.StandardBrake;
import design.patterns.behavioural.visitor.models2.*;

import java.util.Iterator;

public class VisitorMain {
    public static void main(String[] args) {

//        Scorpio scorpio = new Scorpio();
//        Scorpio advancedScorpio = new AdvancedScorpio();
//
//        StandardBrake standardBrake = new StandardBrake();
//        StandardBrake advancedBrake = new AdvancedBrake();
//
//        scorpio.applyBrake(standardBrake);
//        advancedScorpio.applyBrake(standardBrake);
//
//        scorpio.applyBrake(advancedBrake);
//        advancedScorpio.applyBrake(advancedBrake);

        Fleet fleet = new Fleet();

        ICar scorpio = new Scorpio();
        ICar alto = new Alto();
        fleet.addCar(scorpio);
        fleet.addCar(alto);

        Iterator<ICar> cars = fleet.getIterator();

        ICarVisitor visitor = new InsurancePriceVisitor();
        while (cars.hasNext()) {
            cars.next().accept(visitor);
        }

    }
}
