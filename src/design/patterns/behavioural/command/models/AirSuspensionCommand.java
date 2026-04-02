package design.patterns.behavioural.command.models;

public class AirSuspensionCommand implements Command {

    AirSuspensionMechanism airSuspensionMechanism;

    public AirSuspensionCommand(AirSuspensionMechanism airSuspensionMechanism) {
        this.airSuspensionMechanism = airSuspensionMechanism;
    }

    @Override
    public void execute() {
        airSuspensionMechanism.uplift();
    }

}
