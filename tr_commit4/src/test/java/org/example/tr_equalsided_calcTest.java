package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tr_equalsided_calcTest {
    tr_equalsided_calc trt3 = new tr_equalsided_calc(new double[]{-2,-2},new double[]{2,-2},new double[]{0,0});


    @Test
    void get_tr_R() {
        Assertions.assertEquals(4/Math.pow(3.0,0.5),trt3.get_tr_R(),0.000001);


    }

    @Test
    void get_tr_r() {
        Assertions.assertEquals(2/Math.pow(3.0,0.5),trt3.get_tr_r(),0.000001);
    }

    @Test
    void get_tr_M() {
        Assertions.assertArrayEquals(new double[]{0.0,-4.0/3},trt3.get_tr_M(),0.000001);
    }

    @Test
    void get_tr_L() {
        Assertions.assertArrayEquals(new double[]{0.0,-4.0/3},trt3.get_tr_L(),0.000001);
    }

    @Test
    void get_tr_H() {
        Assertions.assertArrayEquals(new double[]{0.0,-4.0/3},trt3.get_tr_H(),0.000001);
    }

    @Test
    void get_tr_O() {
        Assertions.assertArrayEquals(new double[]{0.0,-4.0/3},trt3.get_tr_O(),0.000001);
    }

    @Test
    void get_tr_Ma() {
        Assertions.assertArrayEquals(new double[]{0.0,-2},trt3.get_tr_Ma(),0.000001);

    }

    @Test
    void get_tr_La() {
        Assertions.assertArrayEquals(new double[]{0.0,-2},trt3.get_tr_La(),0.000001);
    }

    @Test
    void get_tr_Ha() {
        Assertions.assertArrayEquals(new double[]{0.0,-2},trt3.get_tr_Ha(),0.000001);
    }

    @Test
    void get_tr_oa() {
        Assertions.assertArrayEquals(new double[]{0.0,-2},trt3.get_tr_oa(),0.000001);
    }

    @Test
    void get_tr_Mb() {
        Assertions.assertArrayEquals(new double[]{1,-1},trt3.get_tr_Mb(),0.000001);
    }

    @Test
    void get_tr_Lb() {
        Assertions.assertArrayEquals(new double[]{1,-1},trt3.get_tr_Lb(),0.000001);
    }

    @Test
    void get_tr_Hb() {
        Assertions.assertArrayEquals(new double[]{1,-1},trt3.get_tr_Hb(),0.000001);
    }

    @Test
    void get_tr_ob() {
        Assertions.assertArrayEquals(new double[]{1,-1},trt3.get_tr_ob(),0.000001);
    }

    @Test
    void get_tr_Mc() {
        Assertions.assertArrayEquals(new double[]{-1,-1},trt3.get_tr_Mc(),0.000001);
    }

    @Test
    void get_tr_Lc() {
        Assertions.assertArrayEquals(new double[]{-1,-1},trt3.get_tr_Lc(),0.000001);
    }

    @Test
    void get_tr_Hc() {
        Assertions.assertArrayEquals(new double[]{-1,-1},trt3.get_tr_Hc(),0.000001);
    }

    @Test
    void get_tr_oc() {
        Assertions.assertArrayEquals(new double[]{-1,-1},trt3.get_tr_oc(),0.000001);
    }
}