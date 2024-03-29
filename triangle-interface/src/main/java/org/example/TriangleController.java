package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

import java.util.Arrays;

public class TriangleController {

    @FXML
    private Text A_txt;

    @FXML
    private Group AltitudesGr;

    @FXML
    private Text B_txt;

    @FXML
    private Group BisectorsGr;

    @FXML
    private Text C_txt;

    @FXML
    private CheckBox CalcAP_chb;

    @FXML
    private Group CirclesPointsGr;

    @FXML
    private CheckBox H_chb;

    @FXML
    private Circle H_point;

    @FXML
    private Text H_txt;

    @FXML
    private Circle Ha_point;

    @FXML
    private Text Ha_txt;

    @FXML
    private Circle Hb_point;

    @FXML
    private Text Hb_txt;

    @FXML
    private Circle Hc_point;

    @FXML
    private Text Hc_txt;

    @FXML
    private Circle InscribedCircle;

    @FXML
    private CheckBox L_chb;

    @FXML
    private Circle L_point;

    @FXML
    private Text L_txt;

    @FXML
    private Circle La_point;

    @FXML
    private Text La_txt;

    @FXML
    private Circle Lb_point;

    @FXML
    private Text Lb_txt;

    @FXML
    private Circle Lc_point;

    @FXML
    private Text Lc_txt;

    @FXML
    private CheckBox M_chb;

    @FXML
    private Circle M_point;

    @FXML
    private Text M_txt;

    @FXML
    private Circle Ma_point;

    @FXML
    private Text Ma_txt;

    @FXML
    private Circle Mb_point;

    @FXML
    private Text Mb_txt;

    @FXML
    private Circle Mc_point;

    @FXML
    private Text Mc_txt;

    @FXML
    private Group MediansGr;

    @FXML
    private TextField NODPString;

    @FXML
    private CheckBox O_chb;

    @FXML
    private Circle O_point;

    @FXML
    private Text O_txt;

    @FXML
    private TextField PTCString;

    @FXML
    private CheckBox ShowH_chb;

    @FXML
    private CheckBox ShowL_chb;

    @FXML
    private CheckBox ShowM_chb;

    @FXML
    private CheckBox ShowOo_chb;

    @FXML
    private Circle SircumscribedCircle;

    @FXML
    private Button SwitchTrButton;

    @FXML
    private Pane TrCoordsPane;

    @FXML
    private TextField TrInputStr;

    @FXML
    private Pane TrSAPane;

    @FXML
    private ScrollPane TrScrollPane;

    @FXML
    private AnchorPane TrianglePane;

    @FXML
    private Text a_txt;

    @FXML
    private Text b_txt;

    @FXML
    private Text c_txt;

    @FXML
    private Text k_txt;

    @FXML
    private Text m_txt;

    @FXML
    private Text n_txt;

    @FXML
    private CheckBox o_chb;

    @FXML
    private Circle oa_point;

    @FXML
    private Text oa_txt;

    @FXML
    private Circle ob_point;

    @FXML
    private Text ob_txt;

    @FXML
    private Circle oc_point;

    @FXML
    private Text oc_txt;

    @FXML
    private TextArea res1_txt;

    @FXML
    private Polygon triangle1;

    @FXML
    private TextField xA;

    @FXML
    private Line xAxis;

    @FXML
    private TextField xB;

    @FXML
    private TextField xC;

    @FXML
    private TextField yA;

    @FXML
    private Line yAxis;

    @FXML
    private TextField yB;

    @FXML
    private TextField yC;

    @FXML
    private Circle o_point;

    @FXML
    private Text o_txt;


    @FXML
    private void initialize() {
        yAxis.startXProperty().bind(TrianglePane.prefWidthProperty().divide(2));
        yAxis.startYProperty().bind(TrianglePane.layoutYProperty());

        yAxis.endXProperty().bind(TrianglePane.prefWidthProperty().divide(2));
        yAxis.endYProperty().bind(TrianglePane.layoutYProperty().add(TrianglePane.prefHeightProperty()));


        xAxis.startXProperty().bind(TrianglePane.layoutXProperty());
        xAxis.startYProperty().bind(TrianglePane.prefHeightProperty().divide(2));

        xAxis.endXProperty().bind(TrianglePane.layoutXProperty().add(TrianglePane.prefWidthProperty()));
        xAxis.endYProperty().bind(TrianglePane.prefHeightProperty().divide(2));
    }

