package org.oop;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class Point {
    private final double xCoordinate;
    private final double yCoordinate;

    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double distance(Point to) {
        if (this.equals(to))
            return 0;
        Point distance = coordinateDistanceCalculate(to);
        return sqrt(square(distance.xCoordinate) + square(distance.yCoordinate));
    }

    public double direction(Point to) {
        if (this.equals(to))
            return 0;
        Point distance = coordinateDistanceCalculate(to);

        return atan2(distance.yCoordinate, distance.xCoordinate);
    }

    private Point coordinateDistanceCalculate(Point to) {

        double xDistance = to.xCoordinate - this.xCoordinate;
        double yDistance = to.yCoordinate - this.yCoordinate;

        return new Point(xDistance,yDistance);
    }

    public double square(double value) {
        return value * value;
    }

    @Override
    public boolean equals(Object to) {
        if (this == to)
            return true;
        if (!(to instanceof Point))
            return false;

        return this.xCoordinate == ((Point) to).xCoordinate && this.yCoordinate == ((Point) to).yCoordinate;
    }
}