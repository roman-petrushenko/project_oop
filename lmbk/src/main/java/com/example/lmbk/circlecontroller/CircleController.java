package com.example.lmbk.circlecontroller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;


public class CircleController {

    private Stage stage;

    private Circle circle1 = new Circle(200, 0, 0);

    int chordInd;

    int sectorInd;

    double i=1;

    private Color generateRandomColor(double o) {
        Random random = new Random();
        double red = random.nextDouble();
        double green = random.nextDouble();
        double blue = random.nextDouble();
        return new Color(red, green, blue, o);
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
    private TextField ASA;

    @FXML
    private ListView<Circle.Chord> ChordsList;

    @FXML
    private javafx.scene.shape.Circle CircleCenterOnPane;

    @FXML
    private Group CircleGr;

    @FXML
    private javafx.scene.shape.Circle CircleOnPane;

    @FXML
    private TextField CurCirclePars;

    @FXML
    private AnchorPane EllipsePane;

    @FXML
    private ScrollPane EllipseScrollPane;

    @FXML
    private ListView<Circle.Sector> SectorsList;

    @FXML
    private TextField UCx1;

    @FXML
    private TextField UCx2;

    @FXML
    private TextField UCy1;

    @FXML
    private TextField UCy2;

    @FXML
    private TextField USnewA;

    @FXML
    private TextField YN;

    @FXML
    private TextField areaText;

    @FXML
    private TextField centerXText;

    @FXML
    private TextField centerYText;

    @FXML
    private TextField ch1;

    @FXML
    private TextField ch2;

    @FXML
    private TextField circumferenceText;

    @FXML
    private TextField distText;

    @FXML
    private TextArea exceptionText;

    @FXML
    private TextField radiusText;

    @FXML
    private TextField sectorAreaText;

    @FXML
    private Line xAxis;

    @FXML
    private TextField xIsIn;

    @FXML
    private Line yAxis;

    @FXML
    private TextField yIsIn;

    @FXML
    private Group ChordsGr;

    @FXML
    private Group SectorsGr;

    @FXML
    private TextField distText1;


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

        SectorsList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                sectorInd = SectorsList.getSelectionModel().getSelectedIndex();
            }
        });
    }

    @FXML
    void setPars1(ActionEvent event) {
        try {
            double x;
            double y;
            double R;
            R = Double.parseDouble(radiusText.getText());

//            if (centerXText.getText().isEmpty() & centerYText.getText().isEmpty()) {
//                circle1 = circle1.createCircleWithNewRadius(R);
//            } else {
            x = Double.parseDouble(centerXText.getText());
            y = Double.parseDouble(centerYText.getText());
            circle1.setRadius(R);
            circle1.setXCenter(x);
            circle1.setYCenter(y);
//            }

            double[] maxXArray = {Math.abs(circle1.getXCenter()), Math.abs(circle1.getRadius()*2)};
            double[] maxYArray = {Math.abs(circle1.getYCenter()), Math.abs(circle1.getRadius()*2)};

            double maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
            double maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

            i=1;

            if (maxXAbs<50) {
                i = maxXAbs / 700;
            }
            if (maxYAbs<50){
                i = maxYAbs/700;
            }
            maxXArray = new double[] {Math.abs(circle1.getXCenter())/i, Math.abs(circle1.getRadius()*2)/i};
            maxYArray = new double[] {Math.abs(circle1.getYCenter())/i, Math.abs(circle1.getRadius()*2)/i};

            maxXAbs = Arrays.stream(maxXArray).max().getAsDouble();
            maxYAbs = Arrays.stream(maxYArray).max().getAsDouble();

            if (maxXAbs >= EllipsePane.getPrefWidth() / 2) {
                EllipsePane.setPrefWidth(maxXAbs * 2 + 40);

                CircleGr.setLayoutX(EllipsePane.getPrefWidth()/2);
                ChordsGr.setLayoutX(EllipsePane.getPrefWidth()/2);
                SectorsGr.setLayoutX(EllipsePane.getPrefWidth()/2);

                EllipsePane.setMaxWidth(maxXAbs * 2 + 40);
            }
            if (maxYAbs >= EllipsePane.getPrefHeight() / 2) {
                EllipsePane.setPrefHeight(maxYAbs * 2 + 40);

                CircleGr.setLayoutY(EllipsePane.getPrefHeight()/2);
                ChordsGr.setLayoutY(EllipsePane.getPrefHeight()/2);
                SectorsGr.setLayoutY(EllipsePane.getPrefHeight()/2);

                EllipsePane.setMaxHeight(maxYAbs * 2 + 40);
            }

            CircleOnPane.setCenterX(x/i);
            CircleOnPane.setCenterX(y/i);
            CircleOnPane.setRadius(R/i);

            CurCirclePars.setText(circle1.toString());
            exceptionText.setText("");

            ChordsGr.getChildren().clear();
            SectorsGr.getChildren().clear();

            ChordsList.getItems().clear();
            SectorsList.getItems().clear();

            circle1.chords.clear();
            circle1.sectors.clear();
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void AddChord(ActionEvent event) {
        try {
            double x1 = Double.parseDouble(ACx1.getText());
            double y1 = Double.parseDouble(ACy1.getText());
            double x2 = Double.parseDouble(ACx2.getText());
            double y2 = Double.parseDouble(ACy2.getText());
            circle1.addChord(x1, y1, x2, y2);

            ChordsList.getItems().clear();
            ChordsList.getItems().addAll(circle1.chords);

            Line line = new Line(x1/i, y1/i, x2/i, y2/i);
            line.setStroke(generateRandomColor(1));

            ChordsGr.getChildren().add(line);

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void AddSector(ActionEvent event) {
        try {
            double angle = Double.parseDouble(ASA.getText());

            double angle1 = Math.toDegrees(angle);

            circle1.addSector(angle);

            SectorsList.getItems().clear();
            SectorsList.getItems().addAll(circle1.sectors);

            Arc sector1 = new Arc(circle1.getXCenter()/i, circle1.getYCenter()/i,
                    circle1.getRadius(), circle1.getRadius(), 0, angle1);
            sector1.setType(ArcType.ROUND);
            sector1.setFill(generateRandomColor(0.25));

            SectorsGr.getChildren().add(sector1);

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void IsIn(ActionEvent event) {
        try {
            double x = Double.parseDouble(xIsIn.getText());
            double y = Double.parseDouble(yIsIn.getText());
            if (circle1.isInside(x, y)) {
                YN.setText("Yes");
                YN.setStyle("-fx-text-fill: green");
            } else {
                YN.setText("No");
                YN.setStyle("-fx-text-fill: red");
            }
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void RemoveChord(ActionEvent event) {
        try {
            circle1.removeChord(chordInd);

            ChordsList.getItems().clear();
            ChordsList.getItems().addAll(circle1.chords);

            ChordsGr.getChildren().remove(chordInd+1);

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void RemoveSector(ActionEvent event) {
        try {
            circle1.removeSector(sectorInd);

            SectorsList.getItems().clear();
            SectorsList.getItems().addAll(circle1.sectors);

            SectorsGr.getChildren().remove(sectorInd+1);

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

            circle1.updateChord(chordInd, x1, y1, x2, y2);

            Line chordToChange = (Line) ChordsGr.getChildren().get(chordInd);

            chordToChange.setStartX(x1/i);
            chordToChange.setStartY(y1/i);
            chordToChange.setEndX(x2/i);
            chordToChange.setEndY(y2/i);

            ChordsList.getItems().clear();
            ChordsList.getItems().addAll(circle1.chords);

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void UpdSector(ActionEvent event) {
        try {
            double angle = Double.parseDouble(USnewA.getText());

            double angle1 = Math.toDegrees(angle);

            circle1.updateSector(sectorInd, angle);

            SectorsList.getItems().clear();
            SectorsList.getItems().addAll(circle1.sectors);

            Arc sectorToChange = (Arc) SectorsGr.getChildren().get(sectorInd);

            sectorToChange.setLength(angle1);

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcArea(ActionEvent event) {
        try {
            areaText.setText(Double.toString(circle1.area()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcCircumference(ActionEvent event) {
        try {
            circumferenceText.setText(Double.toString(circle1.circumference()));
            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML//mklii
    void calcDistanceBetweenChords(ActionEvent event) {
        try {
            int ch1Ind = Integer.parseInt(ch1.getText());
            int ch2Ind = Integer.parseInt(ch2.getText());
            double x1 = circle1.getChord(ch1Ind).getX1();
            double y1 = circle1.getChord(ch1Ind).getY1();
            double x2 = circle1.getChord(ch1Ind).getX2();
            double y2 = circle1.getChord(ch1Ind).getY2();

            double x3 = circle1.getChord(ch2Ind).getX1();
            double y3 = circle1.getChord(ch2Ind).getY1();
            double x4 = circle1.getChord(ch2Ind).getX2();
            double y4 = circle1.getChord(ch2Ind).getY2();

            distText1.setText(Double.toString(circle1.distanceBetweenChords(x1, y1, x2, y2,
                    x3, y3, x4, y4)));

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcDistanceFromCenterToChord(ActionEvent event) {
        try {
            double x1 = circle1.getChord(chordInd).getX1();
            double y1 = circle1.getChord(chordInd).getY1();
            double x2 = circle1.getChord(chordInd).getX2();
            double y2 = circle1.getChord(chordInd).getY2();

            distText.setText(Double.toString(circle1.distanceFromCenterToChord(x1, y1, x2, y2)));

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    void calcSectorArea(ActionEvent event) {
        try {
            sectorAreaText.setText(Double.toString(circle1.areaOfSector(circle1.getSector(sectorInd).getCentralAngle())));

            exceptionText.setText("");
        } catch (Exception e) {
            exceptionText.setText("Exception: " + e.getMessage());
        }
    }

    public void setStage_cr(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void openNewStage_cr() {
        if (stage != null) {
            stage.setTitle("New Stage Title");

        }
    }

    @FXML
    private Button back_cr;

    @FXML
    void return_cr(ActionEvent event) {
        EllipsePane.getScene().getWindow().hide();

    }

}