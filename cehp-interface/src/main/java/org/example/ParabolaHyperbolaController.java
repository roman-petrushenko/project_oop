package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class ParabolaHyperbolaController {

    Parabola parabola1 = new Parabola(0.2,0,0,true);

    Hyperbola hyperbola1 = new Hyperbola(1,2,0.5,1);

    @FXML
    private TextField AEText;

    @FXML
    private TextField FDText;

    @FXML
    private TextField ALText;

    @FXML
    private TextField AOSText;

    @FXML
    private TextField CurParPars;

    @FXML
    private TextField HypEq;

    @FXML
    private TextField LRText;

    @FXML
    private TextField aText;

    @FXML
    private TextField aText1;

    @FXML
    private TextField asyText;

    @FXML
    private TextField bText;

    @FXML
    private TextField bText1;

    @FXML
    private TextField cText;

    @FXML
    private TextField dirText;

    @FXML
    private TextField eccText;

    @FXML
    private TextArea exceptionText;

    @FXML
    private TextField fociText;

    @FXML
    private TextField focusText;

    @FXML
    private TextField hText;

    @FXML
    private CheckBox isVert;

    @FXML
    private TextField kText;

    @FXML
    private TextField tgLineText;

    @FXML
    private TextField tgLineText1;

    @FXML
    private TextField tgLineX;

    @FXML
    private TextField tgLineX1;

    @FXML
    private TextField tgLineY;

    @FXML
    private TextField tgLineY1;

    @FXML
    private TextField vertexText;

    @FXML
    private TextField verticesText;

    @FXML
    private TextField x1Field;

    @FXML
    private TextField x_y1;

    @FXML
    private TextField y1Field;

    @FXML
    private TextField y_x1;


    @FXML
    void getEcc(ActionEvent event) {
        try {
            eccText.setText(Double.toString(hyperbola1.calculateEccentricity()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getAL(ActionEvent event) {
        try {
            ALText.setText(Arrays.toString(new double[] {hyperbola1.transverseAxisLength(),hyperbola1.conjugateAxisLength()}));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getFD(ActionEvent event) {
        try {
            FDText.setText(Double.toString(hyperbola1.focalDistance()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getAE(ActionEvent event) {
        try {
            AEText.setText(Arrays.deepToString(hyperbola1.calculateAxisEndpoints()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getAsy(ActionEvent event) {
        try {
            asyText.setText(Arrays.deepToString(hyperbola1.calculateAsymptotes()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getConjHyp(ActionEvent event) {
        try {
            hyperbola1 = hyperbola1.calculateConjugateHyperbola();

            double a = hyperbola1.getA();
            double b = hyperbola1.getB();
            double h = hyperbola1.getH();
            double k = hyperbola1.getK();

            String eq;
            if (hyperbola1.isVertical()){
                eq = "(y-"+k+")^2/"+b+"^2 - (x-"+h+")^2/"+a+"^2 = 1";
            }else{
                eq = "(x-"+h+")^2/"+a+"^2 - (y-"+k+")^2/"+b+"^2 = 1";
            }
            hText.setText(Double.toString(h));
            kText.setText(Double.toString(k));
            aText1.setText(Double.toString(a));
            bText1.setText(Double.toString(b));
            HypEq.setText(eq);
            fociText.setText("");
            ALText.setText("");
            FDText.setText("");
            AEText.setText("");
            asyText.setText("");
            verticesText.setText("");
            tgLineText1.setText("");
            eccText.setText("");
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getFoci(ActionEvent event) {
        try {
            fociText.setText(Arrays.deepToString(hyperbola1.calculateFoci()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getTgLine1(ActionEvent event) {
        try {
            double x = Double.parseDouble(tgLineX1.getText());
            double y = Double.parseDouble(tgLineY1.getText());
            tgLineText1.setText(Arrays.toString(hyperbola1.calculateTangentLine(x,y)));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getVertices(ActionEvent event) {
        try {
            verticesText.setText(Arrays.deepToString(hyperbola1.calculateVertices()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void setPars1(ActionEvent event) {
        try {
            double h = Double.parseDouble(hText.getText());
            double k = Double.parseDouble(kText.getText());
            double a = Double.parseDouble(aText1.getText());
            double b = Double.parseDouble(bText1.getText());
            hyperbola1.setH(h);
            hyperbola1.setK(k);
            hyperbola1.setA(a);
            hyperbola1.setB(b);

            String eq;
            if (hyperbola1.isVertical()){
                eq = "(y-"+k+")^2/"+b+"^2 - (x-"+h+")^2/"+a+"^2 = 1";
            }else{
                eq = "(x-"+h+")^2/"+a+"^2 - (y-"+k+")^2/"+b+"^2 = 1";
            }
            HypEq.setText(eq);
            fociText.setText("");
            ALText.setText("");
            FDText.setText("");
            AEText.setText("");
            asyText.setText("");
            verticesText.setText("");
            tgLineText1.setText("");
            eccText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getAOS(ActionEvent event) {
        try {
            AOSText.setText(Arrays.toString(parabola1.getAxisOfSymmetry()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getDir(ActionEvent event) {
        try {
            dirText.setText(Arrays.toString(parabola1.getDirectrix()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getFoc(ActionEvent event) {
        try {
            focusText.setText(Arrays.toString(parabola1.getFocus()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getLR(ActionEvent event) {
        try {
            LRText.setText(Arrays.deepToString(parabola1.getLatusRectum()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getTgLine(ActionEvent event) {
        try {
            double x = Double.parseDouble(tgLineX.getText());
            double y = Double.parseDouble(tgLineY.getText());

            tgLineText.setText(Arrays.toString(parabola1.getTangentLine(x, y)));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getVert(ActionEvent event) {
        try {
            vertexText.setText(Arrays.toString(parabola1.getVertex()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void setPars(ActionEvent event) {
        try {
            double a = Double.parseDouble(aText.getText());
            double b = Double.parseDouble(bText.getText());
            double c = Double.parseDouble(cText.getText());
            boolean vert = isVert.isSelected();

            parabola1 = new Parabola(a,b,c,vert);

            vertexText.setText("");
            focusText.setText("");
            dirText.setText("");
            AOSText.setText("");
            LRText.setText("");
            tgLineText.setText("");
            y_x1.setText("");
            x_y1.setText("");
            CurParPars.setText(parabola1.toString());
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getX1(ActionEvent event) {
        try {
            x_y1.setText(Double.toString(parabola1.getX(Double.parseDouble(y1Field.getText()))));
        } catch (Exception e) {
        exceptionText.setText("Exception: " + e.getMessage());
    }
    }

    @FXML
    void getY1(ActionEvent event) {
        try {
            y_x1.setText(Double.toString(parabola1.getY(Double.parseDouble(x1Field.getText()))));
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

}