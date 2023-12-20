package com.example.geometricobjects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HyperbolaTest {

    private Hyperbola hyperbola;

    @BeforeEach
    void setUp() {
        hyperbola = new Hyperbola(0, 0, 5, 3);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(0, hyperbola.getH(), "Center X-coordinate (h) is incorrect.");
        assertEquals(0, hyperbola.getK(), "Center Y-coordinate (k) is incorrect.");
        assertEquals(5, hyperbola.getA(), "Semi-transverse axis length (a) is incorrect.");
        assertEquals(3, hyperbola.getB(), "Semi-conjugate axis length (b) is incorrect.");
    }

    @Test
    void testIsVertical() {
        assertFalse(hyperbola.isVertical(), "Hyperbola should not be vertical for a > b.");
    }

    @Test
    void testCalculateFoci() {
        double[][] foci = hyperbola.calculateFoci();
        assertNotNull(foci, "Foci should not be null.");
        assertEquals(2, foci.length, "There should be two foci.");
        assertEquals(Math.sqrt(34), foci[0][0], 0.001, "X-coordinate of first focus is incorrect.");
        assertEquals(0, foci[0][1], "Y-coordinate of first focus should be 0.");
    }

    @Test
    void testCalculateVertices() {
        double[][] vertices = hyperbola.calculateVertices();
        assertNotNull(vertices, "Vertices should not be null.");
        assertEquals(2, vertices.length, "There should be two vertices.");
    }

    @Test
    void testCalculateEccentricity() {
        double eccentricity = hyperbola.calculateEccentricity();
        assertEquals(Math.sqrt(1 + Math.pow(3.0 / 5.0, 2)), eccentricity, 0.001, "Eccentricity is incorrect.");
    }

    @Test
    void testCalculateTangentLine() {
        double[] tangentLine = hyperbola.calculateTangentLine(6, 1);
        assertNotNull(tangentLine, "Tangent line should not be null.");
    }
}