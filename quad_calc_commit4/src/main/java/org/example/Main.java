package org.example;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!")
       // quad_calc quad1 = new quad_calc("a=600; b=400; c=400; d=600; m=1");
        //System.out.println(quad1.quad_writer("S, P, d1, d2, d, A, B, C, D, O, o, m, n, k, l",6));
        quad_calc quad2 = new quad_calc(new double[]{150, 0},new double[]{300, 100},new double[]{150, 200},new double[]{0, 100});
        System.out.println(quad2.quad_writer("S, P, d1, d2, d, A, B, C, D, O, o, m, n, k, l",6));
        //;
    }
}