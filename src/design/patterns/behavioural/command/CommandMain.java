package design.patterns.behavioural.command;

import design.patterns.behavioural.command.models.*;

public class CommandMain {
    public static void main(String[] args) {

        BrakeMechanism brakeMechanism = new BrakeMechanism();
        AirSuspensionMechanism airSuspensionMechanism = new AirSuspensionMechanism();

        Command brakeCommand = new EngageBrakeCommand(brakeMechanism);
        Command liftSuspensionCommand = new AirSuspensionCommand(airSuspensionMechanism);

        Panel panel = new Panel();
        panel.setCommand(0, liftSuspensionCommand);
        panel.setCommand(1, brakeCommand);

        panel.applyBrakes();
        panel.liftSuspension();

    }
}
