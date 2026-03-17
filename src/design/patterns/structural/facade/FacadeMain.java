package design.patterns.structural.facade;

public class FacadeMain {
    public static void main(String[] args) {

        HomeFacade homeFacade = new HomeFacade();

        homeFacade.geyserOn();
        homeFacade.stoveOn();

        homeFacade.geyserOff();
        homeFacade.stoveOff();

    }
}
