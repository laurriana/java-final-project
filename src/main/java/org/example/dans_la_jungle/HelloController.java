package org.example.dans_la_jungle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    // labels
    @FXML
    private Label lionCount;
    @FXML
    private Label antilopeCount;
    @FXML
    private Label grassValue;

    @FXML
    private Label newbornLions;
    @FXML
    private Label newbornAntilopes;

    @FXML
    private Label currentYear;
    @FXML
    private Button startBtn;
    @FXML
    private Button slayBtn;

    // inputs
    @FXML
    private TextField lionBirthrate;
    @FXML
    private TextField antilopeBirthrate;
    @FXML
    private TextField grassBirthrate;

    private World world;


    // utility methods
    protected void refresh() {
        currentYear.setText(String.valueOf(world.getYear()));
        lionCount.setText(String.valueOf(world.getLionCount()));
        antilopeCount.setText(String.valueOf(world.getAntilopeCount()));
    }

    protected void disable(boolean lightSwitch) {
        startBtn.setDisable(lightSwitch);
        lionBirthrate.setDisable(lightSwitch);
        antilopeBirthrate.setDisable(lightSwitch);
        grassBirthrate.setDisable(lightSwitch);
        slayBtn.setDisable(!lightSwitch);
    }

    @FXML
    public void initialize() {
        slayBtn.setDisable(true);
    }

    @FXML
    protected void onYearBtnClick() {
        world.incrementYear();
        refresh();
    }

    @FXML
    protected void onResetBtnClick() {
        world.reset();
        refresh();

        disable(false);
    }

    @FXML
    protected void onStartBtnClick() {
        disable(true);

        // à revoir au cas où the user doesn't input a number
        int lionBirthRateValue = Integer.parseInt(lionBirthrate.getText());
        int antilopeBirthRateValue = Integer.parseInt(antilopeBirthrate.getText());
        int grassBirthRateValue = Integer.parseInt(grassBirthrate.getText());

        // nouvelle instance de monde
        world = new World(grassBirthRateValue);

        world.addAnimal("Lion", lionBirthRateValue);
        world.addAnimal("Antilope", antilopeBirthRateValue);

        // change the labels
        lionCount.setText(String.valueOf(lionBirthRateValue));
        antilopeCount.setText(String.valueOf(antilopeBirthRateValue));
        grassValue.setText(String.valueOf(grassBirthRateValue));

        // empty inputs
        lionBirthrate.setText("");
        antilopeBirthrate.setText("");
        grassBirthrate.setText("");

    }
}