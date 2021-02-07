package seat.code.robotic.mowers.infrastructure.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import seat.code.robotic.mowers.domain.mower.MowerData;
import seat.code.robotic.mowers.domain.plateau.Plateau;

public class CommandLineReader {

    Scanner scanner = new Scanner(System.in);

    public Plateau readPlatoData() {
        System.out.println("Please insert upper-right coordinates of the plateau separated by space");
        final String scan = this.scanner.nextLine();
        final String[] coordinates = scan.split(" ");
        return new Plateau(Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[0]));
    }

    public List<MowerData> readMowersData() {
        final List<MowerData> moversData = new ArrayList<>();
        while (true) {
            System.out.println("Please enter mower’s position:");
            System.out.println("is made up of two integers and a letter separated by spaces");
            System.out.println("Example: 1 2 N");
            final String initialPosition = this.scanner.nextLine();
            if ("".equals(initialPosition)) {
                break;
            }
            System.out.println("Please enter mower’s move instructions:");
            System.out.println("Example: LMLMLMLMM");
            final String commands = this.scanner.nextLine();
            if ("".equals(commands)) {
                break;
            }

            moversData.add(new MowerData(initialPosition, commands));
        }
        return moversData;
    }
}
