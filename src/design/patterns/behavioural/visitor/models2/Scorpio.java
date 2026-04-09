package design.patterns.behavioural.visitor.models2;

public class Scorpio implements ICar {

    @Override
    public void accept(ICarVisitor visitor) {
        visitor.visitScorpio(this);
    }

}
