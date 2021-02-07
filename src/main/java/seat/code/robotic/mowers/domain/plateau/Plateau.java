package seat.code.robotic.mowers.domain.plateau;

public class Plateau {

    private final int maxX;
    private final int maxY;

    public Plateau(final int maxX, final int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isValidPosition(final int x, final int y) {
        return (x >= 0) && (x <= this.maxX) && (y >= 0) && (y <= this.maxY);
    }
}
