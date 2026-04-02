package design.patterns.behavioural.chainofresponsibility;

import design.patterns.behavioural.chainofresponsibility.models.AbstractHandler;
import design.patterns.behavioural.chainofresponsibility.models.EngineIssueHandler;
import design.patterns.behavioural.chainofresponsibility.models.PressureIssueHandler;
import design.patterns.behavioural.chainofresponsibility.models.PressureIssueRequest;

public class ChainOfResponsibilityMain {
    public static void main(String[] args) {

        AbstractHandler pressureHandle = new PressureIssueHandler(null);
        EngineIssueHandler engineHandle = new EngineIssueHandler(pressureHandle);

        PressureIssueRequest pressureIssueRequest = new PressureIssueRequest();
        engineHandle.handleRequest(pressureIssueRequest);

    }
}