    @FXML
    void Calc(ActionEvent event) {
        String res1;
        int nodp;
        res1_txt.setStyle("-fx-text-fill: black");
        TrianglePane.setPrefSize(850,510);
        double[] A;
        double[] B;
        double[] C;
        tr_calc tr;
        String trInput;

        try {
            if (TrCoordsPane.isVisible()) {
                A = new double[]{Double.parseDouble(xA.getText()), Double.parseDouble(yA.getText())};
                B = new double[]{Double.parseDouble(xB.getText()), Double.parseDouble(yB.getText())};
                C = new double[]{Double.parseDouble(xC.getText()), Double.parseDouble(yC.getText())};
                tr = new tr_calc(A, B, C);
            } else {
                trInput = TrInputStr.getText();
                tr = new tr_calc(trInput);
                A = tr.get_tr_A();
                B = tr.get_tr_B();
                C = tr.get_tr_C();
            }
            if (tr_calc.check_equalsided_tr(tr,6)){
                tr = new tr_equalsided_calc(tr.get_tr_A(),tr.get_tr_B(),tr.get_tr_C());
            }

            res1 = PTCString.getText();
            if (NODPString.getText().isEmpty()){
                nodp = 0;
            }else {
                nodp = Integer.parseInt(NODPString.getText());
            }

            if (M_chb.isSelected()) {
                res1 += ", M, Ma, Mb, Mc";
            }

            if (L_chb.isSelected()) {
                res1 += ", L, La, Lb, Lc";
            }

            if (H_chb.isSelected()) {
                res1 += ", H, Ha, Hb, Hc";
            }

            if (O_chb.isSelected()) {
                res1 += ", O";
            }

            if (o_chb.isSelected()) {
                res1 += ", o, oa, ob, oc";
            }

            double[] maxXArray = {Math.abs(A[0]), Math.abs(B[0]), Math.abs(C[0]), Math.abs(tr.get_tr_H()[0]), Math.abs(tr.get_tr_O()[0])};
            double[] maxYArray = {Math.abs(A[1]), Math.abs(B[1]), Math.abs(C[1]), Math.abs(tr.get_tr_H()[1]), Math.abs(tr.get_tr_O()[1])};

            double maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
            double maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

            double i=1;

            if (!Double.isNaN(maxXAbs) & !Double.isNaN(maxYAbs) & !Double.isInfinite(maxXAbs) & !Double.isInfinite(maxYAbs)){
                if (maxXAbs<100) {
                    i = maxXAbs / 400;
                }
                if (maxYAbs<100){
                    i = maxYAbs/220;
                }
                maxXArray = new double[] {Math.abs(A[0]/i), Math.abs(B[0]/i), Math.abs(C[0]/i), Math.abs(tr.get_tr_H()[0]/i), Math.abs(tr.get_tr_O()[0]/i)};
                maxYArray = new double[] {Math.abs(A[1]/i), Math.abs(B[1]/i), Math.abs(C[1]/i), Math.abs(tr.get_tr_H()[1]/i), Math.abs(tr.get_tr_O()[1]/i)};

                maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
                maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

                if (maxXAbs >= TrianglePane.getPrefWidth() / 2) {
                    TrianglePane.setPrefWidth(maxXAbs * 2 + 40);
                }
                if (maxYAbs >= TrianglePane.getPrefHeight() / 2) {
                    TrianglePane.setPrefHeight(maxYAbs * 2 + 40);
                }
            }

            //triangle points
            triangle1.getPoints().setAll(
                    A[0]/i + TrianglePane.getPrefWidth() / 2, TrianglePane.getPrefHeight() / 2 - A[1]/i,
                    B[0]/i + TrianglePane.getPrefWidth() / 2, TrianglePane.getPrefHeight() / 2 - B[1]/i,
                    C[0]/i + TrianglePane.getPrefWidth() / 2, TrianglePane.getPrefHeight() / 2 - C[1]/i
            );
            A_txt.setLayoutX(A[0]/i + TrianglePane.getPrefWidth() / 2);
            A_txt.setLayoutY(TrianglePane.getPrefHeight() / 2 - A[1]/i);

            B_txt.setLayoutX(B[0]/i + TrianglePane.getPrefWidth() / 2);
            B_txt.setLayoutY(TrianglePane.getPrefHeight() / 2 - B[1]/i);

            C_txt.setLayoutX(C[0]/i + TrianglePane.getPrefWidth() / 2);
            C_txt.setLayoutY(TrianglePane.getPrefHeight() / 2 - C[1]/i);

            //M points
            M_point.setCenterX(tr.get_tr_M()[0]/i + TrianglePane.getPrefWidth() / 2);
            M_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_M()[1]/i);
            M_txt.setLayoutX(M_point.getCenterX());
            M_txt.setLayoutY(M_point.getCenterY());

            Ma_point.setCenterX(tr.get_tr_Ma()[0]/i + TrianglePane.getPrefWidth() / 2);
            Ma_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Ma()[1]/i);
            Ma_txt.setLayoutX(Ma_point.getCenterX());
            Ma_txt.setLayoutY(Ma_point.getCenterY());

