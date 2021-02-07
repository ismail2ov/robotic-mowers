package seat.code.robotic.mowers.domain.mower;

public enum HeadingOrientation {
    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N"),
    UNDEFINED("U", "U", "U");

    private final String current;
    private final String left;
    private final String right;

    HeadingOrientation(final String current, final String left, final String right) {
        this.current = current;
        this.left = left;
        this.right = right;
    }

    public static HeadingOrientation from(final String heading) {
        for (final HeadingOrientation headingOrientation : values()) {
            if (headingOrientation.current.equals(heading)) {
                return headingOrientation;
            }
        }
        return HeadingOrientation.UNDEFINED;
    }

    public HeadingOrientation turnLeft() {
        return HeadingOrientation.from(this.left);
    }

    public HeadingOrientation turnRight() {
        return HeadingOrientation.from(this.right);
    }

    @Override
    public String toString() {
        return this.current;
    }
}
