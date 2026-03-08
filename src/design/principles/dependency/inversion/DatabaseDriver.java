package design.principles.dependency.inversion;

public interface DatabaseDriver {

    void connect();

    void disconnect();

}