            Mb_point.setCenterX(tr.get_tr_Mb()[0]/i + TrianglePane.getPrefWidth() / 2);
            Mb_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Mb()[1]/i);
            Mb_txt.setLayoutX(Mb_point.getCenterX());
            Mb_txt.setLayoutY(Mb_point.getCenterY());

            Mc_point.setCenterX(tr.get_tr_Mc()[0]/i + TrianglePane.getPrefWidth() / 2);
            Mc_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Mc()[1]/i);
            Mc_txt.setLayoutX(Mc_point.getCenterX());
            Mc_txt.setLayoutY(Mc_point.getCenterY());

            //L points
            L_point.setCenterX(tr.get_tr_L()[0]/i + TrianglePane.getPrefWidth() / 2);
            L_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_L()[1]/i);
            L_txt.setLayoutX(L_point.getCenterX());
            L_txt.setLayoutY(L_point.getCenterY());

            La_point.setCenterX(tr.get_tr_La()[0]/i + TrianglePane.getPrefWidth() / 2);
            La_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_La()[1]/i);
            La_txt.setLayoutX(La_point.getCenterX());
            La_txt.setLayoutY(La_point.getCenterY());

            Lb_point.setCenterX(tr.get_tr_Lb()[0]/i + TrianglePane.getPrefWidth() / 2);
            Lb_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Lb()[1]/i);
            Lb_txt.setLayoutX(Lb_point.getCenterX());
            Lb_txt.setLayoutY(Lb_point.getCenterY());

            Lc_point.setCenterX(tr.get_tr_Lc()[0]/i + TrianglePane.getPrefWidth() / 2);
            Lc_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Lc()[1]/i);
            Lc_txt.setLayoutX(Lc_point.getCenterX());
            Lc_txt.setLayoutY(Lc_point.getCenterY());

            //H points
            H_point.setCenterX(tr.get_tr_H()[0]/i + TrianglePane.getPrefWidth() / 2);
            H_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_H()[1]/i);
            H_txt.setLayoutX(H_point.getCenterX());
            H_txt.setLayoutY(H_point.getCenterY());

            Ha_point.setCenterX(tr.get_tr_Ha()[0]/i + TrianglePane.getPrefWidth() / 2);
            Ha_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Ha()[1]/i);
            Ha_txt.setLayoutX(Ha_point.getCenterX());
            Ha_txt.setLayoutY(Ha_point.getCenterY());

            Hb_point.setCenterX(tr.get_tr_Hb()[0]/i + TrianglePane.getPrefWidth() / 2);
            Hb_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Hb()[1]/i);
            Hb_txt.setLayoutX(Hb_point.getCenterX());
            Hb_txt.setLayoutY(Hb_point.getCenterY());

            Hc_point.setCenterX(tr.get_tr_Hc()[0]/i + TrianglePane.getPrefWidth() / 2);
            Hc_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_Hc()[1]/i);
            Hc_txt.setLayoutX(Hc_point.getCenterX());
            Hc_txt.setLayoutY(Hc_point.getCenterY());

            //Oo points
            O_point.setCenterX(tr.get_tr_O()[0]/i + TrianglePane.getPrefWidth() / 2);
            O_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_O()[1]/i);
            O_txt.setLayoutX(O_point.getCenterX());
            O_txt.setLayoutY(O_point.getCenterY());

            o_point.setCenterX(tr.get_tr_L()[0]/i + TrianglePane.getPrefWidth() / 2);
            o_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_L()[1]/i);
            o_txt.setLayoutX(o_point.getCenterX());
            o_txt.setLayoutY(o_point.getCenterY());

            oa_point.setCenterX(tr.get_tr_oa()[0]/i + TrianglePane.getPrefWidth() / 2);
            oa_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_oa()[1]/i);
            oa_txt.setLayoutX(oa_point.getCenterX());
            oa_txt.setLayoutY(oa_point.getCenterY());

            ob_point.setCenterX(tr.get_tr_ob()[0]/i + TrianglePane.getPrefWidth() / 2);
            ob_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_ob()[1]/i);
            ob_txt.setLayoutX(ob_point.getCenterX());
            ob_txt.setLayoutY(ob_point.getCenterY());

            oc_point.setCenterX(tr.get_tr_oc()[0]/i + TrianglePane.getPrefWidth() / 2);
            oc_point.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_oc()[1]/i);
            oc_txt.setLayoutX(oc_point.getCenterX());
            oc_txt.setLayoutY(oc_point.getCenterY());

            //circles
            InscribedCircle.setCenterX(tr.get_tr_L()[0]/i + TrianglePane.getPrefWidth() / 2);
            InscribedCircle.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_L()[1]/i);
            InscribedCircle.setRadius(tr.get_tr_r()/i);

            SircumscribedCircle.setCenterX(tr.get_tr_O()[0]/i + TrianglePane.getPrefWidth() / 2);
            SircumscribedCircle.setCenterY(TrianglePane.getPrefHeight() / 2 - tr.get_tr_O()[1]/i);
            SircumscribedCircle.setRadius(tr.get_tr_R()/i);

            //triangle sides/angles labels
            a_txt.setLayoutX(Ma_point.getCenterX());
            a_txt.setLayoutY(Ma_point.getCenterY());
            b_txt.setLayoutX(Mb_point.getCenterX());
            b_txt.setLayoutY(Mb_point.getCenterY());
            c_txt.setLayoutX(Mc_point.getCenterX());
            c_txt.setLayoutY(Mc_point.getCenterY());

            m_txt.setLayoutX(A_txt.getLayoutX()+0.1*(M_point.getCenterX()-A_txt.getLayoutX()));
            m_txt.setLayoutY(A_txt.getLayoutY()+0.1*(M_point.getCenterY()-A_txt.getLayoutY()));
            n_txt.setLayoutX(B_txt.getLayoutX()+0.1*(M_point.getCenterX()-B_txt.getLayoutX()));
            n_txt.setLayoutY(B_txt.getLayoutY()+0.1*(M_point.getCenterY()-B_txt.getLayoutY()));
            k_txt.setLayoutX(C_txt.getLayoutX()+0.1*(M_point.getCenterX()-C_txt.getLayoutX()));
            k_txt.setLayoutY(C_txt.getLayoutY()+0.1*(M_point.getCenterY()-C_txt.getLayoutY()));

            res1 = tr.tr_writer(res1,nodp);

        }catch (Exception e){
            res1 = "Exception: "+e.getMessage();
            res1_txt.setStyle("-fx-text-fill: red");
        }
        res1_txt.setText(res1);
        TrScrollPane.setHvalue(0.48);
        TrScrollPane.setVvalue(0.4);
    }

    @FXML
    void CalcAP(ActionEvent event) {
        M_chb.setSelected(CalcAP_chb.isSelected());
        L_chb.setSelected(CalcAP_chb.isSelected());
        H_chb.setSelected(CalcAP_chb.isSelected());
        O_chb.setSelected(CalcAP_chb.isSelected());
        o_chb.setSelected(CalcAP_chb.isSelected());
    }

    @FXML
    void ShowH(ActionEvent event) { AltitudesGr.setVisible(ShowH_chb.isSelected()); }

    @FXML
    void ShowL(ActionEvent event) { BisectorsGr.setVisible(ShowL_chb.isSelected()); }

    @FXML
    void ShowM(ActionEvent event) { MediansGr.setVisible(ShowM_chb.isSelected()); }

    @FXML
    void ShowOo(ActionEvent event) {
        CirclesPointsGr.setVisible(ShowOo_chb.isSelected());
    }

    @FXML
    void SwitchTr(ActionEvent event) {
        TrSAPane.setDisable(!TrSAPane.isDisabled());
        TrSAPane.setVisible(!TrSAPane.isVisible());
        TrCoordsPane.setDisable(!TrCoordsPane.isDisabled());
        TrCoordsPane.setVisible(!TrCoordsPane.isVisible());

        if (TrSAPane.isVisible()) {
            SwitchTrButton.setText("Switch to coordinates");
        }else{
            SwitchTrButton.setText("Switch to sides/angles");
        }
    }

}