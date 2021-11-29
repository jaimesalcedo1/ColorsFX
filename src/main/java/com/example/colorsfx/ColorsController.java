package com.example.colorsfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ColorsController {

    private IntegerProperty valueRed, valueGreen, valueBlue;
    private Label screen, redVal, greenVal, blueVal;
    private Slider redSlider, greenSlider, blueSlider;

    public ColorsController(Label screen, Label redVal, Label greenVal, Label blueVal, Slider redSlider,
                            Slider greenSlider, Slider blueSlider){
        this.screen = screen;
        this.redVal = redVal;
        this.greenVal = greenVal;
        this.blueVal = blueVal;
        this.redSlider = redSlider;
        this.greenSlider = greenSlider;
        this.blueSlider = blueSlider;
        this.valueRed = new SimpleIntegerProperty();
        this.valueGreen = new SimpleIntegerProperty();
        this.valueBlue = new SimpleIntegerProperty();

        initColors();
    }

    private void initColors() {

        valueRed.bind(redSlider.valueProperty());
        valueGreen.bind(greenSlider.valueProperty());
        valueBlue.bind(blueSlider.valueProperty());

        redVal.textProperty().bind(valueRed.asString());
        greenVal.textProperty().bind(valueGreen.asString());
        blueVal.textProperty().bind(valueBlue.asString());

        valueRed.addListener(x -> changeColor());
        valueGreen.addListener(x -> changeColor());
        valueBlue.addListener(x -> changeColor());
    }

    private void changeColor() {
        screen.setBackground(new Background(new BackgroundFill(
                Color.rgb(valueRed.getValue(), valueGreen.getValue(), valueBlue.getValue()),
                CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
