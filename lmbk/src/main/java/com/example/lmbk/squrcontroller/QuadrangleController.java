package com.example.lmbk.squrcontroller;

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
import javafx.stage.Stage;

import java.util.Arrays;

public class QuadrangleController {

    private Stage stage;

    @FXML
    private Text A_txt;

    @FXML
    private Text B_txt;

    @FXML
    private Text C_txt;

    @FXML
    private CheckBox CalcAP_chb;

    @FXML
    private Text D_txt;

    @FXML
    private Group DiagonalsGr;

    @FXML
    private Circle G_point;

    @FXML
    private Text G_txt;

    @FXML
    private Circle InscribedCircle;

    @FXML
    private TextField NODPString;

    @FXML
    private Group OGr;

    @FXML
    private CheckBox O_chb;

    @FXML
    private Circle O_point;

    @FXML
    private Text O_txt;

    @FXML
    private TextField PTCString;

    @FXML
    private Pane QuadCoordsPane;

    @FXML
    private Group QuadGr;

    @FXML
    private TextField QuadInputStr;

    @FXML
    private Pane QuadSAPane;

    @FXML
    private ScrollPane QuadScrollPane;

    @FXML
    private Polygon Quadrangle;

    @FXML
    private AnchorPane QuadranglePane;

    @FXML
    private CheckBox ShowO_chb;

    @FXML
    private CheckBox Showd_chb;

    @FXML
    private CheckBox Showo_chb;

    @FXML
    private Circle SircumscribedCircle;

    @FXML
    private Button SwitchQuadButton;

    @FXML
    private Text a_txt;

    @FXML
    private Text b_txt;

    @FXML
    private Text c_txt;

    @FXML
    private Line d1;

    @FXML
    private Text d1_txt;

    @FXML
    private Line d2;

    @FXML
    private Text d2_txt;

    @FXML
    private CheckBox d_chb;

    @FXML
    private Text d_txt;

    @FXML
    private CheckBox h_chb;

    @FXML
    private CheckBox isPar_chb;

    @FXML
    private Text k_txt;

    @FXML
    private Text l_txt;

    @FXML
    private Text m_txt;

    @FXML
    private Text n_txt;

    @FXML
    private Group oGr;

    @FXML
    private CheckBox o_chb;

    @FXML
    private Circle o_point;

    @FXML
    private Text o_txt;

    @FXML
    private TextArea res1_txt;

    @FXML
    private TextField xA;

    @FXML
    private Line xAxis;

    @FXML
    private TextField xB;

    @FXML
    private TextField xC;

    @FXML
    private TextField xD;

    @FXML
    private TextField yA;

    @FXML
    private Line yAxis;

    @FXML
    private TextField yB;

    @FXML
    private TextField yC;

    @FXML
    private TextField yD;



    @FXML
    private void initialize() {
        yAxis.startXProperty().bind(QuadranglePane.prefWidthProperty().divide(2));
        yAxis.startYProperty().bind(QuadranglePane.layoutYProperty());

        yAxis.endXProperty().bind(QuadranglePane.prefWidthProperty().divide(2));
        yAxis.endYProperty().bind(QuadranglePane.layoutYProperty().add(QuadranglePane.prefHeightProperty()));


        xAxis.startXProperty().bind(QuadranglePane.layoutXProperty());
        xAxis.startYProperty().bind(QuadranglePane.prefHeightProperty().divide(2));

        xAxis.endXProperty().bind(QuadranglePane.layoutXProperty().add(QuadranglePane.prefWidthProperty()));
        xAxis.endYProperty().bind(QuadranglePane.prefHeightProperty().divide(2));
    }

