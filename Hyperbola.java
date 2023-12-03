public class Hyperbola {
    private double h;
    private double k;
    private double a;
    private double b;

    public Hyperbola(double h, double k, double a, double b) {
        this.h = h;
        this.k = k;
        this.a = a;
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public boolean isVertical() {
        return b > a;
    }

    public double focalDistance() {
        return 2 * Math.sqrt(a * a + b * b);
    }

    public double transverseAxisLength() {
        return 2 * a;
    }

    public double conjugateAxisLength() {
        return 2 * b;
    }

    public double[][] calculateFoci() {
        double c = Math.sqrt(a * a + b * b);
        double[][] foci = new double[2][2];

        if (isVertical()) {
            foci[0][0] = h;
            foci[0][1] = k + c;
            foci[1][0] = h;
            foci[1][1] = k - c;
        } else {
            foci[0][0] = h + c;
            foci[0][1] = k;
            foci[1][0] = h - c;
            foci[1][1] = k;
        }

        return foci;
    }

    public double[][] calculateAxisEndpoints() {
        double[][] endpoints = new double[4][2];

        if (isVertical()) {
            endpoints[0] = new double[]{h, k - a};
            endpoints[1] = new double[]{h, k + a};
            endpoints[2] = new double[]{h - b, k};
            endpoints[3] = new double[]{h + b, k};
        } else {
            endpoints[0] = new double[]{h - a, k};
            endpoints[1] = new double[]{h + a, k};
            endpoints[2] = new double[]{h, k - b};
            endpoints[3] = new double[]{h, k + b};
        }

        return endpoints;
    }

    public double[][] calculateAsymptotes() {
        double[][] asymptotes = new double[2][2];

        if (isVertical()) {
            double slope = a / b;
            asymptotes[0] = new double[]{slope, k - slope * h};
            asymptotes[1] = new double[]{-slope, k + slope * h};
        } else {
            double slope = b / a;
            asymptotes[0] = new double[]{slope, k - slope * h};
            asymptotes[1] = new double[]{-slope, k + slope * h};
        }

        return asymptotes;
    }

    public double[][] calculateVertices() {
        double[][] vertices = new double[2][2];

        if (isVertical()) {
            vertices[0] = new double[]{h, k + a};
            vertices[1] = new double[]{h, k - a};
        } else {
            vertices[0] = new double[]{h + a, k};
            vertices[1] = new double[]{h - a, k};
        }

        return vertices;
    }

    public double[] calculateTangentLine(double x0, double y0) {
        if (isPointOnHyperbola(x0, y0)) {
            double m, c;

            if (isVertical()) {
                m = (a * a) / ((x0 - h) * b * b);
                c = y0 - m * x0;
            } else {
                m = (b * b) / ((y0 - k) * a * a);
                c = y0 - m * x0;
            }

            return new double[]{m, c};
        } else {
            throw new IllegalArgumentException("The point does not lie on the hyperbola.");
        }
    }

    private boolean isPointOnHyperbola(double x0, double y0) {
        if (isVertical()) {
            return Math.abs((y0 - k) * (y0 - k) / (a * a) - (x0 - h) * (x0 - h) / (b * b) - 1) < 0.0001;
        } else {
            return Math.abs((x0 - h) * (x0 - h) / (a * a) - (y0 - k) * (y0 - k) / (b * b) - 1) < 0.0001;
        }
    }

    public Hyperbola calculateConjugateHyperbola() {
        return new Hyperbola(h, k, b, a);
    }

    public double calculateEccentricity() {
        return Math.sqrt(1 + (b * b) / (a * a));
    }

    public double[] calculateCenter() {
        return new double[]{h, k};
    }
}
