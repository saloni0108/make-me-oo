package org.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PointTest {
    @Test
    void shouldReturnZeroWhenDistanceBetweenTwoPointsWithSameXAndYCoordinatesIsMeasured() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        assertThat(point1.distance(point2), is(closeTo(0,0.01)));
    }

    @Test
    void shouldReturnOneWhenDistanceBetweenOriginAndPointsOnUnitCircleIsMeasured() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(1, 0);
        Point point2 = new Point(0, 1);
        assertThat(point1.distance(origin), is(closeTo(1,0.01)));
        assertThat(point2.distance(origin), is(closeTo(1,0.01)));
    }

    @Test
    void shouldReturnTwoWhenDistanceBetweenTwoOppositePointsOnUnitCircleIsMeasured() {
        Point point1 = new Point(1, 0);
        Point point2 = new Point(-1, 0);

        assertThat(point1.distance(point2), is(closeTo(2,0.01)));
    }

    @Test
    void shouldReturnPiWhenDirectionOfOriginAndPointOnPositiveXAxisIsMeasured() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(1, 0);
        Point point2 = new Point(3, 0);
        assertThat(point1.direction(origin), is(closeTo(Math.PI,0.01)));
        assertThat(point2.direction(origin), is(closeTo(Math.PI,0.01)));

    }

    @Test
    void shouldReturnPiWhenDirectionOfOriginAndPointOnNegativeXAxisIsMeasured() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(-1, 0);
        Point point2 = new Point(-3, 0);

        assertThat(Math.PI, is(equalTo(origin.direction(point1))));
        assertThat(Math.PI, is(equalTo(origin.direction(point2))));
    }

    @Test
    void shouldReturnHalfPiWhenDirectionOfOriginAndPointOnYAxisIsMeasured() {
        Point origin = new Point(0, 0);
        Point point1 = new Point(0, 1);
        Point point2 = new Point(0, 3);

        assertThat(Math.PI / 2, is(equalTo(origin.direction(point1))));
        assertThat(Math.PI / 2, is(equalTo(origin.direction(point2))));
    }
}