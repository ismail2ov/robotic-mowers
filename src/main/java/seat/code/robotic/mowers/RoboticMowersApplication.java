package seat.code.robotic.mowers;

import java.util.List;
import seat.code.robotic.mowers.application.ExplorePlateauService;
import seat.code.robotic.mowers.domain.mower.MowerData;
import seat.code.robotic.mowers.domain.plateau.Plateau;
import seat.code.robotic.mowers.infrastructure.cli.CommandLineReader;
import seat.code.robotic.mowers.infrastructure.cli.CommandLineWriter;

public class RoboticMowersApplication {

    public static void main(final String[] args) {
        new RoboticMowersApplication().run(args);
    }

    private void run(final String[] args) {
        final CommandLineReader reader = new CommandLineReader();
        final CommandLineWriter writer = new CommandLineWriter();

        writer.printWelcomeMessage();
        final Plateau plateau = reader.readPlatoData();
        final ExplorePlateauService explorePlateauService = new ExplorePlateauService(plateau);

        final List<MowerData> mowers = reader.readMowersData();

        for (final MowerData mower : mowers) {
            writer.printResult(explorePlateauService.runMower(mower.getInitialPosition(), mower.getCommands()));
        }

        writer.printGoodbyeMessage();

    }

}
