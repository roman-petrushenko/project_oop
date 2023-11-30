package org.example;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class quad_parallel_calc extends quad_calc{


    quad_parallel_calc(double[] A1, double[] B1, double[] C1, double[] D1) {
        super(A1, B1, C1, D1);
    }
    quad_parallel_calc(String s5){
        super(s5);
    }
    public double quad_parallel_get_h1(){
        return S/a;
    }
    public double quad_parallel_get_h2(){
        return S/b;
    }
    @Override
    public String quad_writer(String s2, int k1) {
        String[] s3_arr = s2.split(", ");
        String s4 = "";
        for (String j : s3_arr) {
            if (j.charAt(0) == 'a') {
                s4 += "a=" + Double.toString(round(a*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'b') {
                s4 += "b=" + Double.toString(round(b*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'c') {
                s4 += "c=" + Double.toString(round(c*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'm') {
                s4 += "m=" + Double.toString(round(m*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'n') {
                s4 += "n=" + Double.toString(round(n*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'k') {
                s4 += "k=" + Double.toString(round(k*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'l') {
                s4 += "l=" + Double.toString(round(l*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.equals("d1")) {
                s4 += "d1=" + Double.toString(round(quad_get_d1()*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.equals("d2")) {
                s4 += "d2=" + Double.toString(round(quad_get_d2()*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.equals("d")) {
                s4 += "d=" + Double.toString(round(d*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 't') {
                s4 += "t=" + Double.toString(round(quad_get_t()*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'S') {
                s4 += "S=" + Double.toString(round(quad_get_S()*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'P') {
                s4 += "P=" + Double.toString(round(quad_get_P()*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.charAt(0) == 'A') {
                s4 += "A=" + Arrays.toString(round_val1(A, k1)) + "; ";
            }
            if (j.charAt(0) == 'B') {
                s4 += "B=" + Arrays.toString(round_val1(B, k1)) + "; ";
            }
            if (j.charAt(0) == 'C') {
                s4 += "C=" + Arrays.toString(round_val1(C, k1)) + "; ";
            }
            if (j.charAt(0) == 'D') {
                s4 += "D=" + Arrays.toString(round_val1(D, k1)) + "; ";
            }
            if (j.charAt(0) == 'G') {
                s4 += "G=" + Arrays.toString(round_val1(quad_get_G(), k1)) + "; ";
            }
            if (j.charAt(0) == 'O') {
                s4 += "O=" + Arrays.toString(round_val1(quad_get_O(k1), k1)) + "; ";
            }
            if (j.charAt(0) == 'o') {
                s4 += "o=" + Arrays.toString(round_val1(quad_get_o(k1), k1)) + "; ";
            }
            if (j.equals("h1")) {
                s4 += "h1=" + Double.toString(round(quad_parallel_get_h1()*pow(10,k1))/pow(10,k1)) + "; ";
            }
            if (j.equals("h2")) {
                s4 += "h2=" + Double.toString(round(quad_parallel_get_h2()*pow(10,k1))/pow(10,k1)) + "; ";
            }



        }
        return s4;
    }

}
