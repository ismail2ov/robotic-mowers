package seat.code.robotic.mowers.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlateauShould {

    Plateau plateau;

    @BeforeEach
    void setUp() {
        this.plateau = new Plateau(5, 5);
    }

    @Test
    void whenPositionIsOnPlateauThenReturnsTrue() {
        final boolean actual = this.plateau.isValidPosition(1, 2);

        assertTrue(actual);
    }

    @Test
    void whenBottomPositionIsLessThanZeroThenReturnsFalse() {
        final boolean actual = this.plateau.isValidPosition(1, -1);

        assertFalse(actual);
    }

    @Test
    void whenLeftPositionIsLessThanZeroThenReturnsFalse() {
        final boolean actual = this.plateau.isValidPosition(-1, 2);

        assertFalse(actual);
    }

    @Test
    void whenUpperPositionIsGreatThanMaxThenReturnsFalse() {
        final boolean actual = this.plateau.isValidPosition(1, 6);

        assertFalse(actual);
    }

    @Test
    void whenRightPositionIsGreatThanMaxThenReturnsFalse() {
        final boolean actual = this.plateau.isValidPosition(6, 2);

        assertFalse(actual);
    }
}