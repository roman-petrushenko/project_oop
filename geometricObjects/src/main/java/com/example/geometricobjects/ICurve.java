package com.example.geometricobjects;

public interface ICurve {
    double curvature();
    double[] tangentAt(double x, double y);
}
