package design.principles.single.responsibility;

public class SRPMain {
    public static void main(String[] args) {

        // get the values
        Pair pair = InputProcessor.process();

        // validate the inputs are fine or not
        if (!ViolationChecker.isValid(pair)) {
            System.out.println("One of the input is invalid...");
            return;
        }

        int firstInteger = Integer.parseInt(pair.getFirst());
        int secondInteger = Integer.parseInt(pair.getSecond());

        // do the mathematical operation
        int result = Operation.execute(firstInteger, secondInteger);

        System.out.println("The result is: " + result);

    }
}
