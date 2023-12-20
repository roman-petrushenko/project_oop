package org.example;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

import java.util.Arrays;
import java.util.Random;

public class EllipseController {

    private org.example.Ellipse ellipse1 = new org.example.Ellipse(200,100,0,0);

    int chordInd;

    double i=1;

    private Color generateRandomColor() {
        Random random = new Random();
        double red = random.nextDouble();
        double green = random.nextDouble();
        double blue = random.nextDouble();
        return new Color(red, green, blue, 1);
    }

    @FXML
    private TextField ACx1;

    @FXML
    private TextField ACx2;

    @FXML
    private TextField ACy1;

    @FXML
    private TextField ACy2;

    @FXML
    private Group ChordsGr;

    @FXML
    private ListView<org.example.Ellipse.Chord> ChordsList;

    @FXML
    private TextField CurEllipsePars;

    @FXML
    private Circle EllipseCenterOnPane;

    @FXML
    private Group EllipseGr;

    @FXML
    private Group EllipseGr1;

    @FXML
    private Ellipse EllipseOnPane;

    @FXML
    private AnchorPane EllipsePane;

    @FXML
    private ScrollPane EllipseScrollPane;

    @FXML
    private Line dirL;

    @FXML
    private Line dirR;

    @FXML
    private Line LOS1;

    @FXML
    private Line LOS2;

    @FXML
    private Circle foci1;

    @FXML
    private Circle foci2;

    @FXML
    private TextField LOSText;

    @FXML
    private TextField TLAPText;

    @FXML
    private TextField TLAPx;

    @FXML
    private TextField TLAPy;

    @FXML
    private TextField UCx1;

    @FXML
    private TextField UCx2;

    @FXML
    private TextField UCy1;

    @FXML
    private TextField UCy2;

    @FXML
    private TextField areaText;

    @FXML
    private TextField centerXText;

    @FXML
    private TextField centerYText;

    @FXML
    private TextField circumferenceText;

    @FXML
    private TextField dirText;

    @FXML
    private TextField eccText;

    @FXML
    private TextArea exceptionText;

    @FXML
    private TextField focalDistText;

    @FXML
    private TextField fociText;

    @FXML
    private TextField majorRadiusText;

    @FXML
    private TextField minorRadiusText;

    @FXML
    private Line xAxis;

    @FXML
    private Line yAxis;


