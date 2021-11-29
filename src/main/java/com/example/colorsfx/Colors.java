package com.example.colorsfx;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Colors extends VBox {

    private HBox redBox, greenBox, blueBox;
    private Label screen, redLabel, greenLabel, blueLabel, redVal, greenVal, blueVal;
    private Slider redSlider, greenSlider, blueSlider;
    private ColorsController controller;

    public Colors(){
        this.redBox = new HBox();
        this.greenBox = new HBox();
        this.blueBox = new HBox();
        this.screen = new Label();
        this.redLabel = new Label("R: ");
        this.greenLabel = new Label("G: ");
        this.blueLabel = new Label("B: ");
        this.redVal = new Label("0");
        this.greenVal = new Label("0");
        this.blueVal = new Label("0");
        this.redSlider = new Slider(0, 255, 0);
        this.greenSlider = new Slider(0, 255, 0);
        this.blueSlider = new Slider(0, 255, 0);
        this.controller = new ColorsController(screen, redVal, greenVal, blueVal, redSlider, greenSlider, blueSlider);
        
        initComponents();
    }

    private void initComponents() {

        screen.setAlignment(Pos.CENTER);
        screen.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        screen.setMinSize(0, 0);
        screen.prefHeightProperty().bind(this.heightProperty().divide(2));
        screen.prefWidthProperty().bind(this.widthProperty());

        redBox.setAlignment(Pos.CENTER);
        redBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        redBox.setMinSize(0,0);
        redBox.prefHeightProperty().bind(this.heightProperty().divide(2).divide(3));
        redBox.prefWidthProperty().bind(this.widthProperty());

        greenBox.setAlignment(Pos.CENTER);
        greenBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        greenBox.setMinSize(0,0);
        greenBox.prefHeightProperty().bind(this.heightProperty().divide(2).divide(3));
        greenBox.prefWidthProperty().bind(this.widthProperty());

        blueBox.setAlignment(Pos.CENTER);
        blueBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        blueBox.setMinSize(0,0);
        blueBox.prefHeightProperty().bind(this.heightProperty().divide(2).divide(3));
        blueBox.prefWidthProperty().bind(this.widthProperty());

        redLabel.setPrefWidth(20);
        greenLabel.setPrefWidth(20);
        blueLabel.setPrefWidth(20);
        redVal.setPrefWidth(20);
        greenVal.setPrefWidth(20);
        blueVal.setPrefWidth(20);
        redVal.setAlignment(Pos.BASELINE_CENTER);
        greenVal.setAlignment(Pos.BASELINE_CENTER);
        blueVal.setAlignment(Pos.BASELINE_CENTER);

        redSlider.prefWidthProperty().bind(this.widthProperty().subtract(redVal.getPrefWidth()*2));
        greenSlider.prefWidthProperty().bind(this.widthProperty().subtract(greenVal.getPrefWidth()*2));
        blueSlider.prefWidthProperty().bind(this.widthProperty().subtract(blueVal.getPrefWidth()*2));

        redBox.getChildren().addAll(redSlider, redLabel, redVal);
        greenBox.getChildren().addAll(greenSlider, greenLabel, greenVal);
        blueBox.getChildren().addAll(blueSlider, blueLabel, blueVal);
        this.getChildren().addAll(screen, redBox, greenBox, blueBox);
    }


}
