public class Parabola {
    private double a;
    private double b;
    private double c;
    private boolean isVertical;

    public Parabola(double a, double b, double c, boolean isVertical) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.isVertical = isVertical;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public double getY(double x) {
        if (isVertical) {
            return a * x * x + b * x + c;
        } else {
            throw new IllegalStateException("This is a horizontal parabola.");
        }
    }

    public double getX(double y) {
        if (!isVertical) {
            return a * y * y + b * y + c;
        } else {
            throw new IllegalStateException("This is a vertical parabola.");
        }
    }

    public double[] getVertex() {
        double[] vertex = new double[2];
        if (isVertical) {
            vertex[0] = -b / (2 * a);
            vertex[1] = a * Math.pow(vertex[0], 2) + b * vertex[0] + c;
        } else {
            vertex[1] = -b / (2 * a);
            vertex[0] = a * Math.pow(vertex[1], 2) + b * vertex[1] + c;
        }
        return vertex;
    }

    public double[] getFocus() {
        double h, k;
        double[] focus = new double[2];

        if (isVertical) {
            h = -b / (2 * a);
            k = c - (b * b) / (4 * a);
            focus[0] = h;
            focus[1] = k + 1 / (4 * a);
        } else {
            h = -b / (2 * a);
            k = c - (b * b) / (4 * a);
            focus[0] = k + 1 / (4 * a);
            focus[1] = h;
        }

        return focus;
    }

    public double[] getDirectrix() {
        double[] directrix = new double[3];
        double h = -b / (2 * a);
        double k = c - (b * b) / (4 * a);

        if (isVertical) {
            directrix[0] = 0;
            directrix[1] = 1;
            directrix[2] = -(k - 1 / (4 * a));
        } else {
            directrix[0] = 1;
            directrix[1] = 0;
            directrix[2] = -(k - 1 / (4 * a));
        }

        return directrix;
    }

    public double[] getAxisOfSymmetry() {
        double[] axis = new double[3]; // Ax + By + C = 0
        double h = -b / (2 * a);

        if (isVertical) {
            axis[0] = 1;
            axis[1] = 0;
            axis[2] = -h;
        } else {
            axis[0] = 0;
            axis[1] = 1;
            axis[2] = -h;
        }

        return axis;
    }

    public double[][] getLatusRectum() {
        double h = -b / (2 * a);
        double k = c - (b * b) / (4 * a);
        double focalLength = 1 / (4 * Math.abs(a));
        double[][] latusRectum = new double[2][2];

        if (isVertical) {
            latusRectum[0][0] = h - focalLength;
            latusRectum[0][1] = k + 1 / (4 * a);

            latusRectum[1][0] = h + focalLength;
            latusRectum[1][1] = k + 1 / (4 * a);
        } else {
            latusRectum[0][0] = k + 1 / (4 * a);
            latusRectum[0][1] = h - focalLength;

            latusRectum[1][0] = k + 1 / (4 * a);
            latusRectum[1][1] = h + focalLength;
        }

        return latusRectum;
    }

    public double[] getTangentLine(double x0, double y0) {
        double[] tangent = new double[3]; // Ax + By + C = 0

        if (isVertical) {
            if (y0 != a * x0 * x0 + b * x0 + c) {
                throw new IllegalArgumentException("The point does not lie on the parabola.");
            }
        } else {
            if (x0 != a * y0 * y0 + b * y0 + c) {
                throw new IllegalArgumentException("The point does not lie on the parabola.");
            }
        }

        double slope;

        if (isVertical) {
            slope = 2 * a * x0 + b;
            tangent[0] = slope;
            tangent[1] = -1;
            tangent[2] = y0 - slope * x0;
        } else {
            slope = 2 * a * y0 + b;
            tangent[0] = -1;
            tangent[1] = slope;
            tangent[2] = x0 - slope * y0;
        }

        return tangent;
    }

    @Override
    public String toString() {
        return (isVertical ? "y = " : "x = ") + a + (isVertical ? "x^2 + " : "y^2 + ") + b + (isVertical ? "x + " : "y + ") + c;
    }
}

