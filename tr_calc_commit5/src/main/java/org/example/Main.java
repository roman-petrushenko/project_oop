package org.example;
;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        tr_calc tr1 = new tr_calc("a=5; k=1.57; b=3");
        System.out.println(Arrays.toString(tr1.get_tr_O()));
        System.out.println(tr1.tr_writer("S, P, m, L, La, Lb, Lc","t_file.txt",6));

    }
}