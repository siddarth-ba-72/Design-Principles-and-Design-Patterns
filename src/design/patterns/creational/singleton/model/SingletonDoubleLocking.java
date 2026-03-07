package design.patterns.creational.singleton.model;

public class SingletonDoubleLocking {

    // Anti-pattern

    private volatile static SingletonDoubleLocking instance;

    private SingletonDoubleLocking() {
        System.out.println("SDL created");
    }

    synchronized public static SingletonDoubleLocking getInstance() {
        if (instance == null) {
            // create instance only when needed
            synchronized (SingletonDoubleLocking.class) {
                if (instance == null) {
                    instance = new SingletonDoubleLocking();
                }
            }
        }
        return instance;
    }

}
