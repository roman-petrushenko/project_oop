package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        tr_calc tr1 = new tr_calc("a=5; k=1.57; b=3");
        System.out.println(Arrays.toString(tr1.get_tr_O()));
        System.out.println(tr1.tr_writer("S, P, m, L, La, Lb, Lc","t_file.txt"));
        //File file2 = new File("t_file1.txt");
        /*try{
        FileWriter filewriter2 = new FileWriter("filet.txt", true);
        String str5 =tr1.tr_writer("S, P, m","t_file.txt");
        System.out.println(str5);
        filewriter2.write(str5);
        filewriter2.close();}
        catch(Exception exc2){
            System.out.println(exc2);
        }*/
        //System.out.println("Hello world!");
    }
}