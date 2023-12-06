package com.example.lmbk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class tr_calcTest1 {
    tr_calc trt= new tr_calc("a=3; c=4; b=5");
    @Test
    void get_tr_r() {
        Assertions.assertEquals(1.0, trt.get_tr_r(), 0.000001);
    }

    @Test
    void get_tr_A() {
        Assertions.assertArrayEquals(new double []{0.0,0.0},trt.get_tr_A(), 0.000001);
    }

    @Test
    void get_tr_B() {
        Assertions.assertArrayEquals(new double []{3.0,0.0},trt.get_tr_B(), 0.000001);
    }

    @Test
    void get_tr_C() {
        Assertions.assertArrayEquals(new double []{0.0,4.0},trt.get_tr_C(), 0.000001);
    }

    @Test
    void get_tr_m() {
        Assertions.assertEquals(Math.PI/2,trt.get_tr_m(), 0.000001);
    }

    @Test
    void get_tr_n() {
        Assertions.assertEquals(Math.round(Math.asin(0.8)),Math.round(trt.get_tr_n()), 0.000001);
    }

    @Test
    void get_tr_k() {
        Assertions.assertEquals(Math.round(Math.asin(0.6)),Math.round(trt.get_tr_k()), 0.000001);
    }

    @Test
    void get_tr_L() {
        Assertions.assertArrayEquals(new double []{1.0,1.0},trt.get_tr_L(), 0.000001);
    }

    @Test
    void get_tr_Lb() {
        Assertions.assertArrayEquals(new double []{12.0/7.0, 12.0/7.0},trt.get_tr_Lb(), 0.000001);
    }

    @Test
    void get_tr_Lc() {
        Assertions.assertArrayEquals(new double []{0.0,1.0+Math.tan(Math.asin(0.8)/2)},trt.get_tr_Lc(), 0.000001);
    }

    @Test
    void get_tr_La() {
        Assertions.assertArrayEquals(new double []{1.0+Math.tan(Math.asin(0.6)/2), 0.0},trt.get_tr_La(), 0.000001);
    }

    @Test
    void get_tr_H() {
        Assertions.assertArrayEquals(new double []{0.0, 0.0},trt.get_tr_H(), 0.000001);
    }

    @Test
    void get_tr_Hb() {
        Assertions.assertArrayEquals(new double []{1.92,1.44},trt.get_tr_Hb(), 0.000001);
    }

    @Test
    void get_tr_Ha() {
        Assertions.assertArrayEquals(new double []{0.0,0.0},trt.get_tr_Ha(), 0.000001);
    }

    @Test
    void get_tr_Hc() {
        Assertions.assertArrayEquals(new double []{0.0,0.0},trt.get_tr_Hc(), 0.000001);
    }

    @Test
    void get_tr_ob() {
        Assertions.assertArrayEquals(new double []{1.8,1.6},trt.get_tr_ob(), 0.000001);
    }

    @Test
    void get_tr_oa() {
        Assertions.assertArrayEquals(new double []{1.0,0.0},trt.get_tr_oa(), 0.000001);
    }

    @Test
    void get_tr_oc() {
        Assertions.assertArrayEquals(new double []{0.0,1.0},trt.get_tr_oc(), 0.000001);
    }

    @Test
    void tr_writer() {
        Assertions.assertEquals("a=3.0; b=5.0; c=4.0; S=6.0; P=12.0; ", trt.tr_writer(("a, b, c, S, P"), 6));
    }
}