package design.patterns.behavioural.chainofresponsibility.models;

public class PressureIssueHandler extends AbstractHandler {

    public final static int code = 303;

    public PressureIssueHandler(AbstractHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if (request.getRequestCode() == code) {
            System.out.println("Pressure issue handled.");
        } else {
            super.handleRequest(request);
        }
    }

}
