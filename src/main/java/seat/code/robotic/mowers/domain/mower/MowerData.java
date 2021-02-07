package seat.code.robotic.mowers.domain.mower;

public class MowerData {

    String initialPosition;
    String commands;

    public MowerData(final String initialPosition, final String commands) {
        this.initialPosition = initialPosition;
        this.commands = commands;
    }

    public String getInitialPosition() {
        return this.initialPosition;
    }

    public String getCommands() {
        return this.commands;
    }
}
