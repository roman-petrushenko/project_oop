package com.example.geometricobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EllipseTest {

    private Ellipse ellipse;

    @BeforeEach
    void setUp() {
        ellipse = new Ellipse(10.0, 5.0, 0.0, 0.0);
    }

    @Test
    void testConstructor() {
        assertEquals(10.0, ellipse.getRadius(), "Major radius should be 10.0");
        assertEquals(5.0, ellipse.getMinorRadius(), "Minor radius should be 5.0");
        assertEquals(0.0, ellipse.getXCenter(), "X center should be 0.0");
        assertEquals(0.0, ellipse.getYCenter(), "Y center should be 0.0");
    }

    @Test
    void testArea() {
        // Area = π * a * b
        double expectedArea = Math.PI * 10.0 * 5.0;
        assertEquals(expectedArea, ellipse.area(), "Area calculation is incorrect.");
    }

    @Test
    void testEccentricity() {
        // Eccentricity = sqrt(1 - (b^2 / a^2))
        double expectedEccentricity = Math.sqrt(1 - Math.pow(5.0 / 10.0, 2));
        assertEquals(expectedEccentricity, ellipse.eccentricity(), "Eccentricity calculation is incorrect.");
    }

    @Test
    void testFoci() {
        double[][] foci = ellipse.getFoci();
        assertNotNull(foci, "Foci should not be null.");
        assertEquals(2, foci.length, "There should be two foci.");
    }

    @Test
    void testDirectrices() {
        double[] directrices = ellipse.getDirectrices();
        assertNotNull(directrices, "Directrices should not be null.");
        assertEquals(2, directrices.length, "There should be two directrices.");
    }
}