    @FXML
    void Calc(ActionEvent event) {
        res1_txt.setStyle("-fx-text-fill: black");
        QuadranglePane.setPrefSize(850, 510);

        QuadGr.setLayoutX(425);
        DiagonalsGr.setLayoutX(425);
        OGr.setLayoutX(425);
        oGr.setLayoutX(425);

        QuadGr.setLayoutY(255);
        DiagonalsGr.setLayoutY(255);
        OGr.setLayoutY(255);
        oGr.setLayoutY(255);

        String res1;
        int nodp;
        double[] A;
        double[] B;
        double[] C;
        double[] D;
        quad_calc quad;
        String quadInput;

        try {
            if (QuadCoordsPane.isVisible()) {
                A = new double[]{Double.parseDouble(xA.getText()), Double.parseDouble(yA.getText())};
                B = new double[]{Double.parseDouble(xB.getText()), Double.parseDouble(yB.getText())};
                C = new double[]{Double.parseDouble(xC.getText()), Double.parseDouble(yC.getText())};
                D = new double[]{Double.parseDouble(xD.getText()), Double.parseDouble(yD.getText())};
                quad = new quad_calc(A, B, C, D);
            } else {
                quadInput = QuadInputStr.getText();
                quad = new quad_calc(quadInput);
                A = quad.quad_get_A();
                B = quad.quad_get_B();
                C = quad.quad_get_C();
                D = quad.quad_get_D();
            }
            if (isPar_chb.isSelected()) {
                quad = new quad_parallel_calc(A, B, C, D);
            }

            res1 = PTCString.getText();

            if (NODPString.getText().isEmpty()) {
                nodp = 0;
            } else {
                nodp = Integer.parseInt(NODPString.getText());
            }

            if (d_chb.isSelected()) {
                if (res1.isEmpty()){
                    res1 += "d1, d2, G, t";
                }else {
                    res1 += ", d1, d2, G, t";
                }
            }

            if (h_chb.isSelected()&!h_chb.isDisabled()) {
                if (res1.isEmpty()) {
                    res1 += "h1, h2";
                } else {
                    res1 += ", h1, h2";
                }
            }

            if (O_chb.isSelected()) {
                if (res1.isEmpty()){
                    res1 += "O";
                }else {
                    res1 += ", O";
                }
            }

            if (o_chb.isSelected()) {
                if (res1.isEmpty()) {
                    res1 += "o";
                } else {
                    res1 += ", o";
                }
            }

            double[] maxXArray = {Math.abs(A[0]), Math.abs(B[0]), Math.abs(C[0]), Math.abs(D[0])};
            if (!Double.isNaN(quad.quad_get_R())&!Double.isNaN(quad.quad_get_O(nodp)[0])){
                maxXArray = new double[] {Math.abs(A[0]), Math.abs(B[0]), Math.abs(C[0]), Math.abs(D[0]),
                        quad.quad_get_R() * 2, Math.abs(quad.quad_get_O(nodp)[0])};
            }
            double[] maxYArray = {Math.abs(A[1]), Math.abs(B[1]), Math.abs(C[1]), Math.abs(D[1])};
            if (!Double.isNaN(quad.quad_get_R())&!Double.isNaN(quad.quad_get_O(nodp)[1])){
                maxYArray = new double[] {Math.abs(A[1]), Math.abs(B[1]), Math.abs(C[1]), Math.abs(D[1]),
                        quad.quad_get_R() * 2, Math.abs(quad.quad_get_O(nodp)[1])};
            }

            double maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
            double maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

            double i = 1;

            if (!Double.isNaN(maxXAbs) & !Double.isNaN(maxYAbs) & !Double.isInfinite(maxXAbs) & !Double.isInfinite(maxYAbs)) {
                if (maxXAbs < 100) {
                    i = maxXAbs / 400;
                }
                if (maxYAbs < 100) {
                    i = maxYAbs / 220;
                }

                maxXArray = new double[]{Math.abs(A[0] / i), Math.abs(B[0] / i), Math.abs(C[0] / i), Math.abs(D[0]) / i};
                if (!Double.isNaN(quad.quad_get_R())&!Double.isNaN(quad.quad_get_O(nodp)[0])){
                    maxXArray = new double[] {Math.abs(A[0] / i), Math.abs(B[0] / i), Math.abs(C[0] / i), Math.abs(D[0] / i),
                            quad.quad_get_R() * 2 / i, Math.abs(quad.quad_get_O(nodp)[0] / i)};
                }
                maxYArray = new double[]{Math.abs(A[1] / i), Math.abs(B[1] / i), Math.abs(C[1] / i), Math.abs(D[1] / i)};
                if (!Double.isNaN(quad.quad_get_R())&!Double.isNaN(quad.quad_get_O(nodp)[1])){
                    maxYArray = new double[] {Math.abs(A[1] / i), Math.abs(B[1] / i), Math.abs(C[1] / i), Math.abs(D[1] / i),
                            quad.quad_get_R() * 2 / i, Math.abs(quad.quad_get_O(nodp)[1] / i)};
                }

                maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
                maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

                if (maxXAbs >= QuadranglePane.getPrefWidth() / 2) {
                    QuadranglePane.setPrefWidth(maxXAbs * 2 + 40);

                    QuadGr.setLayoutX(QuadranglePane.getPrefWidth() / 2);
                    DiagonalsGr.setLayoutX(QuadranglePane.getPrefWidth() / 2);
                    OGr.setLayoutX(QuadranglePane.getPrefWidth() / 2);
                    oGr.setLayoutX(QuadranglePane.getPrefWidth() / 2);

                    QuadranglePane.setMaxWidth(maxXAbs * 2 + 40);
                }
                if (maxYAbs >= QuadranglePane.getPrefHeight() / 2) {
                    QuadranglePane.setPrefHeight(maxYAbs * 2 + 40);

                    QuadGr.setLayoutY(QuadranglePane.getPrefHeight() / 2);
                    DiagonalsGr.setLayoutY(QuadranglePane.getPrefHeight() / 2);
                    OGr.setLayoutY(QuadranglePane.getPrefHeight() / 2);
                    oGr.setLayoutY(QuadranglePane.getPrefHeight() / 2);

                    QuadranglePane.setMaxHeight(maxYAbs * 2 + 40);
                }
            }

            //quadrangle points
            Quadrangle.getPoints().setAll(
                    A[0] / i, -A[1] / i,
                    B[0] / i, -B[1] / i,
                    C[0] / i, -C[1] / i,
                    D[0] / i, -D[1] / i
            );
            A_txt.setX(A[0] / i);
            A_txt.setY(-A[1] / i);

            B_txt.setX(B[0] / i);
            B_txt.setY(-B[1] / i);

            C_txt.setX(C[0] / i);
            C_txt.setY(-C[1] / i);

            D_txt.setX(D[0] / i);
            D_txt.setY(-D[1] / i);

            //diagonals
            G_point.setCenterX(quad.quad_get_G()[0] / i);
            G_point.setCenterY(-quad.quad_get_G()[1] / i);
            G_txt.setLayoutX(G_point.getCenterX());
            G_txt.setLayoutY(G_point.getCenterY());

            d1.setStartX(A[0] / i);
            d1.setStartY(-A[1] / i);
            d1.setEndX(C[0] / i);
            d1.setEndY(-C[1] / i);
            d1_txt.setLayoutX((G_point.getCenterX()+d1.getStartX())/2);
            d1_txt.setLayoutY((G_point.getCenterY()+d1.getStartY())/2);

            d2.setStartX(B[0] / i);
            d2.setStartY(-B[1] / i);
            d2.setEndX(D[0] / i);
            d2.setEndY(-D[1] / i);
            d2_txt.setLayoutX((G_point.getCenterX()+d2.getStartX())/2);
            d2_txt.setLayoutY((G_point.getCenterY()+d2.getStartY())/2);


            //Oo points
            O_point.setCenterX(quad.quad_get_O(nodp)[0] / i);
            O_point.setCenterY(-quad.quad_get_O(nodp)[1] / i);
            O_txt.setLayoutX(O_point.getCenterX());
            O_txt.setLayoutY(O_point.getCenterY());

            o_point.setCenterX(quad.quad_get_o()[0] / i);
            o_point.setCenterY(-quad.quad_get_o()[1] / i);
            o_txt.setLayoutX(o_point.getCenterX());
            o_txt.setLayoutY(o_point.getCenterY());


            //circles
            InscribedCircle.setCenterX(quad.quad_get_o()[0] / i);
            InscribedCircle.setCenterY(-quad.quad_get_o()[1] / i);
            InscribedCircle.setRadius(quad.quad_get_r() / i);

            SircumscribedCircle.setCenterX(quad.quad_get_O(nodp)[0] / i);
            SircumscribedCircle.setCenterY(-quad.quad_get_O(nodp)[1] / i);
            SircumscribedCircle.setRadius(quad.quad_get_R() / i);

            //triangle sides/angles labels
            a_txt.setX((A[0] / i + B[0] / i)/2);
            a_txt.setY((-A[1] / i - B[1] / i)/2);
            b_txt.setX((B[0] / i + C[0] / i)/2);
            b_txt.setY((-B[1] / i - C[1] / i)/2);
            c_txt.setX((C[0] / i + D[0] / i)/2);
            c_txt.setY((-C[1] / i - D[1] / i)/2);
            d_txt.setX((D[0] / i + A[0] / i)/2);
            d_txt.setY((-D[1] / i - A[1] / i)/2);

            m_txt.setX(A_txt.getX() + 0.1 * (G_point.getCenterX() - A_txt.getX()));
            m_txt.setY(A_txt.getY() + 0.1 * (G_point.getCenterY() - A_txt.getY()));
            n_txt.setX(B_txt.getX() + 0.1 * (G_point.getCenterX() - B_txt.getX()));
            n_txt.setY(B_txt.getY() + 0.1 * (G_point.getCenterY() - B_txt.getY()));
            k_txt.setX(C_txt.getX() + 0.1 * (G_point.getCenterX() - C_txt.getX()));
            k_txt.setY(C_txt.getY() + 0.1 * (G_point.getCenterY() - C_txt.getY()));
            l_txt.setX(D_txt.getX() + 0.1 * (G_point.getCenterX() - D_txt.getX()));
            l_txt.setY(D_txt.getY() + 0.1 * (G_point.getCenterY() - D_txt.getY()));

            res1 = quad.quad_writer(res1, nodp);

        } catch (Exception e) {
            res1 = "Exception: " + e.getMessage();
            res1_txt.setStyle("-fx-text-fill: red");
        }
        res1_txt.setText(res1);
        QuadScrollPane.setHvalue(0.5);
        QuadScrollPane.setVvalue(0.5);
    }

