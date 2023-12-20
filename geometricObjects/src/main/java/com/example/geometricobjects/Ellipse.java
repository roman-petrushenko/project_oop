package com.example.geometricobjects;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends Circle implements IShape, IContainment, ICurve{

    @Override
    public double curvature() {
        return 1 / getRadius();
    }

    @Override
    public double[] tangentAt(double x, double y) {
        if (!isInside(x, y)) {
            throw new IllegalArgumentException("Point must be on the circle.");
        }

        double slopeRadius = (y - getYCenter()) / (x - getYCenter());
        double slopeTangent = -1 / slopeRadius;
        double yIntercept = y - slopeTangent * x;
        return new double[]{slopeTangent, yIntercept};
    }


    @Override
    public double perimeter() {
        return circumference();
    }

    @Override
    public boolean contains(double x, double y) {
        return isInside(x, y);
    }

    private double minorRadius;

    public Ellipse(double majorRadius, double minorRadius, double xCenter, double yCenter) {
        super(majorRadius, xCenter, yCenter);
        this.minorRadius = minorRadius;
    }

    public double getMinorRadius() {return minorRadius;}

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }

    private double focalDistance() {
        double a = getRadius();
        double b = minorRadius;
        return Math.sqrt(a * a - b * b);
    }

    public double eccentricity() {
        double a = getRadius();
        double c = focalDistance();
        return c / a;
    }

    public double[][] getFoci() {
        double c = focalDistance();
        double[][] foci = new double[2][2];
        foci[0][0] = getXCenter() - c;
        foci[0][1] = getYCenter();
        foci[1][0] = getXCenter() + c;
        foci[1][1] = getYCenter();
        return foci;
    }

    public double area() {
        return Math.PI * getRadius() * minorRadius;
    }

    public double circumference() {
        double a = getRadius();
        double b = minorRadius;
        double h = Math.pow((a - b), 2) / Math.pow((a + b), 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    @Override
    public String toString() {
        return "Ellipse[Major Radius: " + getRadius() + ", Minor Radius: " + minorRadius
                + ", Center: (" + getXCenter() + ", " + getYCenter() + ")]";
    }

    public double[][][] getLinesOfSymmetry() {
        double xCenter = getXCenter();
        double yCenter = getYCenter();

        double[][] verticalLine = {{xCenter, yCenter - minorRadius}, {xCenter, yCenter + minorRadius}};
        double[][] horizontalLine = {{xCenter - getRadius(), yCenter}, {xCenter + getRadius(), yCenter}};

        return new double[][][]{verticalLine, horizontalLine};
    }

    public double[] tangentLineAtPoint(double x0, double y0) {
        double a = getRadius();
        double b = minorRadius;

        if (Math.pow((x0 - getXCenter()) / a, 2) + Math.pow((y0 - getYCenter()) / b, 2) != 1) {
            throw new IllegalArgumentException("The point is not on the ellipse.");
        }

        double m = -((b * b) * (x0 - getXCenter())) / ((a * a) * (y0 - getYCenter()));

        double yIntercept = y0 - m * x0;

        return new double[] {m, yIntercept};
    }

    public double[] getDirectrices() {
        double a = getRadius();
        double b = minorRadius;
        double c = focalDistance();

        double directrixDistance = a * a / c;
        double directrixLeft = getXCenter() - directrixDistance;
        double directrixRight = getXCenter() + directrixDistance;

        return new double[] {directrixLeft, directrixRight};
    }

    private List<Chord> chords = new ArrayList<>();

    public void addChord(double x1, double y1, double x2, double y2) {
        if (isOnEllipse(x1, y1) && isOnEllipse(x2, y2)) {
            chords.add(new Chord(x1, y1, x2, y2));
        } else {
            System.out.println("Both points must be on the ellipse to form a chord.");
        }
    }

    private boolean isOnEllipse(double x, double y) {
        double a = getRadius();
        double b = minorRadius;
        double xCenter = getXCenter();
        double yCenter = getYCenter();

        return Math.pow((x - xCenter) / a, 2) + Math.pow((y - yCenter) / b, 2) == 1;
    }

    public void removeChord(int index) {
        if (index >= 0 && index < chords.size()) {
            chords.remove(index);
        } else {
            System.out.println("Invalid chord index");
        }
    }

    public void updateChord(int index, double x1, double y1, double x2, double y2) {
        if (isOnEllipse(x1, y1) && isOnEllipse(x2, y2)) {
            if (index >= 0 && index < chords.size()) {
                Chord chord = chords.get(index);
                chord.setX1(x1);
                chord.setY1(y1);
                chord.setX2(x2);
                chord.setY2(y2);
            } else {
                System.out.println("Invalid chord index");
            }
        } else {
            System.out.println("Both points must be on the ellipse to form a valid chord.");
        }
    }

    public Chord getChord(int index) {
        if (index >= 0 && index < chords.size()) {
            return chords.get(index);
        } else {
            System.out.println("Invalid chord index");
            return null;
        }
    }
}
