package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class tr_calc implements tr_interface {
    protected double a;
    protected double b;
    protected double c;
    protected double m;
    protected double n;
    protected double k;
    protected double[] A;
    protected double[] B;
    protected double[] C;

    protected double P;
    protected double S;

    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;

    tr_calc(double[] A1, double[] B1, double[] C1) {
        //A = new double[2];
        x1 = A1[0];
        y1 = A1[1];
        x2 = B1[0];
        y2 = B1[1];
        x3 = C1[0];
        y3 = C1[1];
        A = new double[]{x1, y1};
        B = new double[]{x2, y2};
        C = new double[]{x3, y3};
        a = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
        b = Math.pow(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2), 0.5);
        c = Math.pow(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2), 0.5);

        /*a = a1;
        b = b1;
        c = c1;*/
        m = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
        n = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        k = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        /*A = new double[]{0.0, 0.0};
        B = new double[]{a1, 0.0};
        C = new double[]{c1*Math.cos(m), c1*Math.sin(m)};*/
        P = a + b + c;
        double p = P / 2;
        S = Math.pow(p * (p - a) * (p - b) * (p - c), 0.5);
    }

    tr_calc(double a1, double b1, double c1) {
        //A = new double[2];
        a = a1;
        b = b1;
        c = c1;
        m = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
        n = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        k = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        A = new double[]{0.0, 0.0};
        B = new double[]{a1, 0.0};
        C = new double[]{c1 * Math.cos(m), c1 * Math.sin(m)};
        P = a + b + c;
        double p = P / 2;
        S = Math.pow(p * (p - a) * (p - b) * (p - c), 0.5);
    }

    tr_calc(String str) {
        try{
        String[] str2 = str.split("; ");
        for (String i : str2) {
            if (i.charAt(0) == 'a') {
                a = Double.parseDouble(i.substring(2));
            } else if (i.charAt(0) == 'b') {
                b = Double.parseDouble(i.substring(2));
            } else if (i.charAt(0) == 'c') {
                c = Double.parseDouble(i.substring(2));
            } else if (i.charAt(0) == 'm') {
                m = Double.parseDouble(i.substring(2));
            } else if (i.charAt(0) == 'n') {
                n = Double.parseDouble(i.substring(2));
            } else if (i.charAt(0) == 'k') {
                k = Double.parseDouble(i.substring(2));
            } else {
                System.out.println(i + "\nException for: " + i.charAt(0));
                break;
            }

        }
        if ((a != 0) & (b != 0) & (k != 0)) {
            m = Math.asin(b / a * Math.sin(k));
            n = Math.PI - m - k;
            c = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b) * Math.cos(n), 0.5);
        } else if ((a != 0) & (b != 0) & (m != 0)) {
            k = Math.asin(a / b * Math.sin(n));
            n = Math.PI - m - k;
            c = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b) * Math.cos(n), 0.5);
        } else if ((b != 0) & (c != 0) & (n != 0)) {
            m = Math.asin(b / c * Math.sin(n));
            k = Math.PI - m - n;
            a = Math.pow(Math.pow(b, 2) + Math.pow(c, 2) - (2 * b * c) * Math.cos(k), 0.5);
        } else if ((b != 0) & (c != 0) & (m != 0)) {
            n = Math.asin(c / b * Math.sin(m));
            k = Math.PI - m - n;
            a = Math.pow(Math.pow(b, 2) + Math.pow(c, 2) - (2 * b * c) * Math.cos(k), 0.5);
        } else if ((a != 0) & (c != 0) & (k != 0)) {
            n = Math.asin(c / a * Math.sin(k));
            m = Math.PI - n - k;
            b = Math.pow(Math.pow(a, 2) + Math.pow(c, 2) - (2 * a * c) * Math.cos(m), 0.5);
        } else if ((a != 0) & (c != 0) & (n != 0)) {
            k = Math.asin(a / c * Math.sin(n));
            m = Math.PI - n - k;
            b = Math.pow(Math.pow(a, 2) + Math.pow(c, 2) - (2 * a * c) * Math.cos(m), 0.5);
        } else if ((a != 0) & (b != 0) & (c != 0)) {
            m = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
            n = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
            k = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        } else if ((a != 0) & (c != 0) & (m != 0)) {
            b = Math.pow(Math.pow(a, 2) + Math.pow(c, 2) - (2 * a * c) * Math.cos(m), 0.5);
            n = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
            k = Math.PI - m - n;
        } else if ((a != 0) & (b != 0) & (n != 0)) {
            c = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b) * Math.cos(n), 0.5);
            k = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
            m = Math.PI - n - k;
        } else if ((b != 0) & (c != 0) & (k != 0)) {
            a = Math.pow(Math.pow(b, 2) + Math.pow(c, 2) - (2 * b * c) * Math.cos(k), 0.5);
            m = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
            n = Math.PI - m - k;

        }

        else if ((a != 0) & (m != 0) & (k != 0)) {
            n = Math.PI - m - k;
            b = a / Math.sin(k) * Math.sin(m);
            c = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b) * Math.cos(n), 0.5);

        } else if ((b != 0) & (m != 0) & (n != 0)) {
            k = Math.PI - m - n;
            c = b / Math.sin(m) * Math.sin(n);
            a = Math.pow(Math.pow(b, 2) + Math.pow(c, 2) - (2 * b * c) * Math.cos(k), 0.5);
        } else if ((c != 0) & (n != 0) & (k != 0)) {
            m = Math.PI - n - k;
            a = c / Math.sin(n) * Math.sin(k);
            b = Math.pow(Math.pow(a, 2) + Math.pow(c, 2) - (2 * a * c) * Math.cos(m), 0.5);
        }

        A = new double[]{0.0, 0.0};
        B = new double[]{a, 0.0};
        C = new double[]{c * Math.cos(m), c * Math.sin(m)};
        x1 = A[0];
        y1 = A[1];
        x2 = B[0];
        y2 = B[1];
        x3 = C[0];
        y3 = C[1];
        P = a + b + c;
        double p = P / 2;
        S = Math.pow(p * (p - a) * (p - b) * (p - c), 0.5);}
        catch (Exception exc){
            System.out.println("Exception for input data:"+exc);
        }
    }

    static boolean check_equalsided_tr(tr_calc tr_check, int k1){
        return (tr_check.a != 0) & (Math.round(tr_check.a * Math.pow(10, k1)) / Math.pow(10, k1) == Math.round(tr_check.b * Math.pow(10, k1)) / Math.pow(10, k1)) & (Math.round(tr_check.b * Math.pow(10, k1))/  Math.pow(10, k1) == Math.round(tr_check.c * Math.pow(10, k1)) / Math.pow(10, k1));
    }





    double get_tr_R(){
        double R = a*b*c/(4*S);
        return R;}
    double get_tr_r(){
        double r = S/(P/2);
        return r;
    }
    double[] get_tr_A(){
        return A;
    }
    double[] get_tr_B(){
        return B;
    }
    double[] get_tr_C(){
        return C;
    }
    public double get_tr_a(){
        return a;
    }
    public double get_tr_b(){
        return b;
    }
    public double get_tr_c(){
        return c;
    }
    public double get_tr_m(){
        return m;
    }
    public double get_tr_n(){
        return n;
    }
    public double get_tr_k(){
        return k;
    }
    public double get_tr_P(){
        return P;
    }
    public double get_tr_S(){
        return S;
    }
    public double[] get_tr_M(){
        double[] M = new double[]{(A[0]+B[0]+C[0])/3, (A[1]+B[1]+C[1])/3};
        return M;
    }
    public double[] get_tr_Mb(){

        double x_mb = (x2+x3)/2;
        double y_mb = (y2+y3)/2;
        double[] Mb = new double[]{x_mb,y_mb};
        return Mb;
    }
    public double[] get_tr_Ma(){

        double x_ma = (x1+x2)/2;
        double y_ma = (y1+y2)/2;
        double[] Ma = new double[]{x_ma,y_ma};
        return Ma;
    }
    public double[] get_tr_Mc(){

        double y3 = C[1];
        double x_mc = (x1+x3)/2;
        double y_mc = (y1+y3)/2;
        double[] Mc = new double[]{x_mc,y_mc};
        return Mc;
    }
    public double[] get_tr_L(){
        double t = Math.atan((y2-y1)/(x2-x1));
        double g = Math.atan((y3-y2)/(x3-x2));
        double f = Math.atan((y3-y1)/(x3-x1));
        double x_L = (y1 -y2 +x2*Math.tan((t+g)/2) -x1*Math.tan((t+f)/2))/(Math.tan((t+g)/2) - Math.tan((t+f)/2));
        double y_L = (x1 -x2 +y2/Math.tan((t+g)/2) -y1/Math.tan((t+f)/2))/(1/Math.tan((t+g)/2) - 1/Math.tan((t+f)/2));
        double[] L = new double[]{x_L, y_L};
        return L;
    }
    public double[] get_tr_Lb(){
        double x_l = this.get_tr_L()[0];
        double y_l = this.get_tr_L()[1];
        double x_Lb= ((y1-y2)*(x3-x2)*(x1-x_l)+x2*(y3-y2)*(x1-x_l)-x1*(y1-y_l)*(x3-x2))/((y3-y2)*(x1-x_l)-(y1-y_l)*(x3-x2));
        double y_Lb=((x1-x2)*(y3-y2)*(y1-y_l)+y2*(x3-x2)*(y1-y_l)-y1*(x1-x_l)*(y3-y2))/((x3-x2)*(y1-y_l)-(x1-x_l)*(y3-y2));
        double[] Lb = new double[]{x_Lb, y_Lb};
        return Lb;
    }
    public double[] get_tr_Lc(){
        double x_l = this.get_tr_L()[0];
        double y_l = this.get_tr_L()[1];
        double x_Lc= ((y2-y3)*(x1-x3)*(x2-x_l)+x3*(y1-y3)*(x2-x_l)-x2*(y2-y_l)*(x1-x3))/((y1-y3)*(x2-x_l)-(y2-y_l)*(x1-x3));
        double y_Lc=((x2-x3)*(y1-y3)*(y2-y_l)+y2*(x1-x3)*(y2-y_l)-y2*(x2-x_l)*(y1-y3))/((x1-x3)*(y2-y_l)-(x2-x_l)*(y1-y3));
        double[] Lс = new double[]{x_Lc, y_Lc};

        return Lс;
    }
    public double[] get_tr_La(){
        double x_l = this.get_tr_L()[0];
        double y_l = this.get_tr_L()[1];
        double x_La= ((y3-y1)*(x2-x1)*(x3-x_l)+x1*(y2-y1)*(x3-x_l)-x3*(y3-y_l)*(x2-x1))/((y2-y1)*(x3-x_l)-(y3-y_l)*(x2-x1));
        double y_La=((x3-x1)*(y2-y1)*(y3-y_l)+y1*(x2-x1)*(y3-y_l)-y3*(x3-x_l)*(y2-y1))/((x2-x1)*(y3-y_l)-(x3-x_l)*(y2-y1));

        double[] La = new double[]{x_La, y_La};
        return La;
    }
    public double[] get_tr_H(){
        double x_H= ((y2-y1)*(y3-y1)*(y3-x2) +x2*(x3-x1)*(y3-y2)-x1*(x3-x2)*(y3-x1))/((x3-x1)*(y3-y2)-(x3-x2)*(y3-y1));
        double y_H= ((x2 -x1)*(x3-x1)*(x3-x2) +y2*(y3-y1)*(x3-x2)-y1*(y3-y2)*(x3-x1))/((y3-y1)*(x3-x2)-(y3-y2)*(x3-x1));

        double[] H = new double[]{x_H, y_H};
        return H;
    }
    public double[] get_tr_Hb(){
        double x_Hb=((y1-y2)*(y3-y2)*(x3-x2)+x1*(x3-x2)*(x3-x2)+x2*(y3-y2)*(y3-y2))/((y3-y2)*(y3-y2)+(x3-x2)*(x3-x2));
        double y_Hb= ((x1-x2)*(x3-x2)*(y3-y2)+y1*(y3-y2)*(y3-y2)+y2*(x3-x2)*(x3-x2))/((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));

        double[] Hb = new double[]{x_Hb, y_Hb};
        return Hb;
    }
    public double[] get_tr_Ha(){
        double x_Ha=((y3-y1)*(y1-y2)*(x1-x2)+x3*(x1-x2)*(x1-x2)+x1*(y1-y2)*(y1-y2))/((y1-y2)*(y1-y2)+(x1-x2)*(x1-x2));
        double y_Ha= ((x3-x1)*(x1-x2)*(y1-y2)+y3*(y1-y2)*(y1-y2)+y1*(x1-x2)*(x1-x2))/((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));

        double[] Ha = new double[]{x_Ha, y_Ha};
        return Ha;
    }
    public double[] get_tr_Hc(){
        double x_Hc=((y2-y3)*(y3-y1)*(x1-x3)+x2*(x3-x1)*(x1-x3)+x3*(y1-y3)*(y1-y3))/((y1-y3)*(y1-y3)+(x3-x1)*(x3-x1));
        double y_Hc= ((x2-x3)*(x3-x1)*(y1-y3)+y2*(y2-y1)*(y1-y3)+y3*(x2-x3)*(x1-x3))/((x1-x3)*(x1-x3)+(y3-y1)*(y3-y1));

        double[] Hc = new double[]{x_Hc, y_Hc};
        return Hc;
    }
    public double[] get_tr_ob(){
        double x_l = this.get_tr_L()[0];
        double y_l = this.get_tr_L()[1];
        double x_ob= ((y_l-y2)*(y3-y2)*(x3-x2)+(x3-x2)*(x3-x2)*x_l+(y3-y2)*(y3-y2)*x2)/((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        double y_ob= ((x_l-x2)*(x3-x2)*(y3-y2)+(y3-y2)*(y3-y2)*y_l+(x3-x2)*(x3-x2)*y2)/((y3-y2)*(y3-y2)+(x3-x2)*(x3-x2));

        double[] ob = new double[]{x_ob, y_ob};
        return ob;
    }
    public double[] get_tr_oa(){
        double x_l = this.get_tr_L()[0];
        double y_l = this.get_tr_L()[1];

        double x_oa = ((y_l-y1)*(y2-y1)*(x2-x1)+(x2-x1)*(x2-x1)*x_l+(y2-y1)*(y2-1)*x1)/((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        double y_oa= ((x_l-x1)*(x2-x1)*(y2-y1)+(y2-y1)*(y2-y1)*y_l+(x2-x1)*(x2-x1)*y1)/((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));

        double[] oa = new double[]{x_oa, y_oa};
        return oa;
    }
    public double[] get_tr_oc(){
        double x_l = this.get_tr_L()[0];
        double y_l = this.get_tr_L()[1];

        double x_oc= ((y_l-y3)*(y1-y3)*(x1-x3)+(x1-x3)*(x1-x3)*x_l+(y1-y3)*(y1-y3)*x3)/((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
        double y_oc= ((x_l-x3)*(x1-x3)*(y1-y3)+(y1-y3)*(y1-y3)*y_l+(x1-x3)*(x1-x3)*y3)/((y1-y3)*(y1-y3)+(x1-x3)*(x1-x3));

        double[] oc = new double[]{x_oc, y_oc};
        return oc;
    }
    public double[] get_tr_O(){
        double x_O= ((y1-y2)/2*(y3-y1)*(y3-y2)+(x1+x3)/2*(x3-x1)*(y3-y2)-(x3+x2)/2*(x3-x2)*(y3-y1))/((x3-x1)*(y3-y2)-(x3-x2)*(y3-y1));
        double y_O= ((x1-x2)/2*(x3-x1)*(x3-x2)+(y1+y3)/2*(y3-y1)*(x3-x2)-(y3+y2)/2*(y3-y2)*(x3-x1))/((y3-y1)*(x3-x2)-(y3-y2)*(x3-x1));

        double[] O = new double[]{x_O, y_O};
        return O;
    }
    public static double[] round_val(double[] D, int k1){
        return new double[]{(Math.round(D[0]*Math.pow(10,k1))/Math.pow(10, k1)),(Math.round(D[1]*Math.pow(10,k1))/Math.pow(10, k1))};
    }
    public String tr_writer(String str2, String path1,int k1){
        String str4 = "";
        try {

            FileWriter filewriter1 = new FileWriter(path1, true);
            String[] str3 = str2.split(", ");

            for (String k: str3){
                if (k.equals("a")){
                    str4+="a="+Double.toString(Math.round((this.get_tr_a())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("b")){
                    str4+="b="+Double.toString(Math.round((this.get_tr_b())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("c")){
                    str4+="c="+Double.toString(Math.round((this.get_tr_c())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("m")){
                    str4+="m="+Double.toString(Math.round((this.get_tr_m())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("n")){
                    str4+="n="+Double.toString(Math.round((this.get_tr_n())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("k")){
                    str4+="k="+Double.toString(Math.round((this.get_tr_k())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("R")){
                    str4+="R="+Double.toString(Math.round((this.get_tr_R())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("r")){
                    str4+="r="+Double.toString(Math.round((this.get_tr_r())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("S")){
                    str4+="S="+Double.toString(Math.round((this.get_tr_S())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("P")){
                    str4+="P="+Double.toString(Math.round((this.get_tr_P())*Math.pow(10, k1))/Math.pow(10,k1))+"; ";

                }
                if (k.equals("A")){

                    str4+="A="+Arrays.toString(round_val(this.get_tr_A(),k1))+"; ";

                }
                if (k.equals("B")){
                    str4+="B="+Arrays.toString(round_val(this.get_tr_B(),k1))+"; ";

                }
                if (k.equals("C")){
                    str4+="C="+Arrays.toString(round_val(this.get_tr_C(),k1))+"; ";

                }
                if (k.equals("M")){
                    str4+="M="+Arrays.toString(round_val(this.get_tr_M(),k1))+"; ";

                }
                if (k.equals("Ma")){
                    str4+="Ma="+Arrays.toString(round_val(this.get_tr_Ma(),k1))+"; ";

                }
                if (k.equals("Mb")){
                    str4+="Mb="+Arrays.toString(round_val(this.get_tr_Mb(),k1))+"; ";

                }
                if (k.equals("Mc")){
                    str4+="Mc="+Arrays.toString(round_val(this.get_tr_Mc(),k1))+"; ";

                }
                if (k.equals("L")){
                    str4+="L="+Arrays.toString(round_val(this.get_tr_L(),k1))+"; ";

                }
                if (k.equals("La")){
                    str4+="La="+Arrays.toString(round_val(this.get_tr_La(),k1))+"; ";

                }
                if (k.equals("Lb")){
                    str4+="Lb="+Arrays.toString(round_val(this.get_tr_Lb(),k1))+"; ";

                }
                if (k.equals("Lc")){
                    str4+="Lc="+Arrays.toString(round_val(this.get_tr_Lc(),k1))+"; ";

                }
                if (k.equals("oa")){
                    str4+="oa="+Arrays.toString(round_val(this.get_tr_oa(),k1))+"; ";

                }
                if (k.equals("ob")){
                    str4+="ob="+Arrays.toString(round_val(this.get_tr_ob(),k1))+"; ";

                }
                if (k.equals("oc")){
                    str4+="oc="+Arrays.toString(round_val(this.get_tr_oc(),k1))+"; ";

                }
                if (k.equals("H")){
                    str4+="H="+Arrays.toString(round_val(this.get_tr_H(),k1))+"; ";
                }
                if (k.equals("Ha")){
                    str4+="Ha="+Arrays.toString(round_val(this.get_tr_Ha(),k1))+"; ";

                }
                if (k.equals("Hb")){
                    str4+="Hb="+Arrays.toString(round_val(this.get_tr_Hb(),k1))+"; ";

                }
                if (k.equals("Hc")){
                    str4+="Hc="+Arrays.toString(round_val(this.get_tr_Hc(),k1))+"; ";

                }
                if (k.equals("O")){
                    str4+="O="+Arrays.toString(round_val(this.get_tr_O(),k1))+"; ";

                }
            }
            //filewriter1.close();
            ////filewriter1.write(str4+"\n");
            filewriter1.close();
            return str4;
        }
        catch (IOException exc){
            System.out.println("Writer exception:"+exc);
            return str4;
        }
    }



}