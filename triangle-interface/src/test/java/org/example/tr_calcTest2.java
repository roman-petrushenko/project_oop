package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tr_calcTest2 {
    tr_calc trt2 = new tr_calc(new double[]{-1,-1}, new double[]{2,2}, new double[]{5,3});
    @Test
    void get_tr_R() {
        Assertions.assertEquals(Math.pow(65,0.5),trt2.get_tr_R(),0.000001);
    }

    @Test
    void get_tr_a() {
        Assertions.assertEquals(Math.pow(18,0.5),trt2.get_tr_a(),0.000001);
    }

    @Test
    void get_tr_b() {
        Assertions.assertEquals(Math.pow(10,0.5),trt2.get_tr_b(),0.000001);
    }

    @Test
    void get_tr_c() {
        Assertions.assertEquals(Math.pow(52,0.5),trt2.get_tr_c(),0.000001);
    }

    @Test
    void get_tr_M() {
        Assertions.assertArrayEquals(new double[]{2.0,4.0/3.0},trt2.get_tr_M(),0.000001);
    }

    @Test
    void get_tr_Mb() {
        Assertions.assertArrayEquals(new double[]{3.5,2.5},trt2.get_tr_Mb(),0.000001);
    }

    @Test
    void get_tr_Ma() {
        Assertions.assertArrayEquals(new double[]{0.5,0.5},trt2.get_tr_Ma(),0.000001);
    }

    @Test
    void get_tr_Mc() {
        Assertions.assertArrayEquals(new double[]{2.0,1.0},trt2.get_tr_Mc(),0.000001);
    }

    @Test
    void get_tr_O() {
        Assertions.assertArrayEquals(new double[]{6.0, -5.0},trt2.get_tr_O(),0.000001);
    }
    @Test
    void check_equalsided_tr(){
        tr_calc trt21 = new tr_calc("a=5; m=1.047; c=5");
        Assertions.assertEquals(true, tr_calc.check_equalsided_tr(trt21, 2));
    }
    @Test
    void check_equalsided_tr1(){
        tr_calc trt22 = new tr_calc("a=5; b=6; c=5");
        Assertions.assertEquals(false, tr_calc.check_equalsided_tr(trt22, 3));
    }
}