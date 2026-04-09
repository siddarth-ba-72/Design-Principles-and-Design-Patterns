package design.patterns.behavioural.visitor.models2;

public class Alto implements ICar {

    @Override
    public void accept(ICarVisitor visitor) {
        visitor.visitAlto(this);
    }

}
