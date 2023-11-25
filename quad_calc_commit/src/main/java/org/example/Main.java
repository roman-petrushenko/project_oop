package org.example;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!")
        quad_calc quad1 = new quad_calc("a=6; b=4; c=4; d=6; m=1");
        System.out.println(quad1.quad_writer("S, P, d1, d2, d, A, B, C, D, O, o, m, n, k, l",6));
        //;
    }
}