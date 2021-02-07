package seat.code.robotic.mowers.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seat.code.robotic.mowers.domain.mower.MowerData;
import seat.code.robotic.mowers.domain.plateau.Plateau;

class ExplorePlateauServiceShould {

    ExplorePlateauService explorePlateauService;

    @BeforeEach
    void setUp() {
        final Plateau plateau = new Plateau(5, 5);
        this.explorePlateauService = new ExplorePlateauService(plateau);
    }

    @Test
    void whenMoverIsOutOfPlateauThenExecuteException() {
        final Exception exception = assertThrows(InvalidParameterException.class, () ->
            this.explorePlateauService.runMower(new MowerData("6 2 N", "")));
        assertEquals("The mower is out of the plateau", exception.getMessage());
    }

    @Test
    void whenHeadingOrientationIsUndefinedThenExecuteException() {
        final Exception exception = assertThrows(InvalidParameterException.class, () ->
            this.explorePlateauService.runMower(new MowerData("1 2 Y", "")));
        assertEquals("Heading orientation cannot be determined", exception.getMessage());
    }

    @Test
    void whenCommandIsEmptyThenFinalPositionIsSameAsInitialPosition() {
        final String initialPosition = "1 2 N";
        final String actual = this.explorePlateauService.runMower(new MowerData(initialPosition, ""));

        assertThat(actual).isEqualTo(initialPosition);
    }

    @ParameterizedTest
    @CsvSource({
        "1 2 N, LMLMLMLMM, 1 3 N",
        "3 3 E, MMRMMRMRRM, 5 1 E"
    })
    void roboticMowerShouldExploreThePlateau(final String initialPosition, final String commands, final String finalPosition) {
        final String actual = this.explorePlateauService.runMower(new MowerData(initialPosition, commands));

        assertThat(actual).isEqualTo(finalPosition);
    }
}