package design.patterns.behavioural.chainofresponsibility.models;

public class EngineIssueHandler extends AbstractHandler {

    public final static int code = 302;

    public EngineIssueHandler(AbstractHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if (request.getRequestCode() == code) {
            System.out.println("Engine issue handled.");
        } else {
            super.handleRequest(request);
        }
    }

}
