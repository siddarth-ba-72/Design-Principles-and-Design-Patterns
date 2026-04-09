package design.patterns.behavioural.visitor.models2;

public class InsurancePriceVisitor implements ICarVisitor {

    public void visitScorpio(Scorpio scorpio) {
        System.out.println("Scorpio insurance price is 10000");
    }

    public void visitAlto(Alto alto) {
        System.out.println("Alto insurance price is 5000");
    }

}
