package seat.code.robotic.mowers.domain;

public class Mower {

    private Coordinate position;
    private HeadingOrientation headingOrientation;

    public Mower(final Coordinate position, final HeadingOrientation headingOrientation) {
        this.position = position;
        this.headingOrientation = headingOrientation;
    }

    public Coordinate getPosition() {
        return this.position;
    }

    public HeadingOrientation getHeadingOrientation() {
        return this.headingOrientation;
    }

    public void turnLeft() {
        this.headingOrientation = this.headingOrientation.turnLeft();
    }

    public void turnRight() {
        this.headingOrientation = this.headingOrientation.turnRight();
    }

    public void moveTo(final Coordinate position) {
        this.position = position;
    }
}
