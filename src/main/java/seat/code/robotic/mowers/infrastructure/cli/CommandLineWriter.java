package seat.code.robotic.mowers.infrastructure.cli;

public class CommandLineWriter {

    public void printWelcomeMessage() {
        System.out.println("Welcome to the robotic mower control panel");
        System.out.println("Please enter data for Plateau and mowers to start exploring");
    }

    public void printResult(final String result) {
        System.out.println(result);
    }

    public void printGoodbyeMessage() {
        System.out.println("See you soon");
    }
}
