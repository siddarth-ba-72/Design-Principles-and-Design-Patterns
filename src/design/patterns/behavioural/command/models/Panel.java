package design.patterns.behavioural.command.models;

public class Panel {

    private Command[] commands;

    public Panel() {
        commands = new Command[5];
    }

    public Command getCommand(int index) {
        return commands[index];
    }

    public void setCommand(int index, Command command) {
        commands[index] = command;
    }

    public void liftSuspension() {
        commands[0].execute();
    }

    public void applyBrakes() {
        commands[1].execute();
    }

}
