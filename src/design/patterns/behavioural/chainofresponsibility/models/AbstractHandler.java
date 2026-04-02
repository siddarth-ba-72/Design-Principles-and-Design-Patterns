package design.patterns.behavioural.chainofresponsibility.models;

public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    public AbstractHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(AbstractRequest request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

}
