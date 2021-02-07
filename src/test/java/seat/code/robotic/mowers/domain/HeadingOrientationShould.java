package seat.code.robotic.mowers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seat.code.robotic.mowers.domain.mower.HeadingOrientation;

class HeadingOrientationShould {

    @Test
    void whenHeadingOrientationIsLostThenReturnsUndefined() {
        final HeadingOrientation headingOrientation = HeadingOrientation.from("Y");

        assertThat(headingOrientation).isEqualTo(HeadingOrientation.UNDEFINED);
    }

    @ParameterizedTest
    @CsvSource({
        "N, W",
        "E, N",
        "S, E",
        "W, S",
    })
    void shouldTurnLeft(final String current, final String expected) {
        final HeadingOrientation headingOrientation = HeadingOrientation.from(current);

        final HeadingOrientation actual = headingOrientation.turnLeft();

        assertThat(actual).isEqualTo(HeadingOrientation.from(expected));
    }

    @ParameterizedTest
    @CsvSource({
        "N, E",
        "E, S",
        "S, W",
        "W, N",
    })
    void shouldTurnRight(final String current, final String expected) {
        final HeadingOrientation headingOrientation = HeadingOrientation.from(current);

        final HeadingOrientation actual = headingOrientation.turnRight();

        assertThat(actual).isEqualTo(HeadingOrientation.from(expected));
    }
}