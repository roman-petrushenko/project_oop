package com.example.geometricobjects;

import java.util.ArrayList;
import java.util.List;

public class Circle implements IShape, IContainment, ICurve{

    @Override
    public double curvature() {
        return 1 / radius;
    }

    @Override
    public double[] tangentAt(double x, double y) {
        if (!isInside(x, y)) {
            throw new IllegalArgumentException("Point must be on the circle.");
        }

        double slopeRadius = (y - yCenter) / (x - xCenter);
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



    private double radius;
    private double xCenter;
    private double yCenter;
    private List<Chord> chords = new ArrayList<>();
    private List<Sector> sectors = new ArrayList<>();
    private List<Segment> segments = new ArrayList<>();

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getXCenter() {
        return xCenter;
    }

    public void setXCenter(double xCenter) {
        this.xCenter = xCenter;
    }

    public double getYCenter() {
        return yCenter;
    }

    public void setYCenter(double yCenter) {
        this.yCenter = yCenter;
    }
    public Circle(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public void addSector(double centralAngle) {
        sectors.add(new Sector(centralAngle));
    }

    public void updateSector(int index, double centralAngle) {
        if (index >= 0 && index < sectors.size()) {
            sectors.get(index).setCentralAngle(centralAngle);
        } else {
            System.out.println("Invalid sector index");
        }
    }

    public Sector getSector(int index) {
        if (index >= 0 && index < sectors.size()) {
            return sectors.get(index);
        } else {
            System.out.println("Invalid sector index");
            return null;
        }
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(double x, double y) {
        double dx = x - xCenter;
        double dy = y - yCenter;
        return dx * dx + dy * dy <= radius * radius;
    }

    public String toString() {
        return "Circle[Radius: " + radius + ", Center: (" + xCenter + ", " + yCenter + ")]";
    }

    public double distanceBetweenChords(double x1, double y1, double x2, double y2,
                                        double x3, double y3, double x4, double y4) {
        double distChord1 = distanceFromCenterToChord(x1, y1, x2, y2);
        double distChord2 = distanceFromCenterToChord(x3, y3, x4, y4);

        return Math.abs(distChord1 - distChord2);
    }

    private double distanceFromCenterToChord(double x1, double y1, double x2, double y2) {
        double A = y2 - y1;
        double B = x1 - x2;
        double C = x2*y1 - x1*y2;

        return Math.abs(A * xCenter + B * yCenter + C) / Math.sqrt(A * A + B * B);
    }

    public double areaOfSector(double angleInRadians) {
        return 0.5 * radius * radius * angleInRadians;
    }

    public Circle createCircleWithNewRadius(double newRadius) {
        return new Circle(newRadius, this.xCenter, this.yCenter);
    }

    public void updateChord(int index, double x1, double y1, double x2, double y2) {
        if (index >= 0 && index < chords.size()) {
            Chord chord = chords.get(index);
            chord.setX1(x1);
            chord.setY1(y1);
            chord.setX2(x2);
            chord.setY2(y2);
        } else {
            System.out.println("Invalid chord index");
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

    public void removeChord(int index) {
        if (index >= 0 && index < chords.size()) {
            chords.remove(index);
        } else {
            System.out.println("Invalid chord index: " + index);
        }
    }

    public void addChord(double x1, double y1, double x2, double y2) {
        if (isOnCircle(x1, y1) && isOnCircle(x2, y2)) {
            chords.add(new Chord(x1, y1, x2, y2));
        } else {
            System.out.println("Both points must be on the circle to form a chord.");
        }
    }

    private boolean isOnCircle(double x, double y) {
        return Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2) == Math.pow(radius, 2);
    }

    public class Chord {
        private double x1, y1;
        private double x2, y2;

        public Chord(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double getX1() { return x1; }
        public void setX1(double x1) { this.x1 = x1; }

        public double getY1() { return y1; }
        public void setY1(double y1) { this.y1 = y1; }

        public double getX2() { return x2; }
        public void setX2(double x2) { this.x2 = x2; }

        public double getY2() { return y2; }
        public void setY2(double y2) { this.y2 = y2; }

        @Override
        public String toString() {
            return "Chord[(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]";
        }
    }

    public class Sector {
        private double centralAngle;

        public Sector(double centralAngle) {
            this.centralAngle = centralAngle;
        }

        public double getCentralAngle() { return centralAngle; }
        public void setCentralAngle(double centralAngle) { this.centralAngle = centralAngle; }

        @Override
        public String toString() {
            return "Sector[Central Angle (radians): " + centralAngle + "]";
        }
    }

    public class Segment {
        private double x1, y1;
        private double x2, y2;

        public Segment(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double getX1() { return x1; }
        public void setX1(double x1) { this.x1 = x1; }

        public double getY1() { return y1; }
        public void setY1(double y1) { this.y1 = y1; }

        public double getX2() { return x2; }
        public void setX2(double x2) { this.x2 = x2; }

        public double getY2() { return y2; }
        public void setY2(double y2) { this.y2 = y2; }

        @Override
        public String toString() {
            return "Segment[(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]";
        }
    }
}

