package design.patterns.behavioural.observer.models;

public interface ISubject {

    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();

}
