package design.patterns.behavioural.chainofresponsibility.models;

public abstract class AbstractRequest {

    private int requestCode;

    AbstractRequest(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getRequestCode() {
        return requestCode;
    }

}
