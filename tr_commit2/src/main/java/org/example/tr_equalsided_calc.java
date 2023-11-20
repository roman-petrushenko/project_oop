package org.example;

public class tr_equalsided_calc extends tr_calc{
    protected double[] Center;
    protected double[] Ma;
    protected double[] Mb;
    protected double[] Mc;

    tr_equalsided_calc(double[] A1, double[] B1, double[] C1) {
        super(A1, B1, C1);
        Center = super.get_tr_M();
        Ma = super.get_tr_Ma();
        Mb = super.get_tr_Mb();
        Mc = super.get_tr_Mc();
    }
    double get_tr_R(){
        return (a*Math.pow(3,0.5)/3);
    }
    double get_tr_r(){
        return (a*Math.pow(3,0.5)/6);
    }
    double[] get_tr_M(){
        return Center;
    }
    double[] get_tr_L(){
        return Center;
    }
    double[] get_tr_H(){
        return Center;
    }
    double[] get_tr_O(){
        return Center;
    }
    double[] get_tr_Ma(){
        return Ma;
    }
    double[] get_tr_La(){
        return Ma;
    }
    double[] get_tr_Ha(){
        return Ma;
    }
    double[] get_tr_oa(){
        return Ma;
    }
    double[] get_tr_Mb(){
        return Mb;
    }
    double[] get_tr_Lb(){
        return Mb;
    }
    double[] get_tr_Hb(){
        return Mb;
    }
    double[] get_tr_ob(){
        return Mb;
    }
    double[] get_tr_Mc(){
        return Mc;
    }
    double[] get_tr_Lc(){
        return Mc;
    }
    double[] get_tr_Hc(){
        return Mc;
    }
    double[] get_tr_oc(){
        return Mc;
    }


}
