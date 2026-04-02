package design.patterns.behavioural.command.models;

public class EngageBrakeCommand implements Command {

    BrakeMechanism brakeMechanism;

    public EngageBrakeCommand(BrakeMechanism brakeMechanism) {
        this.brakeMechanism = brakeMechanism;
    }

    @Override
    public void execute() {
        brakeMechanism.applyBrakes();
    }
}
