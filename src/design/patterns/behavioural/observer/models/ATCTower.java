package design.patterns.behavioural.observer.models;

import java.util.ArrayList;
import java.util.List;

public class ATCTower implements ISubject {

    List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        System.out.println("Adding observer: " + observer.getClass().getSimpleName());
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        System.out.println("Removing observer: " + observer.getClass().getSimpleName());
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.proceed(this);
        }
    }
}
