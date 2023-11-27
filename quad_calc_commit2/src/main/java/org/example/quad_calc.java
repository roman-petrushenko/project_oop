package org.example;

import java.util.Arrays;

import static java.lang.Double.NaN;
import static java.lang.Math.*;


public class quad_calc implements quad_calc_interface {
    protected double a;
    protected double b;
    protected double c;
    protected double d;
    protected double m;
    protected double n;
    protected double k;
    protected double l;
    protected double[] A;
    protected double[] B;
    protected double[] C;
    protected double[] D;
    protected double S;
    protected double P;

    quad_calc(String s1){
        String[] s2 = s1.split("; ");
        for (String i: s2){
            if (i.charAt(0)=='a'){
                a = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='b'){
                b = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='c'){
                c = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='d'){
                d = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='m'){
                m = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='n'){
                n = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='k'){
                k = Double.parseDouble(i.substring(2));

            }
            else if (i.charAt(0)=='l'){
                l = Double.parseDouble(i.substring(2));
            }
            else {
                System.out.println("Exception for:"+i.charAt(0));
            }
        }
        if ((a!=0)&(b!=0)&(d!=0)&(m!=0)&(n!=0)){
            A = new double[]{0,0};
            B = new double[]{a,0};
            D = new double[]{d*cos(m),d*sin(m)};
            C = new double[]{a -b* cos(n), b*sin(n)};
            c = pow((C[0]-D[0])*(C[0]-D[0])+((C[1]-D[1])*(C[1]-D[1])),0.5);
            double cos_l = ((A[0]-D[0])*(C[0]-D[0])+(A[1]-D[1])*(C[1]-D[1]))/(c*d);
            l = acos(cos_l);

            k = 2*Math.PI-m-n-l;
        }
        else if ((a!=0)&(d!=0)&(m!=0)&(n!=0)&(l!=0)){
            k = 2*PI - m - n - l;
            c = (d*sin(m+n)-a*sin(n))/sin(l+m+n);
            b = (a*sin(l+m)-d*sin(l))/sin(l+m+n);

            A = new double[]{0,0};
            B = new double[]{a,0};
            D = new double[]{d*cos(m),d*sin(m)};
            C = new double[]{a -b* cos(n), b*sin(n)};
        }
        else if((a!=0)&(b!=0)&(c!=0)&(d!=0)&(m!=0)){
            double cos_k = (b*b+c*c -a*a -d*d+2*a*d*cos(m))/(2*b*c);
            k = acos(cos_k);

            double sin_n1 = d*sin(m)/pow(a*a+d*d-2*a*d*cos(m),0.5);
            double sin_n2 = c*sin(k)/pow(a*a+d*d-2*a*d*cos(k),0.5);
            n = asin(sin_n1)+asin(sin_n2);
            l = 2*PI - m -n -k;
            A = new double[]{0,0};
            B = new double[]{a,0};
            D = new double[]{d*cos(m),d*sin(m)};
            C = new double[]{a -b* cos(n), b*sin(n)};
        }
        else{
            System.out.println("Exception: not enough values (of the blueprint) to fully determine quadrilateral");
        }
        S = 0.5*a*d*Math.sin(m)+0.5*b*c*Math.sin(k);
        P = a + b + c + d;





    }
    quad_calc(double[] A1, double[] B1, double[] C1,double[] D1){
        A = new double[]{A1[0],A1[1]};
        B = new double[]{B1[0],B1[1]};
        C = new double[]{C1[0],C1[1]};
        D = new double[]{D1[0],D1[1]};
        a = pow((A1[0]-B1[0])*(A1[0]-B1[0])+(A1[1]-B1[1])*(A1[1]-B1[1]),0.5);
        b = pow((B1[0]-C1[0])*(B1[0]-C1[0])+(B1[1]-C1[1])*(B1[1]-C1[1]),0.5);
        c = pow((C1[0]-D1[0])*(C1[0]-D1[0])+(C1[1]-D1[1])*(C1[1]-D1[1]),0.5);
        d = pow((D1[0]-A1[0])*(D1[0]-A1[0])+(D1[1]-A1[1])*(D1[1]-A1[1]),0.5);
        double cos_m = ((D[0]-A[0])*(B[0]-A[0])+(D[1]-A[1])*(B[1]-A[1]))/(a*d);
        m = acos(cos_m);

        double cos_n = ((A[0]-B[0])*(C[0]-B[0])+(A[1]-B[1])*(C[1]-B[1]))/(b*c);
        n = acos(cos_n);
        double cos_l = ((A[0]-D[0])*(C[0]-D[0])+(A[1]-D[1])*(C[1]-D[1]))/(c*d);
        l = acos(cos_l);
        k = 2*PI - m -n -l;
        S = 0.5*a*d*Math.sin(m)+0.5*b*c*Math.sin(k);
        P = a + b + c + d;

    }
    public double quad_get_a(){
        return a;
    }
    public double quad_get_b(){
        return b;
    }
    public double quad_get_c(){
        return c;
    }
    public double quad_get_d(){
        return d;
    }
    public double quad_get_m(){return m;}
    public double quad_get_n(){
        return n;
    }
    public double quad_get_k(){
        return k;
    }
    public double quad_get_l(){
        return l;
    }
    public double[] quad_get_A(){
        return A;
    }
    public double[] quad_get_B(){
        return B;
    }
    public double[] quad_get_C(){
        return C;
    }
    public double[] quad_get_D(){
        return D;
    }
    public double quad_get_d1(){
        return pow((A[0]-C[0])*(A[0]-C[0])+(A[1]-C[1])*(A[1]-C[1]),0.5);
    }
    public double quad_get_d2(){
        return pow((B[0]-D[0])*(B[0]-D[0])+(B[1]-D[1])*(B[1]-D[1]),0.5);
    }
    public double quad_get_t(){
        double cos_t = ((A[0]-C[0])*(B[0]-D[0])+(A[1]-C[1])*(B[1]-D[1]))/(quad_get_d1()*quad_get_d2());
        return Math.min(acos(cos_t), Math.PI- acos(cos_t));
    }
    public double quad_get_S(){
        //return 0.5*quad_get_d1()*quad_get_d2()*sin(quad_get_t());
        return S;
    }
    public double quad_get_P(){
        return P;
    }
    public double quad_get_R(int k1){
        if((round((m+k)*pow(10,k1))/pow(10,k1)==round(PI*pow(10,k1))/pow(10,k1))){
        return (quad_get_d2()/(2*Math.sin(m)));}
        else{
            return NaN;
        }
    }
    public double quad_get_r(int k1){
        if((round((a+c)*pow(10,k1))/pow(10,k1)==round((b+d)*pow(10,k1))/pow(10,k1))){
        return (2*quad_get_S()/quad_get_P());}
        else{
            return NaN;
        }

    }
    public double[] quad_get_o(int k1){
        if((round((a+c)*pow(10,k1))/pow(10,k1)==round((b+d)*pow(10,k1))/pow(10,k1))) {
            double x1 = A[0];
            double y1 = A[1];
            double x2 = B[0];
            double y2 = B[1];
            double x3 = C[0];
            double y3 = C[1];
            double x4 = D[0];
            double y4 = D[1];
            double t1 = Math.atan((y2-y1)/(x2-x1));
            double x_o = 0;
            double y_o = 0;
            double g = Math.atan((y3-y2)/(x3-x2));
            double f = Math.atan((y4-y1)/(x4-x1));
            double x_l1 = (y1 -y2 +x2*Math.tan((t1+g)/2) -x1*Math.tan((t1+f)/2))/(Math.tan((t1+g)/2) - Math.tan((t1+f)/2));
            double y_l1 = (x1 -x2 +y2/Math.tan((t1+g)/2) -y1/Math.tan((t1+f)/2))/(1/Math.tan((t1+g)/2) - 1/Math.tan((t1+f)/2));
            double x_l2 = (y1 -y2 +x2*Math.tan((t1+g)/2+Math.PI/2) -x1*Math.tan((t1+f)/2))/(Math.tan((t1+g)/2+Math.PI/2) - Math.tan((t1+f)/2));
            double y_l2 = (x1 -x2 +y2/Math.tan((t1+g)/2+Math.PI/2) -y1/Math.tan((t1+f)/2))/(1/Math.tan((t1+g)/2+Math.PI/2) - 1/Math.tan((t1+f)/2));
            double x_l3 = (y1 -y2 +x2*Math.tan((t1+g)/2+Math.PI/2) -x1*Math.tan((t1+f)/2+Math.PI/2))/(Math.tan((t1+g)/2+Math.PI/2) - Math.tan((t1+f)/2+Math.PI/2));
            double y_l3 = (x1 -x2 +y2/Math.tan((t1+g)/2+Math.PI/2) -y1/Math.tan((t1+f)/2+Math.PI/2))/(1/Math.tan((t1+g)/2+Math.PI/2) - 1/Math.tan((t1+f)/2+Math.PI/2));
            double x_l4 = (y1 -y2 +x2*Math.tan((t1+g)/2) -x1*Math.tan((t1+f)/2+Math.PI/2))/(Math.tan((t1+g)/2) - Math.tan((t1+f)/2+Math.PI/2));
            double y_l4 = (x1 -x2 +y2/Math.tan((t1+g)/2) -y1/Math.tan((t1+f)/2+Math.PI/2))/(1/Math.tan((t1+g)/2) - 1/Math.tan((t1+f)/2+Math.PI/2));
            double r1 = Math.abs(-(y2-y1)*x_l1+(x2-x1)*y_l1+x1*(y2-y1)-y1*(x2-x1))/a;
            double r2 = Math.abs(-(y2-y1)*x_l2+(x2-x1)*y_l2+x1*(y2-y1)-y1*(x2-x1))/a;
            double r3 = Math.abs(-(y2-y1)*x_l3+(x2-x1)*y_l3+x1*(y2-y1)-y1*(x2-x1))/a;
            double r4 = Math.abs(-(y2-y1)*x_l4+(x2-x1)*y_l4+x1*(y2-y1)-y1*(x2-x1))/a;
            System.out.println(r1);
            System.out.println(r2);
            System.out.println(r3);
            System.out.println(r4);
            System.out.println(x_l4);
            System.out.println(y_l4);
            System.out.println(x_l1);
            System.out.println(y_l1);
            System.out.println(x_l2);
            System.out.println(y_l2);
            System.out.println(x_l3);
            System.out.println(y_l3);
            System.out.println(2*S/P);
            if (Math.round(r1*Math.pow(10,10)/Math.pow(10,10))==Math.round(2*S/P*Math.pow(10,10)/Math.pow(10,10))) {
                x_o = x_l1;
                y_o = y_l1;
            }
            else if (Math.round(r2*Math.pow(10,10)/Math.pow(10,10))==Math.round(2*S/P*Math.pow(10,10)/Math.pow(10,10))) {
                x_o = x_l2;
                y_o = y_l2;
            }
            else if (Math.round(r3*Math.pow(10,10)/Math.pow(10,10))==Math.round(2*S/P*Math.pow(10,10)/Math.pow(10,10))) {
                x_o = x_l3;
                y_o = y_l3;
            }
            else if (Math.round(r4*Math.pow(10,10)/Math.pow(10,10))==Math.round(2*S/P*Math.pow(10,10)/Math.pow(10,10))) {
                x_o = x_l4;
                y_o = y_l4;
            }
           /* double x_o;
            double y_o;
            double t1 = Math.atan((y2 - y1) / (x2 - x1));
            double g = Math.atan((y3 - y2) / (x3 - x2));

            double f = Math.atan((y4 - y1) / (x4 - x1));
            if (Math.tan((t1+g)/2)<0){
                x_o = (y1 - y2 + x2 * Math.tan((t1 + g) / 2) - x1 * Math.tan((t1 + f) / 2)) / (Math.tan((t1 + g) / 2) - Math.tan((t1 + f) / 2));
                y_o = (x1 - x2 + y2 / Math.tan((t1 + g) / 2) - y1 / Math.tan((t1 + f) / 2)) / (1 / Math.tan((t1 + g) / 2) - 1 / Math.tan((t1 + f) / 2));
            }
            else {
                x_o = (y1 - y2 + x2 * Math.tan((t1 + g) / 2 + Math.PI / 2) - x1 * Math.tan((t1 + f) / 2)) / (Math.tan((t1 + g) / 2 + Math.PI / 2) - Math.tan((t1 + f) / 2));
                y_o = (x1 - x2 + y2 / Math.tan((t1 + g) / 2 + Math.PI / 2) - y1 / Math.tan((t1 + f) / 2)) / (1 / Math.tan((t1 + g) / 2 + Math.PI / 2) - 1 / Math.tan((t1 + f) / 2));
            }*/

            return new double[]{x_o, y_o};
        }
        else{
            return new double[]{NaN,NaN};
        }



    }
    public double[] quad_get_O(int k1){
        if((round((m+k)*pow(10,k1))/pow(10,k1)==round(PI*pow(10,k1))/pow(10,k1))){


        double x1 = A[0];
        double y1 = A[1];
        double x2 = B[0];
        double y2 = B[1];
        double x3 = C[0];
        double y3 = C[1];
        double x_O= ((y1-y2)/2*(y3-y1)*(y3-y2)+(x1+x3)/2*(x3-x1)*(y3-y2)-(x3+x2)/2*(x3-x2)*(y3-y1))/((x3-x1)*(y3-y2)-(x3-x2)*(y3-y1));
        double y_O= ((x1-x2)/2*(x3-x1)*(x3-x2)+(y1+y3)/2*(y3-y1)*(x3-x2)-(y3+y2)/2*(y3-y2)*(x3-x1))/((y3-y1)*(x3-x2)-(y3-y2)*(x3-x1));

        return new double[]{x_O, y_O};}
        else{
            return new double[]{NaN,NaN};
        }


    }
    public double[] quad_get_G(){
        double x1 = A[0];
        double y1 = A[1];
        double x2 = B[0];
        double y2 = B[1];
        double x3 = C[0];
        double y3 = C[1];
        double x4 = D[0];
        double y4 = D[1];

        double G_x = ((y1-y2)*(x3-x1)*(x4-x2)+x2*(y4-y2)*(x3-x1)-x1*(y3-y1)*(x4-x2))/((y4-y2)*(x3-x1)-(y3-y1)*(x4-x2));
        double G_y = ((x1-x2)*(y3-y1)*(y4-y2)+y2*(x4-x2)*(y3-y1)-y1*(x3-x1)*(y4-y2))/((x4-x2)*(y3-y1)-(x3-x1)*(y4-y2));
        return new double[]{G_x, G_y};

    }
    public double[] round_val1(double[] K, int k2){
        if ((Double.isNaN(K[0]))){
            return K;
        }
        return new double[]{round(K[0]*pow(10,k2))/pow(10,k2), round(K[1]*pow(10,k2))/pow(10,k2)};
    }


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


        }
        return s4;
    }
}
