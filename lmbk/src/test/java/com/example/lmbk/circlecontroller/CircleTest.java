package com.example.lmbk.circlecontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CircleTest {
    private Circle circle;

    @BeforeEach
    void setUp() {
        circle = new Circle(5.0, 0.0, 0.0);
    }

    @Test
    void testConstructor() {
        assertEquals(5.0, circle.getRadius(), "Radius should be 5.0");
        assertEquals(0.0, circle.getXCenter(), "X center should be 0.0");
        assertEquals(0.0, circle.getYCenter(), "Y center should be 0.0");
    }

    @Test
    void testArea() {
        double expectedArea = Math.PI * 25.0;
        assertEquals(expectedArea, circle.area(), "Area calculation is incorrect.");
    }

    @Test
    void testCircumference() {
        double expectedCircumference = 2 * Math.PI * 5.0;
        assertEquals(expectedCircumference, circle.circumference(), "Circumference calculation is incorrect.");
    }

    @Test
    void testIsInside() {
        assertTrue(circle.isInside(3, 4), "Point (3,4) should be inside the circle.");
        assertFalse(circle.isInside(6, 6), "Point (6,6) should be outside the circle.");
    }

    @Test
    void testAddChord() {
        circle.addChord(3, 4, -3, -4);
        Circle.Chord addedChord = circle.getChord(0);
        assertNotNull(addedChord, "Chord should be added to the circle.");
    }

    @Test
    void testUpdateChord() {
        circle.addChord(3, 4, -3, -4);
        circle.updateChord(0, 5, 0, -5, 0);
        Circle.Chord updatedChord = circle.getChord(0);
        assertEquals(5, updatedChord.getX1(), "Chord's first x-coordinate should be updated to 5.");
        assertEquals(0, updatedChord.getY1(), "Chord's first y-coordinate should be updated to 0.");
    }

    @Test
    void testGetChord() {
        circle.addChord(3, 4, -3, -4);
        Circle.Chord chord = circle.getChord(0);
        assertNotNull(chord, "Should be able to retrieve the added chord.");
    }
}
