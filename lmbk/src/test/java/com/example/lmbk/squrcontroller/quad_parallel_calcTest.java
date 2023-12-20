package com.example.lmbk.squrcontroller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;
public class quad_parallel_calcTest {
    quad_parallel_calc quad_par_t = new quad_parallel_calc(new double[]{1.0, 1.0},new double[]{6.0, 1.0},new double[]{6.0, 3.0},new double[]{1.0, 3.0});

    @Test
    void quad_get_a() {
        Assertions.assertEquals(5,quad_par_t.quad_get_a(),0.000001);
    }

    @Test
    void quad_get_b() {
        Assertions.assertEquals(2,quad_par_t.quad_get_b(),0.000001);
    }

    @Test
    void quad_get_c() {
        Assertions.assertEquals(5,quad_par_t.quad_get_c(),0.000001);
    }

    @Test
    void quad_get_d() {
        Assertions.assertEquals(2,quad_par_t.quad_get_d(),0.000001);
    }
    @Test
    void quad_get_m() {
        Assertions.assertEquals(Math.PI/2,quad_par_t.quad_get_m(),0.000001);
    }
    @Test
    void quad_get_n() {
        Assertions.assertEquals(Math.PI/2,quad_par_t.quad_get_n(),0.000001);
    }
    @Test
    void quad_get_k() {
        Assertions.assertEquals(Math.PI/2,quad_par_t.quad_get_k(),0.000001);
    }
    @Test
    void quad_get_l() {
        Assertions.assertEquals(Math.PI/2,quad_par_t.quad_get_l(),0.000001);
    }

    @Test
    void quad_get_t() {
        Assertions.assertEquals(2*Math.atan(0.4),quad_par_t.quad_get_t(),0.000001);
    }

    @Test
    void quad_get_S() {
        Assertions.assertEquals(10,quad_par_t.quad_get_S(),0.000001);
    }

    @Test
    void quad_get_P() {
        Assertions.assertEquals(14,quad_par_t.quad_get_P(),0.000001);
    }

    //@Test
    //void quad_get_R() {
        //Assertions.assertEquals(Math.pow(29,0.5)/2,quad_par_t.quad_get_R(6),0.000001);
    //}

    //@Test
    //void quad_get_r() {
        //Assertions.assertEquals(NaN,quad_par_t.quad_get_r(6),0.000001);
    //}


    //@Test
    //void quad_get_o() {
        //Assertions.assertArrayEquals(new double[]{NaN,NaN},quad_par_t.quad_get_o(6),0.000001);
    //}

    @Test
    void quad_get_O() {
        Assertions.assertArrayEquals(new double[]{3.5,2},quad_par_t.quad_get_O(6),0.000001);
    }

    @Test
    void quad_parallel_get_h1() {
        Assertions.assertEquals(2,quad_par_t.quad_parallel_get_h1(),0.000001);
    }

    @Test
    void quad_parallel_get_h2() {
        Assertions.assertEquals(5,quad_par_t.quad_parallel_get_h2(),0.000001);
    }
}
