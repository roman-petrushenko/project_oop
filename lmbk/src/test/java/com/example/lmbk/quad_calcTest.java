package com.example.lmbk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class quad_calcTest {
    quad_calc quad_t = new quad_calc("a=5; n=1.57080; l=1.57080; m=1.04720; d=5");

    @Test
    void quad_get_A() {
        Assertions.assertArrayEquals(new double[]{0,0},quad_t.quad_get_A(), 0.0001);
    }

    @Test
    void quad_get_B() {
        Assertions.assertArrayEquals(new double[]{5,0},quad_t.quad_get_B(), 0.0001);
    }

    @Test
    void quad_get_C() {
        Assertions.assertArrayEquals(new double[]{5, 5/Math.pow(3.0,0.5)},quad_t.quad_get_C(), 0.0001);
    }

    @Test
    void quad_get_D() {
        Assertions.assertArrayEquals(new double[]{2.5, 5*Math.pow(3,0.5)/2},quad_t.quad_get_D(), 0.0001);
    }

    @Test
    void quad_get_d1() {
        Assertions.assertEquals(10/Math.pow(3,0.5),quad_t.quad_get_d1(), 0.0001);
    }

    @Test
    void quad_get_d2() {
        Assertions.assertEquals(5,quad_t.quad_get_d2(), 0.0001);
    }


    @Test
    void quad_get_t() {
        Assertions.assertEquals(Math.PI/2,quad_t.quad_get_t(), 0.0001);
    }


    @Test
    void quad_get_S() {
        Assertions.assertEquals(25/Math.pow(3,0.5),quad_t.quad_get_S(), 0.0001);
    }


    @Test
    void quad_get_P() {
        Assertions.assertEquals(10*(1+1/Math.pow(3,0.5)),quad_t.quad_get_P(), 0.0001);
    }

    @Test
    void quad_get_o() {

        Assertions.assertArrayEquals(new double[]{5*Math.pow(6,0.5)/4/Math.sin(7*Math.PI/12), 5*Math.pow(2,0.5)/4/Math.sin(7*Math.PI/12)},quad_t.quad_get_o(5), 0.0001);

    }

    @Test
    void quad_get_O() {
        Assertions.assertArrayEquals(new double[]{2.5, 2.5/Math.pow(3,0.5)},quad_t.quad_get_O(5), 0.0001);
    }

    @Test
    void quad_get_G() {
        Assertions.assertArrayEquals(new double[]{3.75, 5*Math.pow(3,0.5)/4},quad_t.quad_get_G(), 0.0001);
    }

    @Test
    void quad_writer() {
        Assertions.assertEquals("b=2.8868; c=2.8868; G=[3.75, 2.1651]; O=[2.5, 1.4434]; k=2.0944; ", quad_t.quad_writer("b, c, G, O, k",4));
    }
}