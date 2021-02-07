package seat.code.robotic.mowers.application;

import java.security.InvalidParameterException;
import seat.code.robotic.mowers.domain.mower.Coordinate;
import seat.code.robotic.mowers.domain.mower.HeadingOrientation;
import seat.code.robotic.mowers.domain.mower.Mower;
import seat.code.robotic.mowers.domain.plateau.Plateau;

public class ExplorePlateauService {

    private final Plateau plateau;

    public ExplorePlateauService(final Plateau plateau) {
        this.plateau = plateau;
    }

    public String runMower(final String initialPosition, final String commands) {
        final Mower mower = this.buildMover(initialPosition);

        commands.chars().forEach(c -> this.execute(mower, (char) c));

        return mower.getStatus();
    }

    private Mower buildMover(final String initialPosition) {
        final String[] positionValues = initialPosition.split(" ");
        final int x = Integer.parseInt(positionValues[0]);
        final int y = Integer.parseInt(positionValues[1]);
        if (!this.plateau.isValidPosition(x, y)) {
            throw new InvalidParameterException("The mower is out of the plateau");
        }
        final Coordinate position = new Coordinate(x, y);

        final HeadingOrientation headingOrientation = HeadingOrientation.from(positionValues[2]);
        if (headingOrientation.equals(HeadingOrientation.UNDEFINED)) {
            throw new InvalidParameterException("Heading orientation cannot be determined");
        }

        return new Mower(position, headingOrientation);
    }

    private void execute(final Mower mower, final char command) {
        switch (command) {
            case 'L':
                mower.turnLeft();
                break;
            case 'R':
                mower.turnRight();
                break;
            case 'M':
                final Coordinate nextPosition = this.nextPosition(mower);
                if (this.plateau.isValidPosition(nextPosition.getX(), nextPosition.getY())) {
                    mower.moveTo(nextPosition);
                }
                break;
        }
    }

    private Coordinate nextPosition(final Mower mower) {
        int x = mower.getPositionX();
        int y = mower.getPositionY();
        switch (mower.getHeadingOrientation()) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }

        return new Coordinate(x, y);
    }
}
