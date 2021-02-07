package seat.code.robotic.mowers.domain.mower;

public class Mower {

    private Coordinate position;
    private HeadingOrientation headingOrientation;

    public Mower(final Coordinate position, final HeadingOrientation headingOrientation) {
        this.position = position;
        this.headingOrientation = headingOrientation;
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

    public int getPositionX() {
        return this.position.getX();
    }

    public int getPositionY() {
        return this.position.getY();
    }

    public String getStatus() {
        return String.format("%d %d %s", this.getPositionX(), this.getPositionY(), this.headingOrientation);
    }
}
