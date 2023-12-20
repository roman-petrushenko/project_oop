package com.example.geometricobjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParabolaTest {

    private Parabola parabola;

    @BeforeEach
    void setUp() {
        parabola = new Parabola(1, 0, 0, true);
    }

    @Test
    void testGetFocus() {
        double[] focus = parabola.getFocus();
        assertNotNull(focus, "Focus should not be null.");
        assertEquals(0.0, focus[0], "X-coordinate of the focus is incorrect.");
        assertEquals(0.25, focus[1], "Y-coordinate of the focus is incorrect.");
    }

    @Test
    void testGetDirectrix() {
        double[] directrix = parabola.getDirectrix();
        assertNotNull(directrix, "Directrix should not be null.");
        assertEquals(-0.25, directrix[1], "Y-coordinate of the directrix is incorrect.");
    }

    @Test
    void testGetAxisOfSymmetry() {
        double[] axisOfSymmetry = parabola.getAxisOfSymmetry();
        assertNotNull(axisOfSymmetry, "Axis of Symmetry should not be null.");
        assertEquals(0.0, axisOfSymmetry[0], "X-coordinate of the axis of symmetry is incorrect.");
    }

    @Test
    void testGetLatusRectum() {
        double[][] latusRectum = parabola.getLatusRectum();
        assertNotNull(latusRectum, "Latus Rectum should not be null.");
    }

    @Test
    void testGetTangentLine() {
        double[] point = {1, 1}; // Point on the parabola
        double[] tangentLine = parabola.getTangentLine(point[0], point[1]);
        assertNotNull(tangentLine, "Tangent line should not be null.");
    }

}