    @FXML
    void CalcAP(ActionEvent event) {
        d_chb.setSelected(CalcAP_chb.isSelected());
        O_chb.setSelected(CalcAP_chb.isSelected());
        o_chb.setSelected(CalcAP_chb.isSelected());
        if (!h_chb.isDisable()) {
            h_chb.setSelected(CalcAP_chb.isSelected());
        }
    }

    @FXML
    void ShowO(ActionEvent event) {
        OGr.setVisible(ShowO_chb.isSelected());
    }

    @FXML
    void Showo(ActionEvent event) {
        oGr.setVisible(Showo_chb.isSelected());
    }

    @FXML
    void Showd(ActionEvent event) {
        DiagonalsGr.setVisible(Showd_chb.isSelected());
    }

    @FXML
    void SwitchQuad(ActionEvent event) {
        QuadSAPane.setDisable(!QuadSAPane.isDisabled());
        QuadSAPane.setVisible(!QuadSAPane.isVisible());
        QuadCoordsPane.setDisable(!QuadCoordsPane.isDisabled());
        QuadCoordsPane.setVisible(!QuadCoordsPane.isVisible());

        if (QuadSAPane.isVisible()) {
            SwitchQuadButton.setText("Switch to coordinates");
        } else {
            SwitchQuadButton.setText("Switch to sides/angles");
        }
    }

    @FXML
    void isPar(ActionEvent event) {
        h_chb.setDisable(!h_chb.isDisable());
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void openNewStage() {
        if (stage != null) {
            stage.setTitle("New Stage Title");

        }
    }

    @FXML
    private Button back_sq;


    @FXML
    void return_sq(ActionEvent event) {
        QuadCoordsPane.getScene().getWindow().hide();

    }



}