    @FXML
    private void initialize() {
        yAxis.startXProperty().bind(EllipsePane.prefWidthProperty().divide(2));
        yAxis.startYProperty().bind(EllipsePane.layoutYProperty());

        yAxis.endXProperty().bind(EllipsePane.prefWidthProperty().divide(2));
        yAxis.endYProperty().bind(EllipsePane.layoutYProperty().add(EllipsePane.prefHeightProperty()));


        xAxis.startXProperty().bind(EllipsePane.layoutXProperty());
        xAxis.startYProperty().bind(EllipsePane.prefHeightProperty().divide(2));

        xAxis.endXProperty().bind(EllipsePane.layoutXProperty().add(EllipsePane.prefWidthProperty()));
        xAxis.endYProperty().bind(EllipsePane.prefHeightProperty().divide(2));

        ChordsList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                chordInd = ChordsList.getSelectionModel().getSelectedIndex();
            }
        });
    }

    @FXML
    void AddChord(ActionEvent event) {
        try {
            double x1 = Double.parseDouble(ACx1.getText());
            double y1 = Double.parseDouble(ACy1.getText());
            double x2 = Double.parseDouble(ACx2.getText());
            double y2 = Double.parseDouble(ACy2.getText());
            ellipse1.addChord(x1, y1, x2, y2);

            ChordsList.getItems().clear();
            ChordsList.getItems().addAll(ellipse1.getChords());

            Line line = new Line(x1/i, -y1/i, x2/i, -y2/i);
            line.setStroke(generateRandomColor());

            ChordsGr.getChildren().add(line);

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void RemoveChord(ActionEvent event) {
        try {
            ChordsGr.getChildren().remove(chordInd);

            ellipse1.removeChord(chordInd);

            ChordsList.getItems().clear();
            ChordsList.getItems().addAll(ellipse1.getChords());

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }

    }

    @FXML
    void TLAP(ActionEvent event) {
        try {
            double x = Double.parseDouble(TLAPx.getText());
            double y = Double.parseDouble(TLAPy.getText());
            TLAPText.setText(Arrays.toString(ellipse1.tangentLineAtPoint(x,y)));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void UpdChord(ActionEvent event) {
        try {
            double x1 = Double.parseDouble(UCx1.getText());
            double y1 = Double.parseDouble(UCy1.getText());
            double x2 = Double.parseDouble(UCx2.getText());
            double y2 = Double.parseDouble(UCy2.getText());

            ellipse1.updateChord(chordInd, x1, y1, x2, y2);

            Line chordToChange = (Line) ChordsGr.getChildren().get(chordInd);

            chordToChange.setStartX(x1/i);
            chordToChange.setStartY(-y1/i);
            chordToChange.setEndX(x2/i);
            chordToChange.setEndY(-y2/i);

            ChordsList.getItems().clear();
            ChordsList.getItems().addAll(ellipse1.getChords());

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcArea(ActionEvent event) {
        try {
            areaText.setText(Double.toString(ellipse1.area()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcCircumference(ActionEvent event) {
        try {
            circumferenceText.setText(Double.toString(ellipse1.circumference()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcEccentricity(ActionEvent event) {
        try {
            eccText.setText(Double.toString(ellipse1.eccentricity()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcFocalDistance(ActionEvent event) {
        try {
            focalDistText.setText(Double.toString(ellipse1.focalDistance()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getDirectrices(ActionEvent event) {
        try {
            double[][] n = ellipse1.getDirectrices();
            dirText.setText(Arrays.deepToString(n));
            dirL.setStartX(n[0][0]);
            dirL.setStartY(-1000);
            dirL.setEndX(n[0][0]);
            dirL.setEndY(0);
            dirR.setStartX(n[1][0]);
            dirR.setStartY(-1000);
            dirR.setEndX(n[1][0]);
            dirR.setEndY(0);
            dirL.setVisible(true);
            dirR.setVisible(true);
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getFoci(ActionEvent event) {
        try {
            double[][] n = ellipse1.getFoci();
            fociText.setText(Arrays.deepToString(n));
            foci1.setCenterX(n[0][0]);
            foci1.setCenterY(-n[0][1]);
            foci2.setCenterX(n[1][0]);
            foci2.setCenterY(-n[1][1]);
            foci1.setVisible(true);
            foci2.setVisible(true);
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void getLinesOfSymmetry(ActionEvent event) {
        try {
            double[][][] n = ellipse1.getLinesOfSymmetry();
            LOSText.setText(Arrays.deepToString(n));
            LOS1.setStartX(n[0][0][0]);
            LOS1.setStartY(-n[0][0][1]);
            LOS1.setEndX(n[0][1][0]);
            LOS1.setEndY(-n[0][1][1]);
            LOS2.setStartX(n[1][0][0]);
            LOS2.setStartY(-n[1][0][1]);
            LOS2.setEndX(n[1][1][0]);
            LOS2.setEndY(-n[1][1][1]);
            LOS1.setVisible(true);
            LOS2.setVisible(true);
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void setPars(ActionEvent event) {
        try {
            EllipsePane.setPrefSize(750,750);

            ChordsGr.setLayoutX(375);
            EllipseGr.setLayoutX(375);
            EllipseGr1.setLayoutX(375);

            ChordsGr.setLayoutY(375);
            EllipseGr.setLayoutY(375);
            EllipseGr1.setLayoutY(375);

            double x;
            double y;
            double R;
            double r;

            R = Double.parseDouble(majorRadiusText.getText());
            r = Double.parseDouble(minorRadiusText.getText());
            x = Double.parseDouble(centerXText.getText());
            y = Double.parseDouble(centerYText.getText());
            ellipse1.setRadius(R);
            ellipse1.setMinorRadius(r);
            ellipse1.setXCenter(x);
            ellipse1.setYCenter(y);

            double[] maxXArray = {Math.abs(ellipse1.getXCenter()), Math.abs(ellipse1.getRadius()*2)};
            double[] maxYArray = {Math.abs(ellipse1.getYCenter()), Math.abs(ellipse1.getRadius()*2)};

            double maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
            double maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

            i=1;

            if (maxXAbs<50) {
                i = maxXAbs / 700;
            }
            if (maxYAbs<50){
                i = maxYAbs/700;
            }
            maxXArray = new double[] {Math.abs(ellipse1.getXCenter())/i, Math.abs(ellipse1.getRadius()*2)/i};
            maxYArray = new double[] {Math.abs(ellipse1.getYCenter())/i, Math.abs(ellipse1.getRadius()*2)/i};

            maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
            maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

            if (maxXAbs >= EllipsePane.getPrefWidth() / 2) {
                EllipsePane.setPrefWidth(maxXAbs * 2 + 40);

                ChordsGr.setLayoutX(EllipsePane.getPrefWidth()/2);
                EllipseGr.setLayoutX(EllipsePane.getPrefWidth()/2);
                EllipseGr1.setLayoutX(EllipsePane.getPrefWidth()/2);

                EllipsePane.setMaxWidth(maxXAbs * 2 + 40);
            }
            if (maxYAbs >= EllipsePane.getPrefHeight() / 2) {
                EllipsePane.setPrefHeight(maxYAbs * 2 + 40);

                ChordsGr.setLayoutY(EllipsePane.getPrefHeight()/2);
                EllipseGr.setLayoutY(EllipsePane.getPrefHeight()/2);
                EllipseGr1.setLayoutY(EllipsePane.getPrefHeight()/2);

                EllipsePane.setMaxHeight(maxYAbs * 2 + 40);
            }

            EllipseOnPane.setCenterX(x/i);
            EllipseOnPane.setCenterY(-y/i);
            EllipseOnPane.setRadiusX(R/i);
            EllipseOnPane.setRadiusY(r/i);

            EllipseCenterOnPane.setCenterX(x/i);
            EllipseCenterOnPane.setCenterY(-y/i);

            LOS1.setVisible(false);
            LOS2.setVisible(false);
            dirL.setVisible(false);
            dirR.setVisible(false);
            foci1.setVisible(false);
            foci2.setVisible(false);

            EllipseScrollPane.setHvalue(0.5);
            EllipseScrollPane.setVvalue(0.5);

            CurEllipsePars.setText(ellipse1.toString());
            exceptionText.setText("");

            ChordsGr.getChildren().clear();

            ChordsList.getItems().clear();

            ellipse1.getChords().clear();

            areaText.setText("");
            circumferenceText.setText("");
            TLAPText.setText("");
            focalDistText.setText("");
            eccText.setText("");
            fociText.setText("");
            LOSText.setText("");
            dirText